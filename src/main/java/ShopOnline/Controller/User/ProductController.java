package ShopOnline.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ShopOnline.Service.User.IProductService;
import ShopOnline.Service.User.ProductService;

@Controller
public class ProductController extends BaseController{
	
	@Autowired
	private IProductService _productService;
	
	@RequestMapping(value = {"chi-tiet-san-pham/{id}"})
	public ModelAndView Index(@PathVariable long id) {
		_mvShare.setViewName("user/products/product");
		_mvShare.addObject("product", _productService.GetProductById(id));
		int idCategory =  _productService.GetProductById(id).getId_category();
		_mvShare.addObject("productByIdCategory", _productService.GetProductByIdCategory(idCategory));
		return _mvShare;
	}
	
}
