package spring.model.reply;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * <pre>
 * Copyright 2016 JAVADB Course, Inc. All rights reserved.
 * 패키지명        : spring.model.reply 
 * 파일명          : ReplyMgr.java , 2017. 3. 13. 오전 11:44:23
 * 작성자          : 신준영
 * 작성자 email    : sinjy87@naver.com
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

@Service
public class ReplyMgr {
	
	@Autowired
	private ReplyDAO dao = null; 
	
	/**
	 * 댓글 글쓰기
	 */
	public boolean create(ReplyDTO dto){
	
		
		return dao.create(dto);
	}
	
	/**
	 * 댓글 보기
	 */
	public ReplyDTO read(int reply_num){
		ReplyDTO dto = null;
		
		try {
			dto = (ReplyDTO) dao.read(reply_num);
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			
		}
		
		return dto;
	}
	
	/**
	 * 댓글 수정
	 */
	public boolean update(ReplyDTO dto){
		boolean flag = false;
		try {
			flag = dao.update(dto);
		} catch (Exception e) {
			System.out.println(e);
		}finally{
		}
		
		return flag;
	}
	
	/**
	 * 댓글 삭제
	 */
	public boolean delete(int reply_num){
		boolean flag = false;
		try {
			flag = dao.delete(reply_num);
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			
		}
		
		return flag;
	}
	
	/**
	 * 댓글에 답글 생성
	 */
	public boolean rcreate(ReplyDTO dto, Map map){
		boolean flag = false;
		try{
			dao.upAnsnum(map);
			flag = dao.rcreate(dto);
			
		} catch (Exception e){
			System.out.println(e);
		}finally{
			
		}
		
		return flag;
		
	}
	
	/**
	 * 댓글 리스트
	 */
	public List<ReplyDTO> getList(Map map){
		
		List<ReplyDTO> v = null;
		try{
			v = dao.list(map);
		}catch(Exception e){
			System.out.println(e);
		}finally{
		}
		
		return v;
	}
	
	/**
	 * 댓글 총 수
	 */
	public int getTotal(Map map){
		int total = 0;
		
		try {
			total = dao.total(map);
		} catch (Exception e) {
			System.out.println(e);
		}finally{
		}
		
		return total;
	}
	
	

}
