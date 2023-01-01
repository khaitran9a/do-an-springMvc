package ShopOnline.Dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ShopOnline.Dto.ProductsDto;
import ShopOnline.Dto.ProductsDtoMapper;
import ShopOnline.Entity.Users;

@Repository
public class ProductsDao extends BaseDao{
	
	private final boolean YES = true;
	private final boolean NO = false;
	
	private StringBuffer sqlString() {
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id as id_product ");
		sql.append(", p.id_category ");
		sql.append(", p.sizes ");
		sql.append(", p.name ");
		sql.append(", p.price ");
		sql.append(", p.sale ");
		sql.append(", p.title ");
		sql.append(", p.highlight ");
		sql.append(", p.new_product ");
		sql.append(", p.details ");
		sql.append(", c.id as id_color ");
		sql.append(", c.name as name_color ");
		sql.append(", c.code as code_color ");
		sql.append(", p.image ");
		sql.append(", p.created_at ");
		sql.append(", p.updated_at ");
		sql.append(", ct.name as name_category ");
		sql.append("FROM ");
		sql.append("products AS p ");
		sql.append("INNER JOIN ");
		sql.append("colors AS c ");
		sql.append("ON p.id = c.id_product ");
		sql.append("INNER JOIN ");
		sql.append("categories AS ct ");
		sql.append("ON p.id_category = ct.id ");
		
		return sql;
	}
	
	private String sqlProducts(boolean newProduct, boolean highLight) {
		StringBuffer sql =  sqlString();
		
		sql.append("WHERE 1 = 1 ");
		if (highLight) {
			sql.append("AND p.highlight = true ");
		}
		if (newProduct) {
			sql.append("AND p.new_product = true ");
		}
		sql.append("GROUP BY p.id, c.id_product ");
		sql.append("ORDER BY RAND() ");
		if (highLight) {
			sql.append(" LIMIT 6 ");
		}
		if (newProduct) {
			sql.append("LIMIT 8 ");
		}
		return sql.toString();
		
	}
	
	private StringBuffer sqlProductsById(int id) {
		StringBuffer sql =  sqlString();
		
		sql.append("WHERE 1 = 1 ");
		sql.append("AND id_category = " + id + " ");
		
		return sql;
		
	}
	
	private String sqlProductsPaginate(int id, int start, int totalPage) {
		StringBuffer sql =  sqlProductsById(id);
		sql.append(" LIMIT " + start + ", " + totalPage);
		
		return sql.toString();
		
	}
	
	public List<ProductsDto> GetDataProducts() {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql =  sqlProducts(NO, NO);
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}
	
	public List<ProductsDto> GetNewDataProducts() {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql =  sqlProducts(YES, NO);
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}
	
	public List<ProductsDto> GetHighLightDataProducts() {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql =  sqlProducts(NO, YES);
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}
	
	public List<ProductsDto> GetAllProductsById(int id) {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql =  sqlProductsById(id).toString();
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}
	
	public List<ProductsDto> GetDataProductsPaginate( int id, int start, int totalPage) {
		
		String sqlGetDataByIdBuffer = sqlProductsById(id).toString();
		List<ProductsDto> listById = new ArrayList<ProductsDto>();
		listById = _jdbcTemplate.query(sqlGetDataByIdBuffer, new ProductsDtoMapper());
		
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		if(listById.size() > 0) {
			String sql =  sqlProductsPaginate(id, start, totalPage);
			list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		}
		return list;
	}
	
	private String sqlProductById(long id) {
		StringBuffer sql =  sqlString();		
		sql.append("WHERE 1 = 1 ");
		sql.append("AND  p.id = " + id + " ");
		sql.append("LIMIT 1 ");
		
		return sql.toString();
		
	}

	public List<ProductsDto> GetProductById(long id) {
		String sql = sqlProductById(id);		
		List<ProductsDto> product = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return product;
	}
	
	public ProductsDto FindProductById(long id) {
		String sql = sqlProductById(id);		
		ProductsDto product = _jdbcTemplate.queryForObject(sql, new ProductsDtoMapper());
		return product;
	}
	
	
private StringBuffer adminSqlString() {
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id as id_product ");
		sql.append(", p.id_category ");
		sql.append(", p.sizes ");
		sql.append(", p.name ");
		sql.append(", p.price ");
		sql.append(", p.sale ");
		sql.append(", p.title ");
		sql.append(", p.highlight ");
		sql.append(", p.new_product ");
		sql.append(", p.details ");
		sql.append(", c.id as id_color ");
		sql.append(", c.name as name_color ");
		sql.append(", c.code as code_color ");
		sql.append(", p.image ");
		sql.append(", p.created_at ");
		sql.append(", p.updated_at ");
		sql.append(", ct.name as name_category ");
		sql.append("FROM ");
		sql.append("products AS p ");
		sql.append("INNER JOIN ");
		sql.append("colors AS c ");
		sql.append("ON p.id = c.id_product ");
		sql.append("INNER JOIN ");	
		sql.append("categories AS ct ");
		sql.append("ON p.id_category = ct.id ");
		sql.append("ORDER BY p.id ASC ");
		
		return sql;
	}

	public List<ProductsDto> GetAllProducts() {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql =  adminSqlString().toString();
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}
	
	public int AddProduct(ProductsDto product ) {
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO products ");
		sql.append("( ");
		sql.append("    id_category, ");
		sql.append("    name, ");
		sql.append("    price, ");
		sql.append("    title, ");
		sql.append("    highlight, ");
		sql.append("    new_product, ");
		sql.append("    details, ");
		sql.append("    created_at, ");
		sql.append("    updated_at, ");
		sql.append("    image ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("    "+product.getId_category()+", ");
		sql.append("    '"+product.getName()+"', ");
		sql.append("    "+product.getPrice()+", ");
		sql.append("    '"+product.getTitle()+ "', ");
		sql.append("    "+1+", ");
		sql.append("    "+1+", ");
		sql.append("    '"+product.getDetails()+"', ");
		sql.append("    '"+currentTime+"', ");
		sql.append("    '"+currentTime+"', ");
		sql.append("    '"+product.getImage()+"' ");
		sql.append(")");
		
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	
	
}
