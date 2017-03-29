package spring.model.auction;

import java.util.List;

public class Auction_biddingDTO {
  private String auction_btime;
  private int auction_bidmoney;
  private String id;
  private int auction_num;
  private int auction_money;
  private List<AuctionDTO> auctionList;
public List<AuctionDTO> getAuctionList() {
	return auctionList;
}
public void setAuctionList(List<AuctionDTO> auctionList) {
	this.auctionList = auctionList;
}
public int getAuction_money() {
	return auction_money;
}
public void setAuction_money(int auction_money) {
	this.auction_money = auction_money;
}
public String getAuction_btime() {
	return auction_btime;
}
public void setAuction_btime(String auction_btime) {
	this.auction_btime = auction_btime;
}
public int getAuction_bidmoney() {
	return auction_bidmoney;
}
public void setAuction_bidmoney(int auction_bidmoney) {
	this.auction_bidmoney = auction_bidmoney;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getAuction_num() {
	return auction_num;
}
public void setAuction_num(int auction_num) {
	this.auction_num = auction_num;
}
}
