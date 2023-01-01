package ShopOnline.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShopOnline.Dao.CategoriesDao;
import ShopOnline.Entity.Categories;

@Service
public class AdminHomeServiceImpl implements IAdminHomeService{
	@Autowired
	private CategoriesDao categoriesDao;

	public List<Categories> GetDataCategory() {
		return categoriesDao.GetDataCategories();
	}
}
