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
	public void dc(Map tmap)throws Exception{
		int auction_num=(Integer)tmap.get("auction_num");
		bdao.delete(auction_num);
		dao.delete(auction_num);
	}
}
