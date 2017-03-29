package spring.sts.pixel7;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.member.MemberDAO;
import spring.model.member.MemberDTO;
import spring.utility.pixel7.Utility;

/**
 * <pre>
 * Copyright 2017 JAVADB Course, Inc. All rights reserved.
 * �뙣�궎吏�紐�        : spring.sts.pixel7 
 * �뙆�씪紐�          : MemberController.java , 2017. 3. 13. �삤�쟾 11:37:11
 * �옉�꽦�옄          : �젙�궡�슜
 * �옉�꽦�옄 email    : content_j@naver.com
 * �닔�젙�궡�슜
 * ----------------------------------------------
 * �닔�젙 �씠�젰
 * ---------------------------------------------- 
 * �닔�젙�씪      �닔�젙�옄  �뿰�씫泥�
 *   
 * �닔�젙�궡�슜
 *
 * ----------------------------------------------
 * 
 * </pre>
 */
@Controller
public class MemberController {
	@Autowired
	private MemberDAO dao;

	
	/**�븘�씠�뵒以묐났泥댄겕*/
	@RequestMapping("/member/id")
	protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		// 異쒕젰�떆 �궗�슜�븷 臾몄옄�뀑 吏��젙
		res.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String keyword = request.getParameter("keyword");
		System.out.println("servlet keyword: " + keyword);// �븳湲� �븞源⑥��뒗吏��솗�씤怨쇱젙
		JSONArray ja = new JSONArray();
		List list = (List) dao.getId("");
		int y = 0;
		for (int i = 0; list.size() > i; i++) {
			MemberDTO dto = (MemberDTO) list.get(i);
			if (dto.getId().equals(keyword)) {
				y = y + 1;
			} 
		}
		if (y > 0) {
			ja.add("�뿈�궗�슜 遺덇� �븘�씠�뵒�엯�땲�떎");
		} else {
			ja.add("�뿈�궗�슜 媛��뒫�븳 �븘�씠�뵒�엯�땲�떎");
		}
		
