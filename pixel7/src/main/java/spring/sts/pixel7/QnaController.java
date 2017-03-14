package spring.sts.pixel7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.model.pixel7.QnaDAO;

@Controller
public class QnaController {
	
	@Autowired
	private static QnaDAO dao;
	
	
	@RequestMapping("/qna/list")
	public String list(){
		
		
		
		
		return "/qna/list";
	}
	

}
