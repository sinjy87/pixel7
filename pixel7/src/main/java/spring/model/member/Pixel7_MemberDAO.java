package spring.model.member;

import java.util.Map;

import spring.model.pixel7.DAOSTDInter;

public interface Pixel7_MemberDAO extends DAOSTDInter {
	boolean updatePw(String id, String password);

	boolean passwdCheck(String id, String password);

	boolean updateGd(String id, String grade);

	Object photoName(String id);

	Object statDate(Map map);

	String getGrade(String id);
}
