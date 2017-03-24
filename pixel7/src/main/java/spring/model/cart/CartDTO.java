package spring.model.cart;

public class CartDTO {
	private int 	cart_num    ;         
    private int 	img_num     ;         
    private String  id			;
    private String  cartid		;
    private String  cdate		;
    
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public int getCart_num() {
		return cart_num;
	}
	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
	}
	public int getImg_num() {
		return img_num;
	}
	public void setImg_num(int img_num) {
		this.img_num = img_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
