package ShopOnline.Dto;

public class CartDto {
	private int quantity;
	private double totalprice;
	private	ProductsDto product;
	
	public CartDto() {
	
	}
	
	public CartDto(int quantity, double totalprice, ProductsDto product) {
		this.quantity = quantity;
		this.totalprice = totalprice;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getTotalprice() {
		return totalprice;
	}
	
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	
	public ProductsDto getProduct() {
		return product;
	}
	
	public void setProduct(ProductsDto product) {
		this.product = product;
	}
	
	
}
