package spring.sts.pixel7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.cart.CartDAO;
import spring.model.cart.CartDTO;

@Controller
public class CartController {

	@Autowired
	private CartDAO dao;

	@RequestMapping("/cart/list")
	public String list(Model model) throws Exception {

		Map map = new HashMap();
		List<CartDTO> list = dao.list(map);
		model.addAttribute("list", list);
		model.addAttribute("dao", dao);
		return "/cart/list";
	}

	@RequestMapping(value = "/cart/create", method = RequestMethod.POST)
	public String create(CartDTO dto, Model model) throws Exception {
		dto.setId("vip");
		model.addAttribute("dao", dao);
		if (dao.create(dto)) {
			// Map map =new HashMap();
			// List list =(List) dao.getNum(map);
			// model.addAttribute("list", list);
			return "/cart/createProc";
		} else {
			return "redirect:../";
		}
	}

	@RequestMapping(value = "/cart/create", method = RequestMethod.GET)
	public String create(Model model, HttpSession session, int img_num) throws Exception {
		String url = "/cart/create";
		Map map = new HashMap();
		map.put("jj", "dd");
		map.put("id", "vip");
		List list = dao.list(map);
		for (int i = 0; list.size() > i; i++) {
			CartDTO dto = (CartDTO) list.get(i);
			if (dto.getImg_num() == img_num) {
				url = "error";
			}
		}

		model.addAttribute("dao", dao);
		return url;
	}
}