		PrintWriter print = res.getWriter();
		print.print(ja);
	}

	/** �넻怨� */
	@RequestMapping("/member/stat")
	public String stat() throws IOException {

		return "/member/stat";
	}

	/** json */
	@RequestMapping("member/stat_j")
	public void stat_j(Model model, HttpServletResponse res, String year, String month) throws IOException {
		Map map = new HashMap();
		map.put("year", year);
		map.put("month", month);
		System.out.println(year);
		System.out.println(month);
		List list = (List) dao.statDate(map);
		JSONArray ja = new JSONArray();
		JSONArray atitle = new JSONArray();

		ja.add(year + "�뀈�룄 媛��엯/�깉�눜 �쁽�솴");
		MemberDTO dto2 = null;
		int j = 1;

		for (int i = 0; i < 6; i++) {
			JSONArray adto = new JSONArray();

			MemberDTO dto = null;
			if (i < list.size()) {
				System.out.println("size1" + list.size());
				dto = (MemberDTO) list.get(i);
				dto2 = dto;
				System.out.println("size2" + list.size());
			}

			if (dto == null) {
				int m = Integer.parseInt(dto2.getStatdate().substring(3, 5));
				int mon = m + j;
				if (mon < 10) {
					adto.add("0" + mon + "�썡");
				} else {
					adto.add(mon + "�썡");
				}
				adto.add('0');
				adto.add('0');
				ja.add(adto);
				j++;
			} else {
				dto = (MemberDTO) list.get(i);
				adto.add(dto.getStatdate().substring(3, 5) + "�썡");
				adto.add(dto.getSignup());
				adto.add(dto.getWithdrawal());
				ja.add(adto);
			}

		}
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter print = res.getWriter();
		print.print(ja);

	}

	/** 濡쒓렇�븘�썐 */
	@RequestMapping("member/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../main";
	}

	/** 濡쒓렇�씤 */
	@RequestMapping(value = "member/login", method = RequestMethod.POST)
	public String login(MemberDTO dto ,String id, String password, HttpSession session, Model model) {
		
		String seceder="" ;
		if(dao.getGrade(dto.getId())==null){
			
		}else{
			seceder =dao.getGrade(dto.getId());
		}
		
		if (seceder.equals("seceder")) {
			String sts = "�씠誘� �깉�눜�븳 �쉶�썝�엯�땲�떎.";
			model.addAttribute("sts", sts);
			return "/member/seceder";
		} else {
			if (dao.passwdCheck(id, password)) {
				session.setAttribute("id", id);
				session.setAttribute("grade", dao.getGrade(id));
				return "redirect:../main";
			} else {
				return "error";
			}
		}
	}

	/** 濡쒓렇�씤 */
	@RequestMapping(value = "member/login", method = RequestMethod.GET)
	public String login() {
		return "/member/login";
	}

	/** �쉶�썝紐⑸줉 */
	@RequestMapping("member/list")
	public String list(HttpServletRequest request) throws Exception {
		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));
		System.out.println(col);
		if (col.equals("total")) {

			word = "";
		}

		// �럹�씠吏뺢��젴
		int nowPage = 1;
		int recordPerPage = 9;
		if (request.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}

		// DB�뿉�꽌 媛��졇�삱 �닚踰�
		int sno = ((nowPage - 1) * recordPerPage) + 1;
		int eno = nowPage * recordPerPage;

		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);
		map.put("sno", sno);
		map.put("eno", eno);
		int total = dao.total(map);
		List<MemberDTO> list = dao.list(map);

		String paging = Utility.paging3(total, nowPage, recordPerPage, col, word);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		return "/member/list";

	}

	/** �쉶�썝�젙蹂� */
	@RequestMapping("/member/read")
	public String read(Model model, HttpSession session, HttpServletRequest request) {

		String id = Utility.checkNull(request.getParameter("id"));
		if (id == "") {
			model.addAttribute("dto", dao.read(session.getAttribute("id")));
			return "/member/read";
		} else {

			String seceder = dao.getGrade(id);
			if (seceder.equals("seceder")) {
				String sts = "�씠誘� �깉�눜�븳 �쉶�썝�엯�땲�떎.";
				model.addAttribute("sts", sts);
				return "/member/seceder";
			} else {
				model.addAttribute("dto", dao.read(session.getAttribute("id")));
				return "/member/read";
			}
		}
	}

	/** * �쉶�썝�깉�눜POST */
	@RequestMapping(value = "/member/delete", method = RequestMethod.POST)
	public String delete(HttpSession session, String password) {
		String viewPage = "";
		String basePath = "/member/storage";
		String id = (String) session.getAttribute("id");
		Map map = (Map) dao.photoName(id);
		String bgphoto = (String) map.get("bgphoto");
		System.out.println(bgphoto);
		String photo = (String) map.get("photo");
		System.out.println(photo);

		if (dao.passwdCheck(id, password)) {
			if (!(bgphoto.equals("member_bgphoto.jpg"))) {
				Utility.deleteFile(basePath, bgphoto);
			}
			if (!(photo.equals("member_photo.jpg"))) {
				Utility.deleteFile(basePath, photo);
			}
			if (dao.delete(id)) {
				viewPage = "redirect:../";
			} else {
				viewPage = "error";
			}
		} else {
			viewPage = "passwdError";
		}

		return viewPage;
	}

	/** * �쉶�썝�깉�눜GET */
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete(Model model, HttpServletRequest request) {
		String id = Utility.checkNull(request.getParameter("id"));
		if (id == "") {
			return "/member/delete";
		} else {

			String seceder = dao.getGrade(id);
			if (seceder.equals("seceder")) {
				String sts = "�씠誘� �깉�눜�븳 �쉶�썝�엯�땲�떎.";
				model.addAttribute("sts", sts);
				return "/member/seceder";
			} else {
				return "/member/delete";
			}
		}
	}

	/** * �쉶�썝�닔�젙POST */
	@RequestMapping(value = "/member/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session, MemberDTO dto, String old_bgphoto,
			String old_photo, String password) {
		String basePath = request.getRealPath("/member/stroage"); // ���옣寃쎈줈
		int bgphotosize = (int) dto.getBgphotoMF().getSize(); // 諛곌꼍�궗吏꾩궗�씠利�
		int photosize = (int) dto.getPhotoMF().getSize();// �궗吏꾩궗�씠利�
		String bgphoto = "member_bgphoto.jpg";
		String photo = "member_photo.jpg";
		String viewPage = "";
		String id = (String) session.getAttribute("id");

		if (dao.passwdCheck(id, password)) {
			if (bgphotosize > 0) {
				if (!(old_bgphoto.equals("member_bgphoto.jpg"))) {
					Utility.deleteFile(basePath, old_bgphoto);
				}
				bgphoto = Utility.saveFile(dto.getBgphotoMF(), basePath);
				dto.setBgphoto(bgphoto);
			}
			if (photosize > 0) {
				if (!(old_photo.equals("member_photo.jpg"))) {
					Utility.deleteFile(basePath, old_photo);
				}
				bgphoto = Utility.saveFile(dto.getBgphotoMF(), basePath);
				dto.setPhoto(photo);
			}
			if (dao.update(dto)) {
				viewPage = "redirect:../";
			} else {

				if (!(bgphoto.equals("member_bgphoto.jpg"))) {
					Utility.deleteFile(basePath, dto.getBgphoto());
				}
				if (!(photo.equals("member_photo.jpg"))) {
					Utility.deleteFile(basePath, dto.getPhoto());
				}

				viewPage = "error";
			}
		} else {
			viewPage = "passwdError";
		}
		return viewPage;
	}

	/** * �쉶�썝�닔�젙GET */
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model, HttpServletRequest request) {
		String id = (String) session.getAttribute("id");
		String rqid = Utility.checkNull(request.getParameter("id"));
		if (rqid == "") {
			model.addAttribute("dto", dao.read(id));
			return "/member/update";
		} else {

			String seceder = dao.getGrade(rqid);
			if (seceder.equals("seceder")) {
				String sts = "�씠誘� �깉�눜�븳 �쉶�썝�엯�땲�떎.";
				model.addAttribute("sts", sts);
				return "/member/seceder";
			} else {
				model.addAttribute("dto", dao.read(id));
				return "/member/update";
			}
		}
	}

	/** * �쉶�썝媛��엯POST */
	@RequestMapping(value = "/member/create", method = RequestMethod.POST)
	public String create(MemberDTO dto, HttpServletRequest request, Model model) {
		String seceder="" ;
		if(dao.getGrade(dto.getId())==null){
			
		}else{
			seceder =dao.getGrade(dto.getId());
		}
		if (seceder.equals("seceder")) {
			String sts = "7�씪 �씠�궡濡� �옱媛��엯�씠 遺덇��빀�땲�떎.";
			model.addAttribute("sts", sts);
			return "/member/seceder";
		} else {

			String basePath = request.getRealPath("/member/stroage"); // ���옣寃쎈줈
			int bgphotosize = (int) dto.getBgphotoMF().getSize(); // 諛곌꼍�궗吏꾩궗�씠利�
			int photosize = (int) dto.getPhotoMF().getSize();// �궗吏꾩궗�씠利�
			String bgphoto = "member_bgphoto.jpg";// 諛곌꼍�궗吏꾩씠由�
			String photo = "member_photo.jpg";// �궗吏꾩씠由�

			if (bgphotosize > 0) {
				bgphoto = Utility.saveFile(dto.getBgphotoMF(), basePath);
			}
			if (photosize > 0) {
				photo = Utility.saveFile(dto.getPhotoMF(), basePath);
			}

			dto.setBgphoto(bgphoto);
			dto.setPhoto(photo);

			if (dao.create(dto)) {
				return "redirect:../";
			} else {

				if (!(bgphoto.equals("member_bgphoto.jpg"))) {
					Utility.deleteFile(basePath, dto.getBgphoto());
				}
				if (!(photo.equals("member_photo.jpg"))) {
					Utility.deleteFile(basePath, dto.getPhoto());
				}

				return "error";
			}

		}
	}

	/** * �쉶�썝媛��엯 GET */
	@RequestMapping(value = "/member/create", method = RequestMethod.GET)
	public String create(HttpServletRequest request, Model model) {
		String id = Utility.checkNull(request.getParameter("id"));
		if (id == "") {
			return "/member/create";
		} else {

			String seceder = dao.getGrade(id);
			if (seceder.equals("seceder")) {
				String sts = "�씠誘� �깉�눜�븳 �쉶�썝�엯�땲�떎.";
				model.addAttribute("sts", sts);
				return "/member/seceder";
			} else {
				return "/member/create";
			}
		}
	}

	/** �쉶�썝媛��엯 �룞�쓽�꽌 */
	@RequestMapping("/member/agree")
	public String agree() {
		return "/member/agree";
	}

}
