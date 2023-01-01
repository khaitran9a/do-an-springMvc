package ShopOnline.Controller.User;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ShopOnline.Entity.Users;
import ShopOnline.Service.User.AccountServiceImpl;

@Controller
public class UserController extends BaseController {
	
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();
	
	
	@RequestMapping(value = "dang-ky", method = RequestMethod.GET)
	public ModelAndView Register() {
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("user", new Users());
		return _mvShare;	
	}
	
	
	@RequestMapping(value = "dang-ky", method = RequestMethod.POST)
	public ModelAndView CreatAcc(@ModelAttribute("user") Users users) {
		boolean check = accountService.CheckUserName(users);
		if(check == true) {
			_mvShare.addObject("status", "Email Hợp lệ!");
			int count = accountService.AddAccount(users);
			_mvShare.setViewName("user/account/login");
			
		} else {
			_mvShare.addObject("status", "Email đã tồn tại, mời nhập lại!");
			_mvShare.setViewName("user/account/register");			
		}
		
		
//		if(count > 0) {
//			//_mvShare.addObject("status", "Đăng ký tài khoản thành công!");
//		} else {
//			_mvShare.addObject("status", "Đăng ký tài khoản thất bại!");
//		}
//		_mvShare.setViewName("user/account/register");
////		_mvShare.addObject("status", true);
		return _mvShare;	
	}
	
	@RequestMapping(value = "dang-nhap", method = RequestMethod.GET)
	public ModelAndView DangNhap() {
		_mvShare.setViewName("user/account/login");
		_mvShare.addObject("user", new Users());
		return _mvShare;	
	}
	
	
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session,@ModelAttribute("user") Users user) {
		user = accountService.CheckAccount(user);
		
		if(user != null) {			
			_mvShare.setViewName("redirect:/trang-chu");
			session.setAttribute("LoginInfo", user);
		} else {
			_mvShare.addObject("statusLogin", "Đăng nhập thất bại!");
		}
		
		
		return _mvShare;
	}
	

	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public ModelAndView LogOut(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("LoginInfo");
				
		return _mvShare;	
	}
}
