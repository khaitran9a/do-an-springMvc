package ShopOnline.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ShopOnline.Dto.ProductsDto;
import ShopOnline.Service.Admin.AdminProductServiceImpl;

@Controller
public class AdminProductController extends AdminBaseController {

	@Autowired
	private AdminProductServiceImpl adminProductService = new AdminProductServiceImpl();

	@RequestMapping(value = { "/quan-tri/danh-sach-san-pham" })
	public ModelAndView Index() {

		_mvShare.setViewName("admin/products/danhsach");
		_mvShare.addObject("products", adminProductService.GetAllProducts());
		return _mvShare;
	}
	

	
	@RequestMapping(value = { "/quan-tri/add-product" }, method = RequestMethod.GET)
	public ModelAndView AddProduct() {
		_mvShare.addObject("product", new ProductsDto());
		_mvShare.setViewName("admin/products/add-product");
		_mvShare.addObject("products", adminProductService.GetAllProducts());
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/add-product", method = RequestMethod.POST)
	public ModelAndView CreatAcc(@ModelAttribute("product")ProductsDto productsDto) {	
			_mvShare.addObject("status", "Email Hợp lệ!");
			adminProductService.Addproduct(productsDto);
			_mvShare.setViewName("admin/products/danhsach");
		
		return _mvShare;
	}

}
