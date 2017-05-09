package com.briup.run.service;

import java.util.List;

import com.briup.run.common.exception.DataAccessException;
import com.briup.run.common.exception.MemberServiceException;
import com.briup.run.common.bean.Blackrecord;
import com.briup.run.common.bean.Friendrecord;
import com.briup.run.common.bean.Graderecord;
import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Memberspace;
import com.briup.run.common.bean.Pointaction;
import com.briup.run.common.bean.Pointrecord;

public interface IMemberService {
	// 用户注册
	void registerMemberinfo(Memberinfo memberinfo) throws MemberServiceException;
	
	// 按照姓名查找用户
	Memberinfo findMemberinfoByName(String nickname) throws MemberServiceException;
	
	// 通过用户名登录
	Memberinfo login(String username, String passwd) throws MemberServiceException;
	
	// 登出
	void logout(String nickname) throws MemberServiceException;
	
	//找回密码
	boolean findNewPassword(String nickname,String passwdQuestion,String passwdAnswer) throws MemberServiceException;
	
	// 查找前几名用户
	List<Memberinfo> findMemberinfoByNum(int number) throws MemberServiceException;
	
	// 查找在线用户
	int findMemberinfoOnline() throws MemberServiceException;
	
	// 按照积分查找等级
	Graderecord findMemberinfoLevel(Long point) throws MemberServiceException;
	
	// 保存或者更新用户
	Memberinfo saveOrUpDate(Memberinfo memberinfo, String oldPasswd) throws MemberServiceException;
	
	// 通过提示问题和答案来获取密码
	String getBackPasswd(String nickname, String pwdQuestion, String pwdAnswer) throws MemberServiceException;
	
	// 修改用户信息
	void update(Memberinfo memberinfo) throws MemberServiceException;
	
	// 保存或修改用户信息
	void saveFriend(String selfname, String friendname) throws MemberServiceException;
	void updateFriend(String selfname, String friendname) throws MemberServiceException;
	
	// 查找好友
	List<Friendrecord> listFriend(String selfname) throws MemberServiceException;
	
	// 转到黑名单
	void moveToBlack(String selfname, String blackname) throws MemberServiceException;
	
	// 获取黑名单人员
	List<Blackrecord> listBlack(String selfname) throws MemberServiceException;
	
	// 查找好友
	Friendrecord findFriend(String friend) throws MemberServiceException;
	//随机从数据库查找一名好友
	List<Memberinfo> findOneFriend(String string) throws MemberServiceException;
	//从数据库有条件查找
	List<Memberinfo> findFriends(String nickname, String age, String gender,
			String provincecity) throws MemberServiceException;
	// 判断是否有个人空间
	Memberspace isMemberspace(Long id) throws MemberServiceException;
	//保存或更新个人空间
	void saveSpace(Memberspace space) throws MemberServiceException;
	void updateSpace(Memberspace space) throws MemberServiceException;
	// 转到好友
	void moveToFriend(String selfName, String name_searching) throws MemberServiceException;
	
	// 删除黑名单
	void deleteBlack(String selfName, String black) throws MemberServiceException;
	
	// 删除好友
	void deleteFriend(String selfName, String friend) throws MemberServiceException;
	
	// 删除空间
	void delSpace(Long id) throws MemberServiceException;

	// 按照名字超找积分动作
	Pointaction findPointactionByPointAction(String actionName)throws MemberServiceException;

	// 保存加积分的记录
	void save(Pointrecord pointrecord) throws MemberServiceException;

	
}
