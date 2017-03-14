package spring.model.reply;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * <pre>
 * Copyright 2016 JAVADB Course, Inc. All rights reserved.
 * ��Ű����        : spring.model.reply 
 * ���ϸ�          : ReplyMgr.java , 2017. 3. 13. ���� 11:44:23
 * �ۼ���          : ���ؿ�
 * �ۼ��� email    : sinjy87@naver.com
 * ��������
 * ----------------------------------------------
 * ���� �̷�
 * ---------------------------------------------- 
 * ������      ������  ����ó
 *   
 * ��������
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
	 * ��� �۾���
	 */
	public boolean create(ReplyDTO dto){
		boolean flag = false;
		
		try{
			flag = dao.create(dto);
			
		} catch (Exception e){
			System.out.println(e);
		}finally{
			
		}
		
		return flag;
	}
	
	/**
	 * ��� ����
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
	 * ��� ����
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
	 * ��� ����
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
	 * ��ۿ� ��� ����
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

}
