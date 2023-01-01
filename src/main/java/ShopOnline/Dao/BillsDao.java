package ShopOnline.Dao;

import ShopOnline.Entity.Bills;

public class BillsDao extends BaseDao{
	
	public int AddBills(Bills bills) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO bills ");
		sql.append("( ");
		sql.append("   user  , ");
		sql.append("   phone  , ");
		sql.append("   display_name  , ");
		sql.append("   address  , ");
		sql.append("   total  , ");
		sql.append("   quantity  , ");
		sql.append("   note ");
		sql.append(") VALUES ");
		sql.append("( ");
		sql.append("     '"+bills.getUser()+"', ");
		sql.append("     '"+bills.getPhone()+"', ");
		sql.append("     '"+bills.getDisplay_name()+"', ");
		sql.append("     '"+bills.getAddress()+"', ");
		sql.append("     '"+bills.getTotal()+"', ");
		sql.append("     '"+bills.getQuantity()+"', ");
		sql.append("     '"+bills.getNote()+"' ");
		sql.append(")");
		
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public long GetIdLastBills() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MAX(id) FROM bills; ");
		//long id = _jdbcTemplate.queryForObject(sql.toString(), new Object[], Long.class);
		return 1;
	}
}
