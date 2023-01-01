package ShopOnline.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import ShopOnline.Dto.ProductsDto;
import ShopOnline.Entity.Users;

@Service
public interface IAdminProductService {
	public List<ProductsDto> GetAllProducts();
	public ProductsDto GetProductById(long id);
	public List<ProductsDto> GetProductByIdCategory(int id);
	public int Addproduct(ProductsDto product);
}
