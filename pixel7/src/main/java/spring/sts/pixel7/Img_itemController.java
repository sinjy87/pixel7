package spring.sts.pixel7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.img_item.Img_itemDAO;
import spring.model.img_item.Img_itemDTO;
import spring.utility.pixel7.Utility;

@Controller
public class Img_itemController {
	@Autowired
	private Img_itemDAO itemdao;
	
	@RequestMapping("/img_item/list")
	public String list(Model model) throws Exception {
		Map map =new HashMap();
		List list = itemdao.list(map);
		model.addAttribute("list",list);
		return "/img_item/list";
	}


	@RequestMapping(value = "/img_item/login", method = RequestMethod.GET)
	public String login() {
		return "/img_item/login";
	}

	@RequestMapping(value = "/img_item/login", method = RequestMethod.POST)
	public String login(String id, HttpSession session) {
		session.setAttribute("id", id);
		return "redirect:../";
	}

	@RequestMapping(value = "/img_item/delete")
	public String delete(int img_num) throws Exception {

		if (itemdao.delete(img_num)) {
			return "redirect:./list";
		} else {
			return "error";
		}
	}

	@RequestMapping(value = "/img_item/update", method = RequestMethod.POST)
	public String update(Img_itemDTO dto) throws Exception {
		
		if (itemdao.update(dto)) {

			return "redirect:./list";
		} else {
			return "error";
		}

	}

	@RequestMapping(value = "/img_item/update", method = RequestMethod.GET)
	public String update(int img_num, Model model) throws Exception {

		model.addAttribute("dto", itemdao.read(img_num));

		return "/img_item/update";
	}

	@RequestMapping("/img_item/read")
	public String read(int img_num, Model model, HttpServletRequest request) throws Exception {
		itemdao.upViewcnt(img_num);
		Img_itemDTO dto = itemdao.read(img_num);

		dto.setImg_content(dto.getImg_content().replaceAll("\r\n", "<br>"));

		model.addAttribute("grade", itemdao.getgrade(dto.getId()));
		model.addAttribute("dto", dto);

		return "/img_item/read";
	}

	@RequestMapping(value = "/img_item/create", method = RequestMethod.POST)
	public String create(Img_itemDTO dto, HttpServletRequest request, HttpSession session) throws Exception {
		String basePath = request.getRealPath("/img_item/storage");

		int filesize = (int) dto.getFileMF().getSize();
		String img_photo = "";
		if (filesize > 0) {
			img_photo = Utility.saveFile(dto.getFileMF(), basePath);
		}
		dto.setImg_photo(img_photo);
		dto.setFilesize(filesize);
		dto.setId((String) session.getAttribute("id"));
		boolean flag = itemdao.create(dto);

		if (flag) {
			return "redirect:./list";
		} else {
			return "error";
		}
	}

	@RequestMapping(value = "/img_item/create", method = RequestMethod.GET)
	public String create() {

		return "/img_item/create";
	}

	@RequestMapping("/main")
	public String main(HttpSession session, Model model) {
		model.addAttribute("id", session.getAttribute("id"));
		return "/main";
	}

}
