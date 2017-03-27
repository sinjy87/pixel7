package spring.sts.pixel7;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.model.pixel7.Qna_replyDAO;


@Controller
public class Qna_replyController {

	@Autowired
	private Qna_replyDAO doa;

	


}
