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

import spring.model.i_order.I_orderDAO;
import spring.model.i_order.I_orderDTO;
import spring.utility.pixel7.Utility;

@Controller
public class I_orederController {
	
	@Autowired
	private I_orderDAO dao;
	
	
	
	
	@RequestMapping(value = "/iorder/create", method = RequestMethod.POST)
	public String create(I_orderDTO dto,Model model) throws Exception{
		model.addAttribute("dao", dao);
		if (dao.create(dto)) {
			Map map =new HashMap();
			dto =(I_orderDTO) dao.getNum(map);
			model.addAttribute("dto", dto);
			return "/iorder/update";
		}else{
			return "./home";
		}
	}
	
	@RequestMapping(value = "/iorder/create", method = RequestMethod.GET)
	public String create(){
		
		return "/iorder/create";
	}
	
	
	@RequestMapping("/iorder/list")
	public String list(Model model) throws Exception{
		
		Map map = new HashMap();
		List<I_orderDTO> list = dao.list(map);
		model.addAttribute("list", list);
		model.addAttribute("dao",dao);
		return "/iorder/list";
	}

}