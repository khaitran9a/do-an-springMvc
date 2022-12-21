package ShopOnline.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShopOnline.Dto.ProductsDto;
import ShopOnline.Entity.Categories;
import ShopOnline.Entity.Menus;
import ShopOnline.Entity.Slides;

@Service
public interface IHomeService {
	@Autowired
	public List<Slides> GetDataSlide();
	
	public List<Categories> GetDataCategory();
	
	public List<Menus> GetDataMenu();
	
	public List<ProductsDto> GetDataProduct();
	
}
