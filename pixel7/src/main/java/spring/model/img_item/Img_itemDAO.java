package spring.model.img_item;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class Img_itemDAO implements Pixel7_Img_itemDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	/** junit test */
	
	public void upViewcnt(int img_num) {
		mybatis.update("img_item.upViewcnt", img_num);

	}

	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	@Override
	public boolean create(Object dto) throws Exception {
		boolean flag = false;

		int cnt = mybatis.insert("img_item.create", dto);

		if (cnt > 0) {
			flag = true;
		}

		return flag;
	}

	@Override
	public List list(Map map) throws Exception {

		return mybatis.selectList("img_item.list", map);
		
	}

	@Override
	public Img_itemDTO read(Object img_num) throws Exception {
		return mybatis.selectOne("img_item.read", img_num);
	}

	@Override
	public boolean update(Object dto) throws Exception {
		boolean flag = false;

		int cnt = mybatis.update("img_item.update", dto);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean delete(Object img_num) throws Exception {
		boolean flag = false;
		int cnt = mybatis.delete("img_item.delete", img_num);

		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public int total(Map map) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getgrade(String id) {
		
		return mybatis.selectOne("img_item.grade",id);
	}

}
