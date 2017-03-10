package spring.model.img_item;

import org.springframework.web.multipart.MultipartFile;

public class Img_itemDTO {
	private int img_num;
	private String img_photo;
	private String img_content;
	private String img_date;
	private int img_like;
	private int img_ban;
	private String img_price;
	private String img_category;
	private int img_viewcnt;
	private String id;
	private MultipartFile fileMF;
	private int filesize;

	public MultipartFile getFileMF() {
		return fileMF;
	}

	public void setFileMF(MultipartFile fileMF) {
		this.fileMF = fileMF;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public int getImg_num() {
		return img_num;
	}

	public void setImg_num(int img_num) {
		this.img_num = img_num;
	}

	public String getImg_photo() {
		return img_photo;
	}

	public void setImg_photo(String img_photo) {
		this.img_photo = img_photo;
	}

	public String getImg_content() {
		return img_content;
	}

	public void setImg_content(String img_content) {
		this.img_content = img_content;
	}

	public String getImg_date() {
		return img_date;
	}

	public void setImg_date(String img_date) {
		this.img_date = img_date;
	}

	public int getImg_like() {
		return img_like;
	}

	public void setImg_like(int img_like) {
		this.img_like = img_like;
	}

	public int getImg_ban() {
		return img_ban;
	}

	public void setImg_ban(int img_ban) {
		this.img_ban = img_ban;
	}

	public String getImg_price() {
		return img_price;
	}

	public void setImg_price(String img_price) {
		this.img_price = img_price;
	}

	public String getImg_category() {
		return img_category;
	}

	public void setImg_category(String img_category) {
		this.img_category = img_category;
	}

	public int getImg_viewcnt() {
		return img_viewcnt;
	}

	public void setImg_viewcnt(int img_viewcnt) {
		this.img_viewcnt = img_viewcnt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
