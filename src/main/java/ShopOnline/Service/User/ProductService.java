package ShopOnline.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShopOnline.Dao.ProductsDao;
import ShopOnline.Dto.ProductsDto;

@Service
public class ProductService implements IProductService {

	@Autowired
	ProductsDao productsDao = new ProductsDao();

	public ProductsDto GetProductById(long id) {
		List<ProductsDto> listproducts = productsDao.GetProductById(id);		
		return listproducts.get(0);
	}

	public List<ProductsDto> GetProductByIdCategory(int id) {
		
		return productsDao.GetAllProductsById(id);
	}

}
