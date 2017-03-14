package spring.model.member;

import org.springframework.web.multipart.MultipartFile;
/**
 * 
 * <pre>
 * Copyright 2017 JAVADB Course, Inc. All rights reserved.
 * 패키지명        : spring.model.member 
 * 파일명          : MemberDTO.java , 2017. 3. 13. 오전 11:36:42
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
	private MultipartFile photoMF; // 프로필사진올리기용
	private MultipartFile bgphotoMF; // 배경사진올리기용

	/** 년월(가입,탈퇴회원수) */
	private String statdate;
	/** 가입회원수 */
	private int signup;
	/** 탈퇴회원수 */
	private int withdrawal;

	
	
	/** 년월(가입,탈퇴회원수) */
	public String getStatdate() {
		return statdate;
	}

	/** 년월(가입,탈퇴회원수) */
	public void setStatdate(String statdate) {
		this.statdate = statdate;
	}

	/** 가입회원수 */
	public int getSignup() {
		return signup;
	}

	/** 가입회원수 */
	public void setSignup(int signup) {
		this.signup = signup;
	}

	/** 탈퇴회원수 */
	public int getWithdrawal() {
		return withdrawal;
	}

	/** 탈퇴회원수 */
	public void setWithdrawal(int withdrawal) {
		withdrawal = withdrawal;
	}

	/** 배경사진MF */
	public MultipartFile getBgphotoMF() {
		return bgphotoMF;
	}

	/** 배경사진MF */
	public void setBgphotoMF(MultipartFile bgphotoMF) {
		this.bgphotoMF = bgphotoMF;
	}

	/** 프로필사진MF */
	public MultipartFile getPhotoMF() {
		return photoMF;
	}

	/** 프로필사진MF */
	public void setPhotoMF(MultipartFile photoMF) {
		this.photoMF = photoMF;
	}

	/** ID */
	public String getId() {
		return id;
	}

	/** ID */
	public void setId(String id) {
		this.id = id;
	}

	/** 비밀번호 */
	public String getPassword() {
		return password;
	}

	/** 비밀번호 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** E-mail */
	public String getEmail() {
		return email;
	}

	/** E-mail */
	public void setEmail(String email) {
		this.email = email;
	}

	/** 가입날짜 */
	public String getMdate() {
		return mdate;
	}

	/** 가입날짜 */
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	/** 관심사항저장하기위한 */
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

	/** 관심사항저장하기위한 */
	public void setInterests(String interests) {
		this.interests = interests;
	}

	/** 관심사항 */
	public String[] getInter() {
		return inter;
	}

	/** 관심사항 */
	public void setInter(String[] inter) {
		this.inter = inter;
	}

	/** 배경화면 */
	public String getBgphoto() {
		return bgphoto;
	}

	/** 배경화면 */
	public void setBgphoto(String bgphoto) {
		this.bgphoto = bgphoto;
	}

	/** 프로필화면 */
	public String getPhoto() {
		return photo;
	}

	/** 프로필화면 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/** 프로필글 */
	public String getProfile() {
		return profile;
	}

	/** 프로필글 */
	public void setProfile(String profile) {
		this.profile = profile;
	}

	/** 등급 */
	public String getGrade() {
		return grade;
	}

	/** 등급 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
