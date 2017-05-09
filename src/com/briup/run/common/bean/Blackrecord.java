package com.briup.run.common.bean;

/**
 * Blackrecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */

//记录黑名单的一个类
public class Blackrecord implements java.io.Serializable {

	// Fields

	private Long id;
	//用户名
	private String selfname;
	//用户所拉黑的其他会员的名字
	private String blackname;

	// Constructors

	/** default constructor */
	public Blackrecord() {
	}

	/** full constructor */
	public Blackrecord(String selfname, String blackname) {
		this.selfname = selfname;
		this.blackname = blackname;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSelfname() {
		return this.selfname;
	}

	public void setSelfname(String selfname) {
		this.selfname = selfname;
	}

	public String getBlackname() {
		return this.blackname;
	}

	public void setBlackname(String blackname) {
		this.blackname = blackname;
	}

}