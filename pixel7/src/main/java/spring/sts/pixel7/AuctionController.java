package spring.sts.pixel7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.model.auction.AuctionDAO;
import spring.model.auction.AuctionDTO;
import spring.model.auction.AuctionTransactionService;
import spring.model.auction.Auction_biddingDAO;
import spring.model.auction.Auction_biddingDTO;
import spring.utility.pixel7.Utility;

@Controller
public class AuctionController {
	@Autowired
	private AuctionDAO dao;
	@Autowired
	private Auction_biddingDAO bdao;
	@Autowired
	private AuctionTransactionService sv;
	
	@Scheduled(fixedRate = 1000)
	 public void testTime(){
	 AuctionDTO dto=new AuctionDTO();
	 Map map=new HashMap();
	 List<AuctionDTO> list=dao.testTime();
	 if(list.size()>0){
	 for(int i=0; i<list.size(); i++){
	 map.put("auction_num",list.get(i).getAuction_num());
	 int time=Integer.parseInt(list.get(i).getAuction_time());
	 if(time>0){
	 map.put("auction_time",list.get(i).getAuction_time());
	 dao.testUpdate(map);
	 }
	 }
	 }
	 List<AuctionDTO> tlist=dao.tlist();
	 Map tmap=new HashMap();
	 for(int t=0; t<tlist.size(); t++){
		 int closetime=Integer.parseInt(tlist.get(t).getAuction_time());
		 if(closetime==1){
			 int number=tlist.get(t).getAuction_num();
			 dto=dao.tR(number);
			 tmap.put("auction_item",dto.getAuction_item());
			 tmap.put("auction_num",number);
			 try {
				sv.dc(tmap);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
	 } 
	 }
	/**
	 * Ajax�� �Ҷ�
	 * 
	 * @RequestMapping(value="/Auction/closeTimeSum") public String time(int
	 *                                                auction_num,String
	 *                                                auction_time){
	 *                                                System.out.println("auction_num"+auction_num);
	 *                                                System.out.println("auction_time"+auction_time);
	 *                                                AuctionDTO dto=new
	 *                                                AuctionDTO();
	 *                                                dto=dao.read(auction_num);
	 *                                                Map map=new HashMap();
	 *                                                map.put("auction_num",
	 *                                                auction_num);
	 *                                                map.put("auction_time",dto.getAuction_time());
	 *                                                int
	 *                                                close=Integer.parseInt(dto.getAuction_time());
	 *                                                if(close>0){
	 *                                                dao.closeTime(map); }
	 *                                                String
	 *                                                closeTime=dao.closeTimeRead(auction_num);
	 *                                                dto.setAuction_time(closeTime);
	 *                                                return
	 *                                                dto.getAuction_time(); }
	 **/

	@RequestMapping(value = "/Auction/closeTime")
	public String time(Model model, int auction_num, ModelMap modelmap) {
		AuctionDTO dto = new AuctionDTO();
		dto = dao.read(auction_num);
		model.addAttribute("second", dto.getAuction_time());
		model.addAttribute("auction_num", auction_num);
		return "/auction/closeTime";

	}

	@RequestMapping(value = "/Auction/update", method = RequestMethod.GET)
	public String update(HttpSession session, @RequestParam("auction_num") int auction_num, Model model) {
		AuctionDTO dto = dao.read(auction_num);
		model.addAttribute("dto", dto);
		return "/auction/update";
	}

	@RequestMapping(value = "/Auction/updateProc", method = RequestMethod.POST)
	public String update(int auction_num, AuctionDTO dto) {
		String url = "redirect:./read?auction_num=" + auction_num;
		if (dao.update(dto)) {

		} else {
			url = "error";
		}
		return url;
	}

	@RequestMapping(value = "/Auction/create", method = RequestMethod.GET)
	public String create(Model model, AuctionDTO dto) {
		String id = dto.getId();
		model.addAttribute("id", id);
		return "/auction/create";
	}

	@RequestMapping(value = "/Auction/createProc", method = RequestMethod.POST)
	public String create(AuctionDTO dto, HttpServletRequest request, String id) {
		String upDir = request.getRealPath("/storage/auction");
		String fileName = null;
		if (dto.getFileMF().getSize() > 0) {
			fileName = Utility.saveFile(dto.getFileMF(), upDir);
		}
		dto.setAuction_item(fileName);
		String url = "";
		if (dao.create(dto)) {
			url = "redirect:./list";
		} else {
			url = "auctionCreateError";
		}

		return url;
	}

	@RequestMapping(value = "/Auction/list")
	public String list(Model model,HttpSession session) {
		AuctionDTO dto=new AuctionDTO();
		String id=dto.getId();
		if(id==null){
			id= (String)session.getAttribute("id");
		}
		System.out.println(id);
		String url = "/auction/list";
		List<AuctionDTO> list = dao.list();
		model.addAttribute("list", list);
		model.addAttribute("id",id);
		int pk=0;
		Map map=new HashMap();
		int bidmoney=0;
		int bidmoneycheck=0;
		List<Auction_biddingDTO> biddingList = null;
		for(int i=0; i<list.size(); i++){
			pk=list.get(i).getAuction_num();
//			System.out.println("��ȣ="+pk);
			bidmoneycheck=bdao.bidmoneycheck(pk);
//			System.out.println(bidmoneycheck);
		}
		model.addAttribute("bidDAO",bdao);
		return url;
	}
 
	@RequestMapping(value = "/Auction/read")
	public String read(HttpSession session,@RequestParam("auction_num") int auction_num, Model model) {
		String url = "/auction/read";
		AuctionDTO dto = new AuctionDTO();
		String id = dto.getId();
		if(id==null){
			id=(String)session.getAttribute("id");
					}
		System.out.println(auction_num); 
		dto = dao.read(auction_num);
		System.out.println(dto.getAuction_time());
		Map map = new HashMap();
		map.put("auction_num", auction_num);
		map.put("auction_time", dto.getAuction_time());
		System.out.println(map.get("auction_time"));
		
		int time = Integer.parseInt(dto.getAuction_time());
		System.out.println("int" + time); 
		if (time == 0) {
			System.out.println(dto.getAuction_num());
			dao.time(dto.getAuction_num());    
			System.out.println(dto.getAuction_time());
		}
		dto = dao.read(auction_num);
		int bid = bdao.checkId(auction_num);
		Auction_biddingDTO bdto = new Auction_biddingDTO();
		Map map2 = new HashMap();
		map2.put("auction_num", auction_num);
		map2.put("mn",0);
		map2.put("mx",2); 
		System.out.println("map.get(" + map2.get("auction_num") + ")");
		System.out.println("map.get(" + map2.get("id") + ")");
		int bidcheck = bdao.bidmoneycheck(auction_num); 
		System.out.println("bidcheck=" + bidcheck);
		List<Auction_biddingDTO> bmlist = bdao.bidmoneyLists(map2);
		model.addAttribute("bidcheck", bidcheck);
		model.addAttribute("bmlist", bmlist);
		model.addAttribute("dto", dto);
		model.addAttribute("id", id);
		model.addAttribute("bid", bid);
		return url;
	}
}
