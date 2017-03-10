package spring.model.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements Pixel7_MemberDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	/** junit test용 */
	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	@Override
	public boolean create(Object dto) throws Exception {
		boolean flag = false;
		int cnt = mybatis.insert("member.create", dto);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List list(Map map) throws Exception {

		return mybatis.selectList("member.list", map);
	}

	@Override
	public Object read(Object id) throws Exception {
		return mybatis.selectOne("member.read", id);
	}

	@Override
	public boolean update(Object dto) throws Exception {
		boolean flag = false;
		int cnt = mybatis.update("member.update", dto);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean delete(Object id) throws Exception {
		boolean flag =false;
		int cnt =mybatis.delete("member.delete",id);
		if(cnt>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public int total(Map map) throws Exception {
		return mybatis.selectOne("member.total",map);
	}


	@Override
	public boolean updateGd(String id, String grade) {
		boolean flag =false;
		Map map =new HashMap();
		map.put("id", id);
		map.put("grade", grade);
		int cnt = mybatis.update("member.updateGd",map);
		if(cnt>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean updatePw(String id, String password) {
		boolean flag =false;
		Map map =new HashMap();
		map.put("id", id);
		map.put("password", password);
		int cnt = mybatis.update("member.updatePw",map);
		if(cnt>0){
			flag=true;
		}
		return flag;
	}


	@Override
	public boolean passwdCheck(String id, String password) {
		boolean flag =false;
		Map map =new HashMap();
		map.put("id", id);
		map.put("password", password);
		int cnt = mybatis.selectOne("member.passwdCheck",map);
		if(cnt>0){
			flag=true;
		}
		return flag;
	}

}
