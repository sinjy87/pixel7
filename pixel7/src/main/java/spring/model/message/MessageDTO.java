package spring.model.message;

/**
 * 
 * <pre>
 * Copyright 2017 JAVADB Course, Inc. All rights reserved.
 * 패키지명        : spring.model.message 
 * 파일명          : MessageDTO.java , 2017. 3. 15. 오전 11:36:58
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
public class MessageDTO {
	/** 쪽지번호 */
	private int message_num;
	/** 보낸아이디 */
	private String id;
	/** 쪽지내용 */
	private String message_content;
	/** 받는아이디 */
	private String message_id;

	
	/** 받는아이디 */
	public String getMessage_id() {
		return message_id;
	}
	/** 받는아이디 */
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	public int getMessage_num() {
		return message_num;
	}

	public void setMessage_num(int message_num) {
		this.message_num = message_num;
	}
	/** 보낸아이디 */
	public String getId() {
		return id;
	}
	/** 보낸아이디 */
	public void setId(String id) {
		this.id = id;
	}

	public String getMessage_content() {
		return message_content;
	}

	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}

}
