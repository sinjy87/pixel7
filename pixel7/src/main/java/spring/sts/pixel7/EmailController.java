package spring.sts.pixel7;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmailController {

	@Autowired
	private JavaMailSender mailSender;

	int code;
	

	@RequestMapping(value = "/mail", method = RequestMethod.POST)
	public String mailForm(String incode, Model model) {
		System.out.println("code확인" + code);
		System.out.println("incode확인" + incode);
		int intcode = Integer.parseInt(incode);
		String url = "emailProc";
		if (intcode == code) {
			model.addAttribute("sts", "성공");

		} else {
			model.addAttribute("sts", "실패");
		}
		return url;
	}

	/** 메일발송 */
	@RequestMapping(value = "/mail", method = RequestMethod.GET)
	public String mailSending(HttpServletRequest request) {
		code = new Random().nextInt(100000) + 10000;
		String setfrom = "mail.pixel7.gmail.com";
		String tomail = request.getParameter("tomail"); // 받는 사람 이메일
		String title = "인증번호"; // 보내는 사람 이메일
		String content = "안녕하세요." + "pixel7입니다." + "인증번호는" + code + "입니다";// 보내는
		String url = "./email"; // 사람
		// 이메일
		System.out.println(tomail);
		System.out.println(title);
		System.out.println(content);

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 생략하거나 하면 정상작동을 안함
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(content); // 메일 내용

			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
			url = "error";
		}

		return url;
	}
}
