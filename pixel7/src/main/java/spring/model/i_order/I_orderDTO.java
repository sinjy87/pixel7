package spring.model.i_order;

public class I_orderDTO {
	 private int i_order_num            ;//주문번호
	 private int img_num                ;//상품번호
     private String id                    ;//회원ID
     private int i_order_total          ;//주문합계
     private int i_order_mileage        ;//마일리지(normal=3%, vip=5%)
     private String i_order_information   ;
     
	public int getI_order_num() {
		return i_order_num;
	}
	public void setI_order_num(int i_order_num) {
		this.i_order_num = i_order_num;
	}
	public int getImg_num() {
		return img_num;
	}
	public void setImg_num(int img_num) {
		this.img_num = img_num;
	}
	public int getI_order_total() {
		return i_order_total;
	}
	public void setI_order_total(int i_order_total) {
		this.i_order_total = i_order_total;
	}
	public int getI_order_mileage() {
		return i_order_mileage;
	}
	public void setI_order_mileage(int i_order_mileage) {
		this.i_order_mileage = i_order_mileage;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getI_order_information() {
		return i_order_information;
	}
	public void setI_order_information(String i_order_information) {
		this.i_order_information = i_order_information;
	}
}
