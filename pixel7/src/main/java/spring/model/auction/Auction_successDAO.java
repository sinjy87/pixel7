package spring.model.auction;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Auction_successDAO {
	@Autowired
	private SqlSession SqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		SqlSession = sqlSession;
	}

}
