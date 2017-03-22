package spring.sts.pixel7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.model.member.MemberDAO;
import spring.model.member.MemberDTO;
import spring.utility.pixel7.Utility;

/**
 * <pre>
 * Copyright 2017 JAVADB Course, Inc. All rights reserved.
 * 패키지명        : spring.sts.pixel7 
 * 파일명          : MemberController.java , 2017. 3. 13. 오전 11:37:11
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
public class MemberController {
	@Autowired
	private MemberDAO dao;




	/**
	 * 통계
	 * 
	 * @throws IOException
	 */
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
		
		ja.add(year + "년도 가입/탈퇴 현황");
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
					adto.add("0" + mon + "월");
				} else {
					adto.add(mon + "월");
				}
				adto.add('0');
				adto.add('0');
				ja.add(adto);
				j++;
			} else {
				dto = (MemberDTO) list.get(i);
				adto.add(dto.getStatdate().substring(3, 5) + "월");
				adto.add(dto.getSignup());
				adto.add(dto.getWithdrawal());
				ja.add(adto);
			}

		}
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter print = res.getWriter();
		print.print(ja);

	}

	/** 로그아웃 */
	@RequestMapping("member/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../";
	}

	/** 로그인 */
	@RequestMapping(value = "member/login", method = RequestMethod.POST)
	public String login(String id, String password, HttpSession session, Model model) {
		String seceder = dao.getGrade(id);
		if (seceder.equals("seceder")) {
			String sts = "이미 탈퇴한 회원입니다.";
			model.addAttribute("sts", sts);
			return "/member/seceder";
		} else {
			if (dao.passwdCheck(id, password)) {
				session.setAttribute("id", id);
				session.setAttribute("grade", dao.getGrade(id));
				return "redirect:../";
			} else {
				return "error";
			}
		}
	}

	/** 로그인 */
	@RequestMapping(value = "member/login", method = RequestMethod.GET)
	public String login() {
		return "/member/login";
	}

	/** 회원목록 */
	@RequestMapping("member/list")
	public String list(HttpServletRequest request) throws Exception {
		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));
		System.out.println(col);
		if (col.equals("total")) {

			word = "";
		}

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
		int total = dao.total(map);
		List<MemberDTO> list = dao.list(map);

		String paging = Utility.paging3(total, nowPage, recordPerPage, col, word);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		return "/member/list";

	}

	/** 회원정보 */
	@RequestMapping("/member/read")
	public String read(Model model, HttpSession session, HttpServletRequest request) {

		String id = Utility.checkNull(request.getParameter("id"));
		if (id == "") {
			model.addAttribute("dto", dao.read(session.getAttribute("id")));
			return "/member/read";
		} else {

			String seceder = dao.getGrade(id);
			if (seceder.equals("seceder")) {
				String sts = "이미 탈퇴한 회원입니다.";
				model.addAttribute("sts", sts);
				return "/member/seceder";
			} else {
				model.addAttribute("dto", dao.read(session.getAttribute("id")));
				return "/member/read";
			}
		}
	}

	/** * 회원탈퇴POST */
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

	/** * 회원탈퇴GET */
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete(Model model, HttpServletRequest request) {
		String id = Utility.checkNull(request.getParameter("id"));
		if (id == "") {
			return "/member/delete";
		} else {

			String seceder = dao.getGrade(id);
			if (seceder.equals("seceder")) {
				String sts = "이미 탈퇴한 회원입니다.";
				model.addAttribute("sts", sts);
				return "/member/seceder";
			} else {
				return "/member/delete";
			}
		}
	}

	/** * 회원수정POST */
	@RequestMapping(value = "/member/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session, MemberDTO dto, String old_bgphoto,
			String old_photo, String password) {
		String basePath = request.getRealPath("/member/stroage"); // 저장경로
		int bgphotosize = (int) dto.getBgphotoMF().getSize(); // 배경사진사이즈
		int photosize = (int) dto.getPhotoMF().getSize();// 사진사이즈
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

	/** * 회원수정GET */
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
				String sts = "이미 탈퇴한 회원입니다.";
				model.addAttribute("sts", sts);
				return "/member/seceder";
			} else {
				model.addAttribute("dto", dao.read(id));
				return "/member/update";
			}
		}
	}

	/** * 회원가입POST */
	@RequestMapping(value = "/member/create", method = RequestMethod.POST)
	public String create(MemberDTO dto, HttpServletRequest request, Model model) {
		String seceder = dao.getGrade(dto.getId());
		if (seceder.equals("seceder")) {
			String sts = "7일 이내로 재가입이 불가합니다.";
			model.addAttribute("sts", sts);
			return "/member/seceder";
		} else {

			String basePath = request.getRealPath("/member/stroage"); // 저장경로
			int bgphotosize = (int) dto.getBgphotoMF().getSize(); // 배경사진사이즈
			int photosize = (int) dto.getPhotoMF().getSize();// 사진사이즈
			String bgphoto = "member_bgphoto.jpg";// 배경사진이름
			String photo = "member_photo.jpg";// 사진이름

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

	/** * 회원가입 GET */
	@RequestMapping(value = "/member/create", method = RequestMethod.GET)
	public String create(HttpServletRequest request, Model model) {
		String id = Utility.checkNull(request.getParameter("id"));
		if (id == "") {
			return "/member/create";
		} else {

			String seceder = dao.getGrade(id);
			if (seceder.equals("seceder")) {
				String sts = "이미 탈퇴한 회원입니다.";
				model.addAttribute("sts", sts);
				return "/member/seceder";
			} else {
				return "/member/create";
			}
		}
	}

	/** 회원가입 동의서 */
	@RequestMapping("/member/agree")
	public String agree() {
		return "/member/agree";
	}

}
