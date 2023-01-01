package ShopOnline.Dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import ShopOnline.Entity.MapperUsers;
import ShopOnline.Entity.Users;

@Repository
public class UsersDao extends BaseDao{
	
//	public List<Users> CheckEmail(Users user) {
//		StringBuffer  sql = new StringBuffer();
//		sql.append("SELECT ");
//		sql.append("user ");
//		sql.append("FROM ");
//		sql.append("users ");
//		sql.append("WHERE ");
//		sql.append("user = " +user.getUser() );
//		List<Users> list = new ArrayList<Users>();
//		
//		list = _jdbcTemplate.query(sql.toString(), new MapperUser());
//		
//		return list;
//	}

	public int AddAccount(Users user) {		
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO users ");
		sql.append("( ");
		sql.append(" user, ");
		sql.append(" password, ");
		sql.append(" display_name, ");
		sql.append(" address ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append(" ( ");
		sql.append("     '"+user.getUser()+"', ");
		sql.append("     '"+user.getPassword()+"', ");
		sql.append("    '"+user.getDisplay_name()+"', ");
		sql.append("     '"+user.getAddress()+"' ");                        
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
//	
//	public user GetUserByAccout(Users user) {			
//		String sql = sqlProductById(id);		
//		Users  user = _jdbcTemplate.queryForObject(sql, new MapperUser());
//		return user;
//		
//		
//		int insert = _jdbcTemplate.update(sql.toString());
//		return insert;
//	}
	
	public Users GetUserByAcc(Users user) {
		String sql = "SELECT * FROM users WHERE user = '"+user.getUser()+"'";
		
		try {	
			
			Users result = _jdbcTemplate.queryForObject(sql, new MapperUsers());
			return result;

		} catch (EmptyResultDataAccessException e) {
			return null;
		}		
	}
	


}
