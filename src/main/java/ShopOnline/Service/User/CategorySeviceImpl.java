package ShopOnline.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShopOnline.Dao.ProductsDao;
import ShopOnline.Dto.ProductsDto;

@Service
public class CategorySeviceImpl implements ICategoryService {

	@Autowired
	private ProductsDao productsDao;
	
	public List<ProductsDto> GetAllProductsById(int id) {
		List<ProductsDto> productsDtos = productsDao.GetAllProductsById(id);
		return productsDtos;
	}
	
	public List<ProductsDto> GetDataProductsPaginate(int id, int start, int totalPage) {
		List<ProductsDto> productsDtos = productsDao.GetDataProductsPaginate(id, start, totalPage); 
		return productsDtos;
	}

	

}
