package ShopOnline.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ShopOnline.Dto.CartDto;
import ShopOnline.Dto.ProductsDto;

@Repository
public class CartDao extends BaseDao {

	@Autowired
	ProductsDao productsDao = new ProductsDao();

	public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart) {
		CartDto itemCart = new CartDto();
		ProductsDto product = productsDao.FindProductById(id);

		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() + 1);
			itemCart.setTotalprice(itemCart.getQuantity() * itemCart.getProduct().getPrice());
			
		}
		else {
			itemCart.setProduct(product);
			itemCart.setQuantity(1);
			itemCart.setTotalprice(product.getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDto> EditCart(long id, int quantity, HashMap<Long, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		ProductsDto product = productsDao.FindProductById(id);
		CartDto itemCart = new CartDto();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(quantity);
			Double totalPrice = quantity * itemCart.getProduct().getPrice();
			itemCart.setTotalprice(totalPrice);
		}

		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDto> DeleteCart(long id, HashMap<Long, CartDto> cart) {

		if (cart == null) {
			return cart;
		}

		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	public int TotalQuantity(HashMap<Long, CartDto> cart) {
		int totalQuantity = 0;
		for(Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {
			totalQuantity += itemCart.getValue().getQuantity();
		}
		return totalQuantity;
	}
	
	public double TotalPrice(HashMap<Long, CartDto> cart) {
		double totalPrice = 0;	
		for(Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalprice();
		}
		return totalPrice;
	
	}

}
