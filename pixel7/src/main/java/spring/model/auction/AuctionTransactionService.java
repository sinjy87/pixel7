package spring.model.auction;

import java.io.File;
import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import spring.utility.pixel7.Utility;

@Service
public class AuctionTransactionService {
	@Autowired
	private AuctionDAO dao;
	@Autowired
	private Auction_biddingDAO bdao;
	@Autowired
	private Auction_successDAO sdao;
	@Autowired
	private Utility util;
	public void dc(Map tmap)throws Exception{
		int auction_num=(Integer)tmap.get("auction_num");
		String auction_item=(String)tmap.get("auction_item");
		File file=new File("./storage/success");
		
		MultipartFile fileMf;
		System.out.println(file.getCanonicalPath()); 
		System.out.println("sv.num"+auction_num);
		System.out.println("sv.item"+auction_item);
//		System.out.println(upDir); 
		System.out.println(auction_item.length());
		if(auction_item.length()>0){
//			util.saveFile(auction_item, upDir);
		}
//		bdao.delete(auction_num);
//		dao.delete(auction_num);
	}
}
