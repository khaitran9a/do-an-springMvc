package ShopOnline.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBills implements RowMapper<Bills> {
	public Bills mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Bills bills = new Bills();
		bills.setId(rs.getLong("id"));
		bills.setUser(rs.getString("user"));
		bills.setPhone(rs.getString("phone"));
		bills.setDisplay_name(rs.getString("display_name"));
		bills.setAddress(rs.getString("address"));
		bills.setTotal(rs.getDouble("total"));
		bills.setQuantity(rs.getInt("quantity"));
		bills.setNote(rs.getString("note"));
		return bills;
	}
}
