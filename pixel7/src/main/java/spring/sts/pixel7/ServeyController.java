//package spring.sts.pixel7;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import spring.model.pixel7.ServeyCheckDAO;
//import spring.model.pixel7.ServeyCheckDTO;
//import spring.model.pixel7.ServeyDAO;
//import spring.model.pixel7.ServeyDTO;
//import spring.utility.pixel7.Utility;
//
//@Controller
//public class ServeyController {
//
//	
//	@Autowired
//	private ServeyDAO dao;
//	
//	@Autowired
//	private ServeyCheckDAO scdao;
//	
//	
//	@RequestMapping("/chart/view")
//	public String view(){
//		
//		return "/chart/viewChart";
//	}
//	
//	@RequestMapping("/chart/list")
//	public String list(HttpServletRequest request, Model model) throws Exception{
//		
//		String col = Utility.checkNull(request.getParameter("col"));
//		String word = Utility.checkNull(request.getParameter("word"));
//		
//		if(col.equals("total")){
//			word = "";
//		}
//		
//		int nowPage = 1;
//		int recordPerPage = 5;
//		if(request.getParameter("nowPage") != null){
//			nowPage = Integer.parseInt(request.getParameter("nowPage"));
//		}
//		
//		int sno = ((nowPage-1) * recordPerPage) +1 ;
//		int eno = nowPage * recordPerPage;
//		
//		Map map = new HashMap();
//		map.put("sno", sno);
//		map.put("eno", eno);
//		map.put("col", col);
//		map.put("word", word);
//		
//		List<ServeyDTO> list = dao.list(map);
//		ServeyCheckDTO scdto = new ServeyCheckDTO();
//		
//
//		int total = dao.total(map);
//		String paging = Utility.paging(total, nowPage, recordPerPage, col, word);
//		
//		model.addAttribute("scdto", scdto);
//		model.addAttribute("list", list);
//		model.addAttribute("col", col);
//		model.addAttribute("word", word);
//		model.addAttribute("nowPage", nowPage);
//		model.addAttribute("paging", paging);
//		
//		
//				
//		return "/chart/list";
//	}
//	
//	
//	
//	@RequestMapping("/chart/read")
//	public String read(int servey_num, Model model) throws Exception{
//		
//		model.addAttribute("dto", dao.read(servey_num));
//		
//		return "/chart/read";
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	@RequestMapping(value="/chart/create", method=RequestMethod.POST)
//	public String create(ServeyCheckDTO dto, Model model, String id) throws Exception{
//		model.addAttribute("dto", dto);
//		
//		dto.setId(id);
//		
//		if(scdao.create(dto)){
//			return "redirect:./list";
//		}
//		else{
//			return "error";
//		}
//		
//		
//	}
//	
//	
//	
//}
