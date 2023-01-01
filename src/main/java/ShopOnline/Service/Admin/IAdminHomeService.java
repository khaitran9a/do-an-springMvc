package ShopOnline.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import ShopOnline.Entity.Categories;
@Service
public interface IAdminHomeService {
	public List<Categories> GetDataCategory();
}
