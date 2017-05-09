package com.briup.run.common.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//用户信息

public class Memberinfo implements java.io.Serializable {
	//用户的id
	private Long id;
	//当前用户的等级
	private Graderecord graderecord;
	//用户昵称
	private String nickname;
	//密码
	private String password;
	//性别
	private String gender;
	//年龄
	private Long age;
	//电子邮件地址
	private String email;
	//所在省市
	private String provincecity;
	//详细地址
	private String address;
	//电话
	private String phone;
	//找回密码的提示问题
	private String passwordquestion;
	//找回密码的提示问题的答案
	private String passwordanswer;
	//推荐人
	private String recommender;
	//积分(积米)
	private Long point = 0L;
	//注册时间
	private Date registerdate;
	//最后一次登录时间
	private Date latestdate;
	//用户账户的状态  0:正常 1:注销/冻结 
	private Long status;
	//用户是否在线 0:下线 1:在线
	private Long isonline;
	//用户的个人空间
	private Memberspace memberSpace;
	
	public Memberinfo() {
		super();
	}

	public Memberinfo(String nickname, String password, String gender,
			Long age, String email) {
		this.nickname = nickname;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.email = email;
	}

	public Memberinfo(Graderecord graderecord, String nickname,
			String password, String gender, Long age, String email,
			String provincecity, String address, String phone,
			String passwordquestion, String passwordanswer, String recommender,
			Long point, Date registerdate, Date latestdate, Long status,
			Long isonline, Memberspace memberSpace) {
		this.graderecord = graderecord;
		this.nickname = nickname;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.provincecity = provincecity;
		this.address = address;
		this.phone = phone;
		this.passwordquestion = passwordquestion;
		this.passwordanswer = passwordanswer;
		this.recommender = recommender;
		this.point = point;
		this.registerdate = registerdate;
		this.latestdate = latestdate;
		this.status = status;
		this.isonline = isonline;
		this.memberSpace = memberSpace;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Graderecord getGraderecord() {
		return this.graderecord;
	}

	public void setGraderecord(Graderecord graderecord) {
		this.graderecord = graderecord;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getAge() {
		return this.age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProvincecity() {
		return this.provincecity;
	}

	@Override
	public String toString() {
		return "Memberinfo [id=" + id + ", graderecord=" + graderecord + ", nickname=" + nickname + ", password="
				+ password + ", gender=" + gender + ", age=" + age + ", email=" + email + ", provincecity="
				+ provincecity + ", address=" + address + ", phone=" + phone + ", passwordquestion=" + passwordquestion
				+ ", passwordanswer=" + passwordanswer + ", recommender=" + recommender + ", point=" + point
				+ ", registerdate=" + registerdate + ", latestdate=" + latestdate + ", status=" + status + ", isonline="
				+ isonline + ", memberSpace=" + memberSpace + "]";
	}

	public void setProvincecity(String provincecity) {
		this.provincecity = provincecity;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPasswordquestion() {
		return this.passwordquestion;
	}

	public void setPasswordquestion(String passwordquestion) {
		this.passwordquestion = passwordquestion;
	}

	public String getPasswordanswer() {
		return this.passwordanswer;
	}

	public void setPasswordanswer(String passwordanswer) {
		this.passwordanswer = passwordanswer;
	}

	public String getRecommender() {
		return this.recommender;
	}

	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}

	public Long getPoint() {
		return this.point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

	public Date getRegisterdate() {
		return this.registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}

	public Date getLatestdate() {
		return this.latestdate;
	}

	public void setLatestdate(Date latestdate) {
		this.latestdate = latestdate;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getIsonline() {
		return this.isonline;
	}

	public void setIsonline(Long isonline) {
		this.isonline = isonline;
	}

	public Memberspace getMemberSpace() {
		return memberSpace;
	}

	public void setMemberSpace(Memberspace memberSpace) {
		this.memberSpace = memberSpace;
	}

}