package ShopOnline.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ShopOnline.Entity.Categories;
import ShopOnline.Entity.MapperCategories;

@Repository
public class CategoriesDao extends BaseDao {
	

	public List<Categories> GetDataCategories() {
		List<Categories> list = new ArrayList<Categories>();
		String sql = "SELECT * FROM categories";
		list = _jdbcTemplate.query(sql, new MapperCategories());
		return list;
	}
	
//	public static void main(String[] args) {
//		SlidesDao homeDao = new SlidesDao();
//		List<Slides> list = homeDao.GetDataSlide();					
//	}
}
