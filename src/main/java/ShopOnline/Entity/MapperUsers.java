package ShopOnline.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUsers implements RowMapper<Users> {
	
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Users users = new Users();
		users.setId(rs.getLong("id"));
		users.setUser(rs.getString("user"));
		users.setPassword(rs.getString("password"));
		users.setDisplay_name(rs.getString("display_name"));
		users.setAddress(rs.getString("address"));
		return users;
	}
}
