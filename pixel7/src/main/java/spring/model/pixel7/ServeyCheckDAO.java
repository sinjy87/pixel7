package spring.model.pixel7;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ServeyCheckDAO implements DAOSTDInter {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean create(Object dto) throws Exception {

		boolean flag = false;
		int cnt = sqlSession.insert("serveycheck.create", dto);
		if(cnt>0)
			flag = true;
		
		return flag;
	}

	@Override
	public List list(Map map) throws Exception {

		return sqlSession.selectList("serveycheck.list", map);
	}

	@Override
	public Object read(Object pk) throws Exception {
		
		return sqlSession.selectOne("serveycheck.read", pk);
	}

	@Override
	public boolean update(Object dto) throws Exception {

		boolean flag = false;
		
		int cnt = sqlSession.update("serveycheck.update", dto);
		if(cnt>0)
			flag = true;
			
		return flag;
	}

	@Override
	public boolean delete(Object pk) throws Exception {
		boolean flag = false;
		int cnt = sqlSession.delete("serveycheck.delete", pk);
		if(cnt>0)
			flag = true;
		
		return flag;
	}

	@Override
	public int total(Map map) throws Exception {
		
		return sqlSession.selectOne("serveycheck.total", map);
	}

}
