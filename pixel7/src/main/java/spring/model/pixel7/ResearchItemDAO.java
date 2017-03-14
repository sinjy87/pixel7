package spring.model.pixel7;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class ResearchItemDAO implements DAOSTDInter {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	
	@Override
	public boolean create(Object dto) throws Exception {
		boolean flag = false;
		int cnt = sqlSession.insert("researchitem.create", dto);
		if(cnt>0)
			flag = true;
		return flag;
	}

	@Override
	public List list(Map map) throws Exception {
		
		return sqlSession.selectList("researchitem.list", map);
	}

	@Override
	public Object read(Object pk) throws Exception {
		return sqlSession.selectOne("researchitem.read", pk);
	}

	@Override
	public boolean update(Object dto) throws Exception {
		boolean flag = false;
		int cnt = sqlSession.update("researchitem.update", dto);
		if(cnt>0)
			flag = true;
		return flag;
	}

	@Override
	public boolean delete(Object pk) throws Exception {
		boolean flag = false;
		int cnt = sqlSession.delete("researchitem.delete", pk);
		if(cnt>0)
			flag = true;
		return flag;
	}

	@Override
	public int total(Map map) throws Exception {
		return 0;
	}

}
