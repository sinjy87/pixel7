package spring.model.auction;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class AuctionDTO {
     private int auction_num; //积己锅龋
     private String auction_title;//力格
     private String auction_content;//
     private MultipartFile fileMF;
     private String auction_item;
     private int auction_smoney;
     private int auction_bmoney;//溜备啊
     private String auction_time;
     private String auction_stime;
     private String auction_ctime;
     private String id="admin";
     private List<Auction_biddingDTO> auction_biddingList;
     
	public List<Auction_biddingDTO> getAuction_biddingList() {
		return auction_biddingList;
	}
	public void setAuction_biddingList(List<Auction_biddingDTO> auction_biddingList) {
		this.auction_biddingList = auction_biddingList;
	}
	public int getAuction_num() {
		return auction_num;
	}
	public void setAuction_num(int auction_num) {
		this.auction_num = auction_num;
	}
	public String getAuction_title() {
		return auction_title;
	}
	public void setAuction_title(String auction_title) {
		this.auction_title = auction_title;
	}
	public String getAuction_content() {
		return auction_content;
	}
	public void setAuction_content(String auction_content) {
		this.auction_content = auction_content;
	}
	public MultipartFile getFileMF() {
		return fileMF;
	}
	public void setFileMF(MultipartFile fileMF) {
		this.fileMF = fileMF;
	}
	public String getAuction_item() {
		return auction_item;
	}
	public void setAuction_item(String auction_item) {
		this.auction_item = auction_item;
	}
	public int getAuction_smoney() {
		return auction_smoney;
	}
	public void setAuction_smoney(int auction_smoney) {
		this.auction_smoney = auction_smoney;
	}
	public int getAuction_bmoney() {
		return auction_bmoney;
	}
	public void setAuction_bmoney(int auction_bmoney) {
		this.auction_bmoney = auction_bmoney;
	}
	
	public String getAuction_time() {
		return auction_time;
	}
	public void setAuction_time(String auction_time) {
		this.auction_time = auction_time;
	}
	public String getAuction_stime() {
		return auction_stime;
	}
	public void setAuction_stime(String auction_stime) {
		this.auction_stime = auction_stime;
	}
	public String getAuction_ctime() {
		return auction_ctime;
	}
	public void setAuction_ctime(String auction_ctime) {
		this.auction_ctime = auction_ctime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
     
}
