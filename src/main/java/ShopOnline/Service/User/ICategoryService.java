package ShopOnline.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import ShopOnline.Dto.ProductsDto;

@Service
public interface ICategoryService {
	public List<ProductsDto> GetAllProductsById(int id);
	
//	public List<ProductsDto> GetDataProductsPaginate(int id, int start, int totalPage);
}
