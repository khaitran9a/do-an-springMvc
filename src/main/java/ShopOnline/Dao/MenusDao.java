package ShopOnline.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ShopOnline.Entity.MapperMenus;
import ShopOnline.Entity.Menus;

@Repository
public class MenusDao extends BaseDao {
	
	public List<Menus> GetDataMenus() {
		List<Menus> list = new ArrayList<Menus>();
		String sql = "SELECT * FROM menus";
		list = _jdbcTemplate.query(sql, new MapperMenus());
		return list;
	}
	
//	public static void main(String[] args) {
//		SlidesDao homeDao = new SlidesDao();
//		List<Slides> list = homeDao.GetDataSlide();					
//	}
}
