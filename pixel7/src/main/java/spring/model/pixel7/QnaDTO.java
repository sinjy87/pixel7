package spring.model.pixel7;

import org.springframework.web.multipart.MultipartFile;

public class QnaDTO {

	private int qna_num;
	private String qna_title;
	private String id;
	private String qna_password;
	private String qna_filename;
	private String qna_content;
	private String qna_date;
	private int qna_viewcnt;
	private int qna_check;
	private MultipartFile qna_MF;
	
		
	
	public MultipartFile getQna_MF() {
		return qna_MF;
	}
	public void setQna_MF(MultipartFile qna_MF) {
		this.qna_MF = qna_MF;
	}
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQna_password() {
		return qna_password;
	}
	public void setQna_password(String qna_password) {
		this.qna_password = qna_password;
	}
	public String getQna_filename() {
		return qna_filename;
	}
	public void setQna_filename(String qna_filename) {
		this.qna_filename = qna_filename;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public String getQna_date() {
		return qna_date;
	}
	public void setQna_date(String qna_date) {
		this.qna_date = qna_date;
	}
	public int getQna_viewcnt() {
		return qna_viewcnt;
	}
	public void setQna_viewcnt(int qna_viewcnt) {
		this.qna_viewcnt = qna_viewcnt;
	}
	public int getQna_check() {
		return qna_check;
	}
	public void setQna_check(int qna_check) {
		this.qna_check = qna_check;
	}

	
	
	
	
	
	
	
}
