package spring.model.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

/**
 * 
 * <pre>
 * Copyright 2017 JAVADB Course, Inc. All rights reserved.
 * 패키지명        : spring.model.member 
 * 파일명          : MemberDAO.java , 2017. 3. 13. 오전 11:37:06
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
 *</pre>
 */
@Repository
public class MemberDAO implements Pixel7_MemberDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	
	

	/** junit test용 */
	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	
	
	
	/**회원등급리턴*/
	public String getGrade(String id) {
		return mybatis.selectOne("member.grade", id);
	}

	
	
	/*** 통계용 */
	@Override
	public Object statDate(Map map) {
		return mybatis.selectList("member.statDate", map);
	}

	/** * 프로필사진이름리턴 배경사진이름리턴 */
	@Override
	public Object photoName(String id) {
		return mybatis.selectOne("member.photoName", id);
	}

	/** * 회원가입 */
	@Override
	public boolean create(Object dto) {
		boolean flag = false;
		int cnt = mybatis.insert("member.create", dto);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	/** * 회원목록 */
	@Override
	public List list(Map map) throws Exception {

		return mybatis.selectList("member.list", map);
	}

	/** * 회원정보 */
	@Override
	public Object read(Object id) {
		return mybatis.selectOne("member.read", id);
	}

	/** * 회원수정 */
	@Override
	public boolean update(Object dto) {
		boolean flag = false;
		int cnt = mybatis.update("member.update", dto);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	/** * 회원탈퇴 */
	@Override
	public boolean delete(Object id) {
		boolean flag = false;
		int cnt = mybatis.delete("member.delete", id);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	/** * 토탈 */
	@Override
	public int total(Map map) {
		return mybatis.selectOne("member.total", map);
	}

	/** * 회원등급변경 */
	@Override
	public boolean updateGd(String id, String grade) {
		boolean flag = false;
		Map map = new HashMap();
		map.put("id", id);
		map.put("grade", grade);
		int cnt = mybatis.update("member.updateGd", map);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	/** * 비밀번호변경 */
	@Override
	public boolean updatePw(String id, String password) {
		boolean flag = false;
		Map map = new HashMap();
		map.put("id", id);
		map.put("password", password);
		int cnt = mybatis.update("member.updatePw", map);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

	/** * 비밀번호 확인 */
	@Override
	public boolean passwdCheck(String id, String password) {
		boolean flag = false;
		Map map = new HashMap();
		map.put("id", id);
		map.put("password", password);
		int cnt = mybatis.selectOne("member.passwdCheck", map);
		if (cnt > 0) {
			flag = true;
		}
		return flag;
	}

}
