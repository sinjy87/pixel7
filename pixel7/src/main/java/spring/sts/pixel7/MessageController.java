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

import spring.model.message.MessageDAO;
import spring.model.message.MessageDTO;
import spring.utility.pixel7.Utility;

/**
 * 
 * <pre>
 * Copyright 2017 JAVADB Course, Inc. All rights reserved.
 * 패키지명        : spring.sts.pixel7 
 * 파일명          : MessageController.java , 2017. 3. 15. 오전 11:58:55
 * 작성자          : 정내용
 * 작성자 email    : content_j@naver.com
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
 * </pre>
 */
@Controller
public class MessageController {
	@Autowired
	private MessageDAO dao;

	/** 쪽지목록 */
	@RequestMapping("/message/list")
	public String list(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));

		// 페이징관련
		int nowPage = 1;
		int recordPerPage = 9;
		if (request.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}

		// DB에서 가져올 순번
		int sno = ((nowPage - 1) * recordPerPage) + 1;
		int eno = nowPage * recordPerPage;

		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);
		map.put("sno", sno);
		map.put("eno", eno);
		map.put("id", session.getAttribute("id"));
		int total = dao.total(map);
		List list = dao.list(map);

		String paging = Utility.paging3(total, nowPage, recordPerPage, col, word);
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		model.addAttribute("col", col);
		return "/message/list";
	}

	/** 쪽지삭제 */
	@RequestMapping("/message/delete")
	public String delete(int message_num, Model model) throws Exception {
		String message = "삭제가";
		if (dao.delete(message_num)) {
			model.addAttribute(message);
			return "/message/list";
		} else {
			return "error";
		}

	}

	/** 쪽지 읽기 */
	@RequestMapping("/message/read")
	public String read(int message_num, Model model) throws Exception {
		MessageDTO dto = (MessageDTO) dao.read(message_num);
		model.addAttribute("dto", dto);
		return "/message/read";
	}

	/** 쪽지보내기POST */
	@RequestMapping(value = "/message/create", method = RequestMethod.POST)
	public String create(MessageDTO dto, Model model) throws Exception {

		String seceder = dao.getGrade(dto.getMessage_id());
		if (seceder.equals("seceder")) {
			String sts = "이미 탈퇴한 회원입니다.";
			model.addAttribute("sts", sts);
			return "seceder";
		} else {

			String message = "전송이";

			if (dao.create(dto)) {
				model.addAttribute("message", message);
				return "message/proc";
			} else {
				return "error";
			}
		}
	}

	/** 쪽지보내기GET */
	@RequestMapping(value = "/message/create", method = RequestMethod.GET)
	public String create(HttpSession session, Model model) {

		model.addAttribute("id", session.getAttribute("id"));
		return "message/create";
	}
}
