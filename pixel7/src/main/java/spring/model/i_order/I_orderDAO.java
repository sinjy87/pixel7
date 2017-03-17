package spring.model.i_order;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class I_orderDAO implements pixel7_I_orderDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	@Override
	public Object getNum(Map map){
		return mybatis.selectList("i_order.num", map);
	}
	
	@Override
	public String getId(int img_num) {
		String id = mybatis.selectOne("i_order.id", img_num);
		return id;
	}
	
	@Override
	public String getContent(int img_num) {
		String content = mybatis.selectOne("i_order.content", img_num);
		return content;
	}
	
	@Override
	public String getPhoto(int img_num) {
		String photo = mybatis.selectOne("i_order.photo", img_num);
		return photo;
	}
	
	@Override
	public String getPrice(int img_num) {
		String price = mybatis.selectOne("i_order.price", img_num);
		return price;
	}

	@Override
	public boolean create(Object dto) throws Exception {
		boolean flag = false;
		int cnt = mybatis.insert("i_order.create", dto);
		if (cnt > 0)
			flag = true;
		return flag;
	}

	@Override
	public List list(Map map) throws Exception {

		return mybatis.selectList("i_order.list", map);
	}

	@Override
	public Object read(Object i_order_num) throws Exception {
		return mybatis.selectOne("i_order.read", i_order_num);
	}

	@Override
	public boolean update(Object dto) throws Exception {
		boolean flag = false;
		int cnt = mybatis.update("i_order.update", dto);
		if (cnt > 0)
			flag = true;
		return flag;
	}

	@Override
	public boolean delete(Object i_order_num) throws Exception {
		boolean flag = false;
		int cnt = mybatis.delete("i_order.delete", i_order_num);
		if (cnt > 0)
			flag = true;
		return flag;
	}

	@Override
	public int total(Map map) throws Exception {

		return mybatis.selectOne("i_order.total", map);
	}

}
