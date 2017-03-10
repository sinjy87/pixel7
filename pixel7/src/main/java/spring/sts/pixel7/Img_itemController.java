package spring.sts.pixel7;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.img_item.Img_itemDAO;
import spring.model.img_item.Img_itemDTO;
import spring.utility.pixel7.Utility;

@Controller
public class Img_itemController {
	@Autowired
	private Img_itemDAO itemdao;
	
	@RequestMapping(value = "/img_item/create", method = RequestMethod.POST)
	public String create(Img_itemDTO dto, HttpServletRequest request) {
		String basePath = request.getRealPath("/img_item/storage");

		int filesize = (int) dto.getFileMF().getSize();
		String img_photo = "";
		if (filesize > 0) {
			img_photo = Utility.saveFile(dto.getFileMF(), basePath);
		}
		dto.setImg_photo(img_photo);
		dto.setFilesize(filesize);

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
	
	

}
