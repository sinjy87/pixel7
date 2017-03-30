package spring.sts.pixel7;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
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
import spring.model.pixel7.Research_Mgr;
import spring.utility.pixel7.Utility;

@Controller
public class ResearchController {

	@Autowired
	private ResearchDAO dao;

	@Autowired
	private ResearchItemDAO ridao;

	@Autowired
	private MemberResearchDAO mrdao;
	
	@Autowired
	private Research_Mgr mgr ;
	
	
	@RequestMapping("/chart/view")
	public void view(Model model, HttpServletResponse res, HttpServletRequest request ,int research_num) throws Exception {

		Map map = new HashMap();
		map.put("research_num", research_num);

		ResearchDTO dto = (ResearchDTO) dao.read(research_num);
		JSONArray ja = new JSONArray();
		
		int i = 0;
		i++;
		System.out.println("1번째 i =" + i);

				System.out.println("dto :" + dto.getResearch_num());
				List<ResearchItemDTO> rilist = ridao.list(map);
				Iterator<ResearchItemDTO> riiter = rilist.iterator();

				if (riiter.hasNext()) {
					
					ResearchItemDTO ridto = riiter.next();
					JSONArray jaContent = new JSONArray();
					ja.add(dto.getResearch_title());
					System.out.println("dto.getResearch_title() : " + dto.getResearch_title());
					ja.add(ridto.getResult1());
					System.out.println("ridto.getResult1() : " + ridto.getResult1());
					ja.add(ridto.getCnt1());
					System.out.println("ridto.getCnt1() : " + ridto.getCnt1());
					ja.add(ridto.getResult3());
					System.out.println("ridto.getResult3() : " + ridto.getResult3());
					ja.add(ridto.getCnt2());
					System.out.println("ridto.getCnt2() : " + ridto.getCnt2());
					ja.add(ridto.getResult5());
					System.out.println("ridto.getResult5() : " + ridto.getResult5());
					ja.add(ridto.getCnt3());
					System.out.println("ridto.getCnt3() : " + ridto.getCnt3());
					ja.add(ridto.getResult7());
					System.out.println("ridto.getResult7() : " + ridto.getResult7());
					ja.add(ridto.getCnt4());
					System.out.println("ridto.getCnt4() : " + ridto.getCnt4());
					
				}
		res.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter print = res.getWriter();
		print.print(ja);
	}

	@RequestMapping("/chart/list")
	public String list(HttpServletRequest request, Model model , HttpSession session) throws Exception {

		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));

		if (col.equals("total")) {
			word = "";
		}

		int nowPage = 1;
		int recordPerPage = 5;
		if (request.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}

		int sno = ((nowPage - 1) * recordPerPage) + 1;
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
	public String read(int research_num, Model model, HttpSession session) throws Exception {
		

		Map map = new HashMap();
		map.put("research_num", research_num);
		map.put("id", session.getAttribute("id"));
		
		boolean flag = true;
		int cnt = mrdao.idCheck(map);
		if(cnt>0)
			flag = false;
		
		model.addAttribute("flag", flag);
		
		System.out.println("cnt:"+cnt);
		
		List<ResearchItemDTO> rilist = ridao.list(map);
		model.addAttribute("list", rilist);
	
		return "/chart/read";
	
	}

	@RequestMapping(value = "/chart/itemcreate", method = RequestMethod.GET)
	public String create(ResearchDTO dto, ResearchItemDTO ridto) throws Exception {
		return "/chart/itemcreate";
	}
	
	
	@RequestMapping(value = "/chart/titlecreate", method = RequestMethod.POST)
	public String create(ResearchDTO dto, Model model) throws Exception {

		
		Map map = new HashMap();
		int i = 0;
		for(i=0; i< dao.list(map).size(); i++){
			
		}
		dto.setResearch_num(i+1);
		
		if(dao.create(dto)){
			model.addAttribute("dto", dto);
			return "/chart/itemcreate";
		}
		else{
			return "error";
		}
		
//		return "";
		
	}
	
	@RequestMapping(value = "/chart/contentcreate", method = RequestMethod.POST)
	public String create(ResearchItemDTO ridto, Model model, int research_num) throws Exception {
		
		if(ridao.create(ridto)){
			model.addAttribute("ridto", ridto);
			return "/chart/itemcreate";
		}
		else{
			return "error";
		}
		
	}
	
	
	
	
	
	
	
	
	
	

	@RequestMapping(value = "/chart/create", method = RequestMethod.POST)
	public String create(MemberResearchDTO dto) throws Exception {

		if (mrdao.create(dto)) {
			return "redirect:./list";
		} else {
			return "error";
		}
	}

	@RequestMapping(value = "/chart/update", method = RequestMethod.GET)
	public String update(int research_num, Model model) throws Exception {

		Map map = new HashMap();
		map.put("research_num", research_num);

		List<ResearchItemDTO> rilist = ridao.list(map);

		model.addAttribute("list", rilist);
		model.addAttribute("dto", dao.read(research_num));

		return "/chart/update";
	}

	@RequestMapping(value = "/chart/update", method = RequestMethod.POST)
	public String update(ResearchDTO dto, Model model) throws Exception {

		if (dao.create(dto)) {
			return "redirect:./list";
		}

		else {
			return "error";
		}

	}

	@RequestMapping("/chart/delete")
	public String delete(int research_num) throws Exception {

		mgr.delete(research_num);
		
		return "redirect:./list";
	}

}
