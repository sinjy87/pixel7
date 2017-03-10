package spring.model.member;

import spring.model.pixel7.DAOSTDInter;

public interface Pixel7_MemberDAO extends DAOSTDInter {
	boolean updatePw(String id, String password);
	boolean passwdCheck(String id, String password);
	boolean updateGd(String id,String grade);
}
