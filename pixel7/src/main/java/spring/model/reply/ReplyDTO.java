package spring.model.reply;

public class ReplyDTO {
	private int reply_num; //��� ��ȣ
	private String id;     //ȸ��ID (�ɹ����̺� ������)
	private String reply_content; //��� ����
	private int  reply_like; //��� ���ƿ�
	private int  reply_hate; //��� �Ⱦ��
	private int  reply_ban;  //��� �Ű�
	private int  reply_grpno;  //�θ�� ��ȣ
	private int  reply_indent; //�亯����,�亯�� ����
	private int  reply_ansnum; //�亯 ����
	private String reply_date; // ��� ��¥
	public int getReply_num() {
		return reply_num;
	}
	public void setReply_num(int reply_num) {
		this.reply_num = reply_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public int getReply_like() {
		return reply_like;
	}
	public void setReply_like(int reply_like) {
		this.reply_like = reply_like;
	}
	public int getReply_hate() {
		return reply_hate;
	}
	public void setReply_hate(int reply_hate) {
		this.reply_hate = reply_hate;
	}
	public int getReply_ban() {
		return reply_ban;
	}
	public void setReply_ban(int reply_ban) {
		this.reply_ban = reply_ban;
	}
	public int getReply_grpno() {
		return reply_grpno;
	}
	public void setReply_grpno(int reply_grpno) {
		this.reply_grpno = reply_grpno;
	}
	public int getReply_indent() {
		return reply_indent;
	}
	public void setReply_indent(int reply_indent) {
		this.reply_indent = reply_indent;
	}
	public int getReply_ansnum() {
		return reply_ansnum;
	}
	public void setReply_ansnum(int reply_ansnum) {
		this.reply_ansnum = reply_ansnum;
	}
	public String getReply_date() {
		return reply_date;
	}
	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}
	
	
	
}
