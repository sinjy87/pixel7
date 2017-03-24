package spring.sts.pixel7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.pixel7.MemberResearchDAO;
import spring.model.pixel7.MemberResearchDTO;
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
	
	@Autowired
	private MemberResearchDAO mrdao;
	
	
	@RequestMapping("/chart/view")
	public String view(Model model, int research_num) throws Exception{
		
		Map map = new HashMap();
		map.put("research_num", research_num);
//		
		List<ResearchItemDTO> rilist = ridao.list(map);
//		
		model.addAttribute("list", rilist);
//		model.addAttribute("dto", dao.read(research_num));
		model.addAttribute("dto", dao.read(research_num));
		
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

		int total = dao.total(map);
		String paging = Utility.paging(total, nowPage, recordPerPage, col, word);

		model.addAttribute("list", list);
		model.addAttribute("col", col);
		model.addAttribute("word", word);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("paging", paging);
		
		
		
		return "/chart/list";
	}
	
	
	@RequestMapping("/chart/read")
	public String read(int research_num, Model model) throws Exception{
		
		Map map = new HashMap();
		map.put("research_num", research_num);
		
		List<ResearchItemDTO> rilist = ridao.list(map);
		
		model.addAttribute("list", rilist);
		
		return "/chart/read";
	}
	
	@RequestMapping(value="/chart/create", method=RequestMethod.POST)
	public String create(MemberResearchDTO dto) throws Exception{
		
		if(mrdao.create(dto)){
			return "redirect:./list";
		}
		else{
			return "error";
		}
	}
	
	@RequestMapping(value="/chart/update", method=RequestMethod.GET)
	public String update(int research_num, Model model) throws Exception{
	
		Map map = new HashMap();
		map.put("research_num", research_num);
		
		List<ResearchItemDTO> rilist = ridao.list(map);
		
		model.addAttribute("list", rilist);
		model.addAttribute("dto", dao.read(research_num));
		
		return "/chart/update";
	}
	
	@RequestMapping(value="/chart/update", method=RequestMethod.POST)
	public String update(ResearchDTO dto, Model model) throws Exception{
	
		if(dao.create(dto)){
			return "redirect:./list";
		}
		
		else{
			return "error";
		}

	}
	
	
	@RequestMapping("/chart/delete")
	public String delete(){
		
		
		return  "";
	}
	
	
}
