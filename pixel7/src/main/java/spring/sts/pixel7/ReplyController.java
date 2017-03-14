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

import spring.model.reply.ReplyDAO;
import spring.model.reply.ReplyDTO;
import spring.model.reply.ReplyMgr;

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
	
	/**
	 * 댓글 생성 GET
	 */
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String create(){
		return "/reply/create";
	}
	/**
	 * 댓글 생성 POST
	 */
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(ReplyDTO dto,HttpServletRequest request){
		String upDir = request.getRealPath("/storage");
		
		boolean flag = mgr.create(dto);
		
		if(flag){
			return "redirect:/list";
		}else{
			return "redirect:/list";
		}
		
	}
	
	/**
	 * 댓글 보기
	 */
	@RequestMapping("/read")
	public String read(int reply_num,Model model,String id,String reply_content,
			HttpServletRequest request){
		
		ReplyDTO dto = mgr.read(reply_num);
		String content = dto.getReply_content().replaceAll("\r\n", "<br>");
		dto.setReply_content(reply_content);
		model.addAttribute("dto",dto);
		
		
		return "/reply/read";
	}
	
	/**
	 * 댓글 수정POST
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(ReplyDTO dto,
			HttpServletRequest request,Model model){
			
			return "redirect:./list";		
		
	}
	
	/**
	 * 댓글 수정 GET
	 */
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(int reply_num,Model model){
		ReplyDTO dto = mgr.read(reply_num);
		
		model.addAttribute("dto",dto);
		
		return "/reply/update";
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
	public String rcreate(int reply_num,Model model){
		
		ReplyDTO dto = mgr.read(reply_num);
		
		model.addAttribute("dto",dto);
		
		return "/board/reply";
	}
	
	/**
	 * 댓글 삭제POST
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(int reply_num,
			HttpServletRequest request
			,Model model){
				
		return "redirect:./list";
	}
	
	/**
	 * 댓글 삭제 GET
	 */
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(int reply_num,Model model){
		boolean flag= mgr.delete(reply_num);
				
		model.addAttribute("flag",flag);
		
		
		return "/reply/delete";
	}
	
}
