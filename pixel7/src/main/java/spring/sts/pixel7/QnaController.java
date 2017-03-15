package spring.sts.pixel7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import spring.model.pixel7.QnaDAO;
import spring.model.pixel7.QnaDTO;
import spring.utility.pixel7.Utility;

@Controller
public class QnaController {
	
	@Autowired
	private QnaDAO dao;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		
		return "/qna/login";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String id, HttpSession session){
		session.setAttribute("id", id);
		return "redirect:./";
	}
	
	
	@RequestMapping("/qna/list")
	public String list(HttpServletRequest request) throws Exception {
		
		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));
		
		if(col.equals("total")){
			word = "";
		}
		
		int nowPage = 1;
		int recordPerPage = 5;
		
		if(request.getParameter("nowPage") != null){
			nowPage = Integer.parseInt( request.getParameter("nowPage"));
		}
		
		int sno  = ((nowPage -1) * recordPerPage )+1 ;
		int eno = nowPage * recordPerPage;
		
		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);
		map.put("sno", sno);
		map.put("eno", eno);
		
		List<QnaDTO> list = dao.list(map);
		int total = dao.total(map);
		String paging = Utility.paging3(total, nowPage, recordPerPage, col, word);
		
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		request.setAttribute("col", col);
		request.setAttribute("word", word);
		request.setAttribute("nowPage", nowPage);

		 
		return "/qna/list";
	}
	
	@RequestMapping("/qna/read")
	public String read(int qna_num, Model model) throws Exception{
		
		model.addAttribute("dto", (QnaDTO) dao.read(qna_num));
		
		return "/qna/read";
	}
	
	@RequestMapping(value="/qna/create", method=RequestMethod.GET)
	public String create(){
		
		return "/qna/create";
	}
	
	@RequestMapping(value="/qna/create", method=RequestMethod.POST)
	public String create(QnaDTO dto, Model model, HttpServletRequest request) throws Exception{

		String basePath = request.getRealPath("/qna/storage");
		String filename = "";
		int filesize = (int)dto.getQna_MF().getSize();
		if(filesize>0){
			filename = Utility.saveFile(dto.getQna_MF(), basePath);
		}
		
		dto.setQna_filename(filename);
		
		if(dao.create(dto)){
			return "redirect:./list";
		}
		else{
			return "./error";
		}
	}
	
	
	@RequestMapping(value="/qna/update", method=RequestMethod.GET)
	public String update(QnaDTO dto, Model model, int qna_num) throws Exception{
		model.addAttribute("dto", dao.read(qna_num));
		return "/qna/update";
	}
	
	@RequestMapping(value="/qna/update", method=RequestMethod.POST)
	public String update(HttpServletRequest request, QnaDTO dto, String oldfilename) throws Exception{
		
		String basePath = request.getRealPath("/qna/storage");
		String filename = "";
		int filesize = (int)dto.getQna_MF().getSize();
		if(filesize>0){
			filename = Utility.saveFile(dto.getQna_MF(), basePath);
			Utility.deleteFile(basePath, oldfilename);
		}
		
		dto.setQna_filename(filename);
		
		if(dao.update(dto)){
			
			return "redirect:./list";
		}
		else{
			Utility.deleteFile(basePath, filename);
			return "./error";
		}

	}

	

}
