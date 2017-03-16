package spring.model.message;

import spring.model.pixel7.DAOSTDInter;

public interface Pixel7_MessageDAO extends DAOSTDInter {
	String getGrade(String id);
}
