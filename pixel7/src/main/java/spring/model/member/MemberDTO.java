package spring.model.member;

public class MemberDTO {
	private String id;// 회원아이디
	private String password;// 비밀번호
	private String email;// 이메일
	private String mdate;// 회원가입일
	private String interests;// 관심분야를 담기위한
	private String[] inter;// 관심분야
	private String bgphoto;// 배경사진
	private String photo;// 프로필사진
	private String profile;// 프로필글
	private String grade;// 회원등급

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public String getInterests() {
		if (inter != null) {
			String interests = "";
			for (int i = 0; i < inter.length; i++) {
				interests += inter[i];
				if (i < inter.length - 1) {
					interests += ",";
				}
			}
			this.interests = interests;
		}
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String[] getInter() {
		return inter;
	}

	public void setInter(String[] inter) {
		this.inter = inter;
	}

	public String getBgphoto() {
		return bgphoto;
	}

	public void setBgphoto(String bgphoto) {
		this.bgphoto = bgphoto;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
