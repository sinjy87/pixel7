package spring.model.auction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionMGR {
	@Autowired
	private AuctionDAO dao;

//	public String closeTime(AuctionDTO dto,int auction_num){
//		System.out.println("zz");
//		dto=auction_dao.read(auction_num);
//		String closeTime=auction_dao.closeTimeRead(dto.getAuction_num());
//		if(closeTime==null){
//			auction_dao.time(auction_num);
//		}
//		Map map=new HashMap();
//		map.put("auction_num",dto.getAuction_num());
//		map.put("auction_time",dto.getAuction_time());
//		auction_dao.closeTime(map);
//		closeTime=auction_dao.closeTimeRead(auction_num);
//		dto.setAuction_time(closeTime);
//		return closeTime;
//	}
}
