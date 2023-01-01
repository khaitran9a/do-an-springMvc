package ShopOnline.Service.Admin;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShopOnline.Dao.ProductsDao;
import ShopOnline.Dto.ProductsDto;

@Service
public class AdminProductServiceImpl implements IAdminProductService{
	@Autowired
	ProductsDao productsDao = new ProductsDao();

	public List<ProductsDto> GetAllProducts() {
		return productsDao.GetAllProducts();
	}

	public ProductsDto GetProductById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProductsDto> GetProductByIdCategory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int Addproduct(ProductsDto product) {
		
		return productsDao.AddProduct(product);	
	}

	
}
