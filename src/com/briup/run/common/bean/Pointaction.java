package com.briup.run.common.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Pointaction entity.
 * 
 * @author MyEclipse Persistence Tools
 */


//代表哪些 可以加分的动作/行为 的类 
public class Pointaction implements java.io.Serializable {

	// Fields

	private Long id;
	//当前这个可以加分的动作/行为的名字 例如:登录 注册等
	private String actionname;
	//完成这个动作可以给用户加多少分
	private Long point;
	//对这个动作描述
	private String description;
	//有哪些动作记录中是引用了当前这个动作
	private Set pointrecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public Pointaction() {
	}

	/** minimal constructor */
	public Pointaction(Long point) {
		this.point = point;
	}

	/** full constructor */
	public Pointaction(String actionname, Long point, String description,
			Set pointrecords) {
		this.actionname = actionname;
		this.point = point;
		this.description = description;
		this.pointrecords = pointrecords;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActionname() {
		return this.actionname;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname;
	}

	public Long getPoint() {
		return this.point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getPointrecords() {
		return this.pointrecords;
	}

	public void setPointrecords(Set pointrecords) {
		this.pointrecords = pointrecords;
	}

}