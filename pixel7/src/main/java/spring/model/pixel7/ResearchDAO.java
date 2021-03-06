package spring.model.pixel7;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ResearchDAO implements DAOSTDInter {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean create(Object dto) throws Exception {

		boolean flag = false;
		int cnt = sqlSession.insert("research.create", dto);
		if(cnt>0)
			flag = true;
		
		return flag;
	}

	@Override
	public List list(Map map) throws Exception {

		return sqlSession.selectList("research.list", map);
	}

	@Override
	public Object read(Object pk) throws Exception {
		
		return sqlSession.selectOne("research.read", pk);
	}

	@Override
	public boolean update(Object dto) throws Exception {

		boolean flag = false;
		
		int cnt = sqlSession.update("research.update", dto);
		if(cnt>0)
			flag = true;
			
		return flag;
	}

	@Override
	public boolean delete(Object pk) throws Exception {
		boolean flag = false;
		int cnt = sqlSession.delete("research.delete", pk);
		if(cnt>0)
			flag = true;
		
		return flag;
	}

	@Override
	public int total(Map map) throws Exception {
		
		return sqlSession.selectOne("research.total", map);
	}

	@Override
	public int total(String col, String word) {
		// TODO Auto-generated method stub
		return 0;
	}

}
