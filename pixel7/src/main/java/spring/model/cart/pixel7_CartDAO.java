package spring.model.cart;

import spring.model.pixel7.DAOSTDInter;

public interface pixel7_CartDAO extends DAOSTDInter {

	String getId2(int img_num);

	String getContent2(int img_num);

	String getPhoto2(int img_num);

	String getPrice2(int img_num);

}
