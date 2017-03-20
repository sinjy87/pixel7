package spring.sts.pixel7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.model.pixel7.ResearchDAO;
import spring.model.pixel7.ResearchDTO;
import spring.model.pixel7.ResearchItemDAO;
import spring.model.pixel7.ResearchItemDTO;
import spring.utility.pixel7.Utility;

@Controller
public class ResearchController {

	
	@Autowired
	private ResearchDAO dao;
	
	@Autowired
	private ResearchItemDAO ridao;
	
	
	@RequestMapping("/chart/view")
	public String view(){
		
		return "/chart/viewChart";
	}
	
	@RequestMapping("/chart/list")
	public String list(HttpServletRequest request, Model model) throws Exception{
		
		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));
		
		if(col.equals("total")){
			word = "";
		}
		
		int nowPage = 1;
		int recordPerPage = 5;
		if(request.getParameter("nowPage") != null){
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		
		int sno = ((nowPage-1) * recordPerPage) +1 ;
		int eno = nowPage * recordPerPage;
		
		Map map = new HashMap();
		map.put("sno", sno);
		map.put("eno", eno);
		map.put("col", col);
		map.put("word", word);
		
		List<ResearchDTO> list = dao.list(map);
		List<ResearchItemDTO> rilist = ridao.list(map);
		ResearchItemDTO ridto = (ResearchItemDTO) ridao.read(1);
		
		int total = dao.total(map);
		String paging = Utility.paging(total, nowPage, recordPerPage, col, word);
		
		model.addAttribute("ridto", ridto);
		model.addAttribute("rilist", rilist);
		model.addAttribute("list", list);
		model.addAttribute("col", col);
		model.addAttribute("word", word);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("paging", paging);
		
		
		
		return "/chart/list";
	}
	
	
	
}
