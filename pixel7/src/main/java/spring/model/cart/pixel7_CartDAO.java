package spring.model.cart;

import java.util.Map;

import spring.model.pixel7.DAOSTDInter;

public interface pixel7_CartDAO extends DAOSTDInter {

	String getId2(int img_num);

	String getContent2(int img_num);

	String getPhoto2(int img_num);

	String getPrice2(int img_num);

	Object getNum2(Map map);

}
