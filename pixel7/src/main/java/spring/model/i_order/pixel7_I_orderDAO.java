package spring.model.i_order;

import java.util.List;
import java.util.Map;

import spring.model.pixel7.DAOSTDInter;

public interface pixel7_I_orderDAO extends DAOSTDInter {
	String getPrice(int img_num);

	String getPhoto(int img_num);

	String getContent(int img_num);

	String getId(int img_num);

	Object getNum(Map map);
}
