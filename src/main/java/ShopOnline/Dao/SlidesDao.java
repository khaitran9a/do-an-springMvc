package ShopOnline.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ShopOnline.Entity.MapperSlides;
import ShopOnline.Entity.Slides;

@Repository
public class SlidesDao extends BaseDao {
	
	public List<Slides> GetDataSlide() {
		List<Slides> list = new ArrayList<Slides>();
		String sql = "SELECT * FROM tb_slide";
		list = _jdbcTemplate.query(sql, new MapperSlides());
		return list;
	}
	
//	public static void main(String[] args) {
//		SlidesDao homeDao = new SlidesDao();
//		List<Slides> list = homeDao.GetDataSlide();					
//	}
}
