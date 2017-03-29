package spring.sts.pixel7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.auction.AuctionDAO;
import spring.model.auction.AuctionDTO;
import spring.model.auction.Auction_biddingDAO;
import spring.model.auction.Auction_biddingDTO;
import spring.model.auction.Auction_moneyDAO;
import spring.model.auction.Auction_moneyDTO;
@Controller
public class Auction_biddingController {
	  @Autowired
	  private Auction_biddingDAO bid_dao;
	  @Autowired
	  private AuctionDAO dao;
	  @Autowired
	  private Auction_moneyDAO money_dao;
	  
	  	@RequestMapping(value="/Auction/tendering",method=RequestMethod.GET)
	  	public String bidRead(int auction_num,String id,Model model){
	  		AuctionDTO dto=new AuctionDTO();
	  		Auction_biddingDTO bdto=new Auction_biddingDTO();
	  		Map map=new HashMap(); 
	  		map.put("id", id);
	  		map.put("auction_num", auction_num);
	  		int bidmoneycheck=bid_dao.bidmoneycheck(auction_num);
	  		if(bidmoneycheck>0){
	  		List<Auction_biddingDTO> list=bid_dao.bidmoneylist(auction_num);
	  		model.addAttribute("bidmoney", list.get(0).getAuction_bidmoney());
	  		}
	  		dto=dao.read(auction_num);
	  		Auction_moneyDTO money_dto=money_dao.moneyRead(id);
	  		System.out.println(money_dto.getAuction_money());
	  		int bidmoneyCheck=bid_dao.bidmoneycheck(auction_num);
	  		model.addAttribute("bidmoneycheck", bidmoneyCheck);
	  		model.addAttribute("auction_dto",dto);
	  		model.addAttribute("money_dto",money_dto);
	  		return "/auction_bidding/tendering";
	  	}
	  	@RequestMapping(value="/Auction/tenderingProc",method=RequestMethod.POST)
	  	public String tendering(Model model,Auction_biddingDTO dto,String id,int auction_num){
	  		Map map=new HashMap();
	  		map.put("id", id);
	  		map.put("auction_bidmoney", dto.getAuction_bidmoney());
	  		map.put("auction_num",auction_num);
	  		int bidMoney=dto.getAuction_bidmoney();
	  		int checkId=bid_dao.checkId(auction_num);
	  		int idCheck=bid_dao.idCheck(map);
	  		if(idCheck==0){
	  			System.out.println("나호출");
	  			bid_dao.create(map);
	  		}
	  		System.out.println("bidMoney"+bidMoney);
	  		Map map2=new HashMap();
	  		map2.put("auction_bidmoney",bidMoney);
	  		map2.put("id",id);
	  		map2.put("auction_num", auction_num);
	  		dto=bid_dao.read(map);
	  		Map map3=new HashMap();
	  		map3.put("id",id);
	  		map3.put("auction_bidmoney",bidMoney);
	  		List<Auction_biddingDTO> beforeList=bid_dao.list(auction_num);
	  		int beforemoney=beforeList.get(0).getAuction_bidmoney();
	  		String beforeid=beforeList.get(0).getId();
	  		System.out.println("beforeId="+beforeid);
	  		Auction_moneyDTO mdto=money_dao.moneyRead(id);
	  		if(checkId>0&&dto.getAuction_num()==auction_num){
	  				bid_dao.update(map2);//리스트하기위한 update
	  				if(bid_dao.moneyUpdate(map3)){
	  					Map rollbackMoney=new HashMap();
	  					rollbackMoney.put("auction_money",beforemoney);
	  					rollbackMoney.put("id",beforeid);
	  					money_dao.moneyUpdate(rollbackMoney); 
	  					mdto=money_dao.moneyRead(id);
	  					model.addAttribute("updateMoney", mdto.getAuction_money());
	  				}
	  		}
	  		dto=bid_dao.read(map);
	  		model.addAttribute("id", id);
	  		model.addAttribute("auction_num",auction_num);
	  		model.addAttribute("dto", dto);
	  		
	  		return "/auction_bidding/tenderingProc";
	  	}
	  	@RequestMapping(value="/Auction/tenderingList")
	  	public String list(int auction_num,Model model){
	  		List<Auction_biddingDTO> list=bid_dao.list(auction_num);
	  		model.addAttribute("list",list);
	  		return "/auction_bidding/list";
	  	}
}
 