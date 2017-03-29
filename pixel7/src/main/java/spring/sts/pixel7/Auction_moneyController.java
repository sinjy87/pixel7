package spring.sts.pixel7;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.auction.AuctionDAO;
import spring.model.auction.AuctionDTO;
import spring.model.auction.Auction_moneyDAO;
import spring.model.auction.Auction_moneyDTO;

@Controller
public class Auction_moneyController {
	@Autowired
	private Auction_moneyDAO dao;
	@RequestMapping(value = "/Auction/bid/moneyUpdate", method = RequestMethod.GET)
	public String moneyUpdate2(String id, Model model,int auction_num) {
		Auction_moneyDTO dto = new Auction_moneyDTO();
		System.out.println(id);
		System.out.println(dto.getAuction_money());
		int idCheck = dao.idCheck(id);
		System.out.println("idCheck"+idCheck);
		if (idCheck==0) {
			System.out.println("나호출");
			dao.moneyCreate(id);
		}
		dto = dao.moneyRead(id);
		model.addAttribute("id", dto.getId());
		model.addAttribute("money", dto.getAuction_money());
		model.addAttribute("auction_num",auction_num);
		return "/auction_money/moneyUpdate2";
	}

	@RequestMapping(value = "/Auction/bid/moneyUpdateProc", method = RequestMethod.POST)
	public String moneyUpdate2(Model model, String id, Auction_moneyDTO dto,int auction_num) {
		Map map = new HashMap();
		System.out.println("fromvalue=" + dto.getAuction_money());
		model.addAttribute("FormValue", dto.getAuction_money());
		map.put("id", id);
		map.put("auction_money", dto.getAuction_money());
		dto = dao.moneyRead(id);
		System.out.println("readvalue=" + dto.getAuction_money());
		model.addAttribute("ReadValue", dto.getAuction_money());
		dao.moneyUpdate(map);
		model.addAttribute("UpdateValue", dto.getAuction_money());
		model.addAttribute("id", id);
		model.addAttribute("auction_num",auction_num);
		return "/auction_money/moneyUpdateProc2";
	}
	@RequestMapping(value = "/Auction/moneyUpdate", method = RequestMethod.GET)
	public String moneyUpdate(String id, Model model) {
		Auction_moneyDTO dto = new Auction_moneyDTO();
		System.out.println(id);
		System.out.println(dto.getAuction_money());
		int idCheck = dao.idCheck(id);
		System.out.println("idCheck"+idCheck);
		if (idCheck==0) {
			System.out.println("나호출");
			dao.moneyCreate(id);
		}
		dto = dao.moneyRead(id);
		model.addAttribute("id", dto.getId());
		model.addAttribute("money", dto.getAuction_money());
		return "/auction_money/moneyUpdate";
	}

	@RequestMapping(value = "/Auction/moneyUpdateProc", method = RequestMethod.POST)
	public String moneyUpdate(Model model, String id, Auction_moneyDTO dto) {
		Map map = new HashMap();
		System.out.println("fromvalue=" + dto.getAuction_money());
		model.addAttribute("FormValue", dto.getAuction_money());
		map.put("id", id);
		map.put("auction_money", dto.getAuction_money());
		dto = dao.moneyRead(id);
		System.out.println("readvalue=" + dto.getAuction_money());
		model.addAttribute("ReadValue", dto.getAuction_money());
		dao.moneyUpdate(map);
		dto = dao.moneyRead(id);
		model.addAttribute("UpdateValue", dto.getAuction_money());
		model.addAttribute("id", id);
		return "/auction_money/moneyUpdateProc";
	}
}
