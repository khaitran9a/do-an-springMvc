package ShopOnline.Controller.User;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{
	
//	@Autowired
//	HomeServiceImpl homeService;
	
	@RequestMapping(value = {"/", "/trang-chu"})
	public ModelAndView Index() {
//		ModelAndView mv = new ModelAndView("user/index");
		_mvShare.addObject("tb_slide",_homeService.GetDataSlide());
//		_mvShare.addObject("categories",_homeService.GetDataCategory());
		_mvShare.addObject("products",_homeService.GetDataProduct());
		_mvShare.addObject("newProducts",_homeService.GetDataNewProduct());
		_mvShare.addObject("highLightsProducts",_homeService.GetDataHighLightProduct());
		_mvShare.setViewName("user/index");
//		_mvShare.setViewName("user/products/product");
		return _mvShare;
	}
	

	
}