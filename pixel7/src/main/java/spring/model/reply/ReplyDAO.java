package spring.model.reply;

import java.util.HashMap;
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
	 * ´ñ±Û »ý¼º
	 */
	@Override
	public boolean create(Object dto) {
		boolean flag = false;
		int cnt = mybatis.insert("reply_create.create",dto);
		if(cnt > 0)flag = true;
		
		return flag;
	}

	/**
	 * ´ñ±Û ¼öÁ¤
	 */
	@Override
	public boolean update(Object dto) throws Exception {
		boolean flag = false;
		int cnt = mybatis.update("reply_create.update", dto);
		if(cnt > 0)flag = true;
				
		return flag;
	}

	/**
	 * ´ñ±Û »èÁ¦
	 */
	@Override
	public boolean delete(Object reply_num) throws Exception {
		boolean flag = false;
		int cnt = mybatis.delete("reply_create.delete", reply_num);
		if(cnt > 0)flag = true;
		return flag;
	}
	
	/**
	 * ´ñ±ÛÀÇ ´ä±Û »ý¼º
	 */
	@Override
	public boolean rcreate(Object dto) {
		boolean flag = false;
		int cnt = mybatis.insert("reply_create.rcreate", dto);
		if(cnt > 0)flag = true;
		return flag;
	}

	/**
	 * ´ñ±Û ¸®½ºÆ®
	 */
	@Override
	public List list(Map map) throws Exception {
		
		return mybatis.selectList("reply_create.list",map);
	}

	/**
	 * ´ä±ÛÀÇ ´ä±Û »ý¼º
	 */
	@Override
	public void upAnsnum(Map map) {
		mybatis.update("reply_create.upAnsnum",map);
	}

	/**
	 * ´ñ±Û º¸±â
	 */
	@Override
	public Object read(Object reply_num) throws Exception {
		
		return mybatis.selectOne("reply_create.readReply",reply_num);
	}

	/**
	 * ´ñ±Û ÃÑ ¼ö
	 */
	@Override
	public int total(Map map) throws Exception {
		
		return mybatis.selectOne("reply_create.total", map);
	}


}
