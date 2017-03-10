package spring.model.reply;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAO implements Pixel7_ReplyDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	/** junit test */
	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	/**
	 * 댓글 생성
	 */
	@Override
	public boolean create(Object dto) {
		boolean flag = false;
		
		int cnt = mybatis.insert("reply_create.create",dto);
		if(cnt > 0)flag = true;
		
		return flag;
	}

	/**
	 * 댓글 수정
	 */
	@Override
	public boolean update(Object dto) throws Exception {
		boolean flag = false;
		int cnt = mybatis.update("reply_create.update", dto);
		if(cnt > 0)flag = true;
				
		return flag;
	}

	/**
	 * 댓글 삭제
	 */
	@Override
	public boolean delete(Object reply_num) throws Exception {
		boolean flag = false;
		int cnt = mybatis.delete("reply_create.delete", reply_num);
		if(cnt > 0)flag = true;
		return flag;
	}
	
	/**
	 * 댓글의 답글 생성
	 */
	@Override
	public boolean rcreate(Object dto) {
		boolean flag = false;
		int cnt = mybatis.insert("reply_create.rcreate", dto);
		if(cnt > 0)flag = true;
		return flag;
	}

	@Override
	public List list(Map map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 답글의 답글 생성
	 */
	@Override
	public void upAnsnum(Map map) {
		mybatis.update("reply_create.upAnsnum",map);
	}

	/**
	 * 댓글 보기
	 */
	@Override
	public Object read(Object reply_num) throws Exception {
		
		return mybatis.selectOne("reply_create.readReply",reply_num);
	}

	@Override
	public int total(Map map) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}
