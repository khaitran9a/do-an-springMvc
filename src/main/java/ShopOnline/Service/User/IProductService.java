package ShopOnline.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import ShopOnline.Dto.ProductsDto;

@Service
public interface IProductService {
	public ProductsDto GetProductById(long id);
	public List<ProductsDto> GetProductByIdCategory(int id);
}
