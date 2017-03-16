package spring.model.message;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * <pre>
 * Copyright 2017 JAVADB Course, Inc. All rights reserved.
 * 패키지명        : spring.model.message 
 * 파일명          : MessageDAO.java , 2017. 3. 15. 오전 11:59:40
 * 작성자          : 정내용
 * 작성자 email    : content_j@naver.com
 * 수정내용
 * ----------------------------------------------
 * 수정 이력
 * ---------------------------------------------- 
 * 수정일      수정자  연락처
 *   
 * 수정내용
 *
 * ----------------------------------------------
 * 
 * </pre>
 */
@Repository
public class MessageDAO implements Pixel7_MessageDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	/** junit 테스트용 */
	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	/** 쪽지생성 */
	@Override
	public boolean create(Object dto) throws Exception {
		boolean flag = false;
		int cnt = mybatis.insert("message.create", dto);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List list(Map map) throws Exception {

		return mybatis.selectList("message.list", map);
	}

	@Override
	public Object read(Object message_num) throws Exception {
		return mybatis.selectOne("message.read", message_num);
	}

	@Override
	public boolean update(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object message_num) throws Exception {
		boolean flag = false;
		int cnt = mybatis.delete("message.delete", message_num);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public int total(Map map) throws Exception {
		return mybatis.selectOne("message.total", map);
	}

	@Override
	public String getGrade(String id) {
		return mybatis.selectOne("message.getgrade", id);
	}

}
