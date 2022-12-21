package ShopOnline.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ShopOnline.Dto.PaginatesDto;
import ShopOnline.Service.User.CategorySeviceImpl;
import ShopOnline.Service.User.PaginateServiceImpl;

@Controller
public class CategoryController extends BaseController {

	@Autowired
	private CategorySeviceImpl categorySevice;
	@Autowired
	private PaginateServiceImpl paginateService;
	
	private int totalProductsPage = 6;

	@RequestMapping(value = { "/san-pham/{id}" })
	public ModelAndView Product(@PathVariable String id) {
		_mvShare.setViewName("user/products/category");
		int totalData = categorySevice.GetAllProductsById(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, 1);
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categorySevice.GetDataProductsPaginate(Integer.parseInt(id), paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
	
	@RequestMapping(value = { "/san-pham/{id}/{currentPage}" })
	public ModelAndView Product(@PathVariable String id,@PathVariable String currentPage) {
		_mvShare.setViewName("user/products/category");
		int totalData = categorySevice.GetAllProductsById(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, Integer.parseInt(currentPage));
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);		
		_mvShare.addObject("productsPaginate", categorySevice.GetDataProductsPaginate(Integer.parseInt(id), paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
}
