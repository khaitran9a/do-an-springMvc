package ShopOnline.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShopOnline.Dao.CategoriesDao;
import ShopOnline.Dao.MenusDao;
import ShopOnline.Dao.ProductsDao;
import ShopOnline.Dao.SlidesDao;
import ShopOnline.Dto.ProductsDto;
import ShopOnline.Entity.Categories;
import ShopOnline.Entity.Menus;
import ShopOnline.Entity.Slides;

@Service
public class HomeServiceImpl implements IHomeService {

	@Autowired
	private SlidesDao slidesDao;
	@Autowired
	private CategoriesDao categoriesDao;
	@Autowired
	private MenusDao menusDao;
	@Autowired
	private ProductsDao producDao;
	
	public List<Slides> GetDataSlide() {
		return slidesDao.GetDataSlide();
	}

	public List<Categories> GetDataCategory() {
		return categoriesDao.GetDataCategories();
	}
	
	public List<Menus> GetDataMenu() {
		return menusDao.GetDataMenus();
	}
	
	public List<ProductsDto> GetDataProduct() {
		List<ProductsDto>  listProducts = producDao.GetDataProducts();
		return listProducts;
	}
	
	public List<ProductsDto> GetDataNewProduct() {
		List<ProductsDto>  listProducts = producDao.GetNewDataProducts();
		return listProducts;
	}
	
	public List<ProductsDto> GetDataHighLightProduct() {
		List<ProductsDto>  listProducts = producDao.GetHighLightDataProducts();
		return listProducts;
	}
	
}
