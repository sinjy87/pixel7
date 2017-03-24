package spring.model.cart;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAO implements pixel7_CartDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	@Override
	public Object getNum2(Map map){
		return mybatis.selectList("cart.num", map);
	}
	
	@Override
	public String getId2(int img_num) {
		String id = mybatis.selectOne("cart.id", img_num);
		return id;
	}
	
	@Override
	public String getContent2(int img_num) {
		String content = mybatis.selectOne("cart.content", img_num);
		return content;
	}
	
	@Override
	public String getPhoto2(int img_num) {
		String photo = mybatis.selectOne("cart.photo", img_num);
		return photo;
	}
	
	@Override
	public String getPrice2(int img_num) {
		String price = mybatis.selectOne("cart.price", img_num);
		return price;
	}

	
	
	
	@Override
	public boolean create(Object dto) throws Exception {
		boolean flag=false;
		int cnt = mybatis.insert("cart.create", dto);
		if(cnt>0) flag=true;
		return flag;
	}

	@Override
	public List list(Map map) throws Exception {
		return mybatis.selectList("cart.list", map);
	}

	@Override
	public Object read(Object cart_num) throws Exception {
		
		return mybatis.selectOne("cart.read", cart_num);
	}

	@Override
	public boolean update(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object cart_num) throws Exception {
		boolean flag = false;
		int cnt = mybatis.delete("cart.delete", cart_num);
		if(cnt>0) flag=true;
		return flag;
	}

	@Override
	public int total(Map map) throws Exception {
		
		return mybatis.selectOne("cart.total", map);
	}



}
