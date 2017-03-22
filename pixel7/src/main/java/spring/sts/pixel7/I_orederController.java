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

import spring.model.i_order.I_orderDAO;
import spring.model.i_order.I_orderDTO;
import spring.utility.pixel7.Utility;

@Controller
public class I_orederController {
	
	@Autowired
	private I_orderDAO dao;
	
	@RequestMapping("iorder/logout")
	String login(HttpSession session){
		session.invalidate();
		return "redirect:../";
		
	}
	@RequestMapping(value="iorder/login", method = RequestMethod.POST)
	String login(String id,String grade,HttpSession session){
		session.setAttribute("id", id);
		session.setAttribute("grade", grade);
		return "redirect:../";
		
	}
	@RequestMapping(value="iorder/login", method = RequestMethod.GET)
	String login(){
		return "/iorder/login";
		
	}
	
	@RequestMapping(value = "/iorder/delete", method = RequestMethod.GET)
	public String delete(int i_order_num) throws Exception{
		dao.delete(i_order_num);
		return "redirect:../";
	}
	
	@RequestMapping(value = "/iorder/update", method = RequestMethod.POST)
	public String update(I_orderDTO dto,Model model,int i_order_num) throws Exception{
		model.addAttribute("dao", dao);
		dto.setI_order_information("주문완료");
		if (dao.update(dto)) {
			dto =(I_orderDTO) dao.read(i_order_num);
			model.addAttribute("dto", dto);
			return "/iorder/update";
		}else{
			return "redirect:../";
		}
	}
	
	@RequestMapping(value = "/iorder/update", method = RequestMethod.GET)
	public String update(){
		
		return "/iorder/update";
	}
	
	
	@RequestMapping(value = "/iorder/create", method = RequestMethod.POST)
	public String create(I_orderDTO dto,Model model,HttpSession session, int img_num, int i_order_total, String orderid, int i_order_mileage, String i_order_information) throws Exception{
		dto.setId((String)session.getAttribute("id"));
		model.addAttribute("dao", dao);
		System.out.println(i_order_information);
		if (dao.create(dto)) {
			Map map =new HashMap();
			List list =(List) dao.getNum(map);
			model.addAttribute("img_num", img_num);
			model.addAttribute("i_order_total", i_order_total);
			model.addAttribute("orderid", orderid);
			model.addAttribute("i_order_mileage", i_order_mileage);
			model.addAttribute("i_order_information", i_order_information);
			model.addAttribute("list", list);
			return "/iorder/update";
		}else{
			return "redirect:../";
		}
	}
	
	
	
	@RequestMapping(value = "/iorder/create", method = RequestMethod.GET)
	public String create(){
		
		return "/iorder/create";
	}
	
	
	@RequestMapping("/iorder/list")
	public String list(Model model, HttpSession session) throws Exception{
		
		Map map = new HashMap();
		map.put("id", session.getAttribute("id"));
		List<I_orderDTO> list = dao.list(map);
		model.addAttribute("list", list);
		model.addAttribute("dao",dao);
		return "/iorder/list";
	}
}