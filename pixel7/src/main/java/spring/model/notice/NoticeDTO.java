package spring.model.notice;

public class NoticeDTO {

private   int	     notice_no         ; //숫자
private String       id                ; //글에 권한 
private String       notice_labeldate  ; //출력할 날짜 2013-10-20 
private String       notice_label      ; //달력에 출력될 레이블
private String       notice_title      ; //글제목
private String       notice_content    ; //글내용
private String       notice_cnt        ; // 조회수
private String       notice_date       ; //등록 날짜


	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;

	} 

	public String getId() {
		return id;

	}

	public void setId(String id) {
		this.id = id;

	}

	public String getNotice_labeldate() {
		return notice_labeldate;

	}

	public void setNotice_labeldate(String notice_labeldate) {
		this.notice_labeldate = notice_labeldate;
	}

	public String getNotice_label() {
		return notice_label;
	}

	public void setNotice_label(String notice_label) {
		this.notice_label = notice_label;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public String getNotice_cnt() {
		return notice_cnt;
	}

	public void setNotice_cnt(String notice_cnt) {
		this.notice_cnt = notice_cnt;
	}

	public String getNotice_date() {
		return notice_date;
	}

	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}
	


}
