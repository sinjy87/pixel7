package spring.model.reply;

import java.util.Map;

import spring.model.pixel7.DAOSTDInter;

public interface Pixel7_ReplyDAO extends DAOSTDInter {

	boolean rcreate(Object dto);
	
	void upAnsnum(Map map);
}
