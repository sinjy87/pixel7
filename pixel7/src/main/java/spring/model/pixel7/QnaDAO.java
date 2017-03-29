package spring.model.pixel7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnaDAO implements DAOSTDInter {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	@Override
	public boolean create(Object dto) throws Exception {

		boolean flag = false;
		
		int cnt = sqlSession.insert("qna.create", dto);
		if(cnt>0)
			flag = true;
		
		return flag;
	}

	@Override
	public List list(Map map) throws Exception {
		
		return sqlSession.selectList("qna.list", map);
	}

	@Override
	public Object read(Object pk) throws Exception {

		return sqlSession.selectOne("qna.read", pk);
	}

	@Override
	public boolean update(Object dto) throws Exception {
		
		boolean flag = false;
		
		int cnt = sqlSession.update("qna.update", dto);
		if(cnt>0)
			flag = true;
		
		return flag;
	}

	@Override
	public boolean delete(Object pk) throws Exception {
		boolean flag = false;
		
		int cnt = sqlSession.delete("qna.delete", pk);
		if(cnt>0)
			flag = true;
		
		return flag;
	}
	
	public int rdelete(int qna_num){
		
		return sqlSession.delete("qna_reply.rdelete", qna_num);
	}
	
	
	

	@Override
	public int total(Map map) throws Exception {
		
		return sqlSession.selectOne("qna.total", map);
	}

	@Override
	public int total(String col, String word) {
		// TODO Auto-generated method stub
		return 0;
	}

}
