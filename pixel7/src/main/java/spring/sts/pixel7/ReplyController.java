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

import spring.model.reply.ReplyDAO;
import spring.model.reply.ReplyDTO;
import spring.model.reply.ReplyMgr;
import spring.utility.pixel7.Utility;

/**
 * 
 * <pre>
 * Copyright 2016 JAVADB Course, Inc. All rights reserved.
 * 패키지명        : spring.sts.pixel7 
 * 파일명          : ReplyController.java , 2017. 3. 13. 오후 12:04:29
 * 작성자          : 신준영
 * 작성자 email    : sinjy87@naver.com
 * 수정내용
 * ----------------------------------------------
 * 수정 이력
 * ---------------------------------------------- 
 * 수정일      수정자  연락처
 *   
 * 수정내용
 *
 * ----------------------------------------------
 * 
 *</pre>
 */
@Controller
public class ReplyController {
	
	@Autowired
	private ReplyDAO rdao;
	
	@Autowired
	private ReplyMgr mgr;
	
	@RequestMapping(value="/reply/login",method=RequestMethod.POST)
	public String login(String id,HttpSession session){
		session.setAttribute("id", id);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value="/reply/login",method=RequestMethod.GET)
	public String login(){
		return "/reply/login";
	}

	@RequestMapping(value="/reply/create")
	public String create(ReplyDTO dto,Model model,HttpSession session,String img_num){

		dto.setId((String)session.getAttribute("id"));
		dto.setImg_num(Integer.parseInt(img_num));

		boolean flag = rdao.create(dto);
		
		
		if(flag){
//			model.addAttribute("id", (String)session.getAttribute("id"));
//			model.addAttribute("img_num",dto.getImg_num());
//			model.addAttribute("col",col);
//			model.addAttribute("word",word);
//			model.addAttribute("nowPage",nowPage);
			
			return "redirect:./list";
		}else{
			return "error";
		}
		
	}
	
	/**
	 * 댓글 보기
	 */
	@RequestMapping("/read")
	public String read(int reply_num,Model model,String id,String reply_content,
			HttpServletRequest request) throws Exception{
		
		ReplyDTO dto = (ReplyDTO) rdao.read(reply_num);
		String content = dto.getReply_content().replaceAll("\r\n", "<br>");
		dto.setReply_content(reply_content);
		model.addAttribute("dto",dto);
		
		
		return "/reply/list";
	}
	
	
	/**
	 * 댓글 수정
	 */
	@RequestMapping(value="/reply/update",method=RequestMethod.GET)
	public String update(int reply_num,Model model,String reply_content
			,String col, String nowPage,String word) throws Exception{
		ReplyDTO dto = (ReplyDTO) rdao.read(reply_num);
		
		model.addAttribute("dto",dto);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value="/reply/update",method=RequestMethod.POST)
	public String update(ReplyDTO dto ,int reply_num,Model model,String reply_content
			,String col, String nowPage,String word) throws Exception{

		if(rdao.update(dto)){
			model.addAttribute("col",col);
			model.addAttribute("nowPage",nowPage);
			model.addAttribute("word",word);
		return "redirect:./list";
		
		}else{
			return "error";
					
		}
			
	}
	
	/**
	 * 댓글에 답글 생성POST
	 */
	@RequestMapping(value="/rcreate",method=RequestMethod.POST)
	public String rcreate(ReplyDTO dto
			,HttpServletRequest request,Model model){
		

			return "redirect:./list";
		
	}
	
	/**
	 * 댓글에 답글 생성GET
	 */
	@RequestMapping(value="/rcreate",method=RequestMethod.GET)
	public String rcreate(int reply_num,Model model) throws Exception{
		
		ReplyDTO dto = (ReplyDTO) rdao.read(reply_num);
		
		model.addAttribute("dto",dto);
		
		return "/reply/list";
	}
	

	
	/**
	 * 댓글 삭제
	 */
	@RequestMapping(value="/reply/delete")
	public String delete(int reply_num,Model model,String col, String nowPage,String word){
				if(mgr.delete(reply_num)){
					return "redirect:/reply/list";
				}else{
					return "error";
				}
	}
	
	/**
	 * 댓글 리스트
	 * @throws Exception 
	 */
	@RequestMapping("/reply/list")
	public String list(HttpServletRequest request) throws Exception{
		
		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));
		
		if(col.equals("total")){
			word = "";
		}
		//페이징
		int nowPage = 1;
		if(request.getParameter("nowPage") != null){
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		int recordPerPage = 5;
		int sno = ((nowPage - 1) * recordPerPage) + 1;
		int eno = nowPage * recordPerPage;
		
		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);
		map.put("sno", sno);
		map.put("eno", eno);		
		
		int total = rdao.total(map);
		
		String paging = Utility.paging3(total, nowPage, recordPerPage, col, word);
		
		int totalRecode = rdao.total(map);
		List<ReplyDTO> list = rdao.list(map);
		
		request.setAttribute("list", list);
		request.setAttribute("col", col);
		request.setAttribute("word", word);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("paging", paging);
		
		return "/reply/list";
	}
}
