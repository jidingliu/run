package com.briup.run.dao;

import java.util.List;
import java.util.Map;

import com.briup.run.common.exception.DataAccessException;
import com.briup.run.common.exception.MemberServiceException;
import com.briup.run.common.bean.Blackrecord;
import com.briup.run.common.bean.Friendrecord;
import com.briup.run.common.bean.Graderecord;
import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Memberspace;
import com.briup.run.common.bean.Pointaction;
import com.briup.run.common.bean.Pointrecord;

public interface IMemberDao {
	//按姓名查找用户
	Memberinfo findMemberinfoByName(String name) throws DataAccessException;
	
	//保存或更新用户
	void saveMemberinfo(Memberinfo memberinfo) throws DataAccessException;
	void updateMemberinfo(Memberinfo memberinfo) throws DataAccessException;
	
	//查找前几名用户 
	List<Memberinfo> findMemberinfoByNum(int number)throws DataAccessException;
	
	//查找在线用户数量
	Integer findMemberinfoOnline()throws DataAccessException;
	
	//按照积分查找等级
	Graderecord findMemberinfoLevel(Long point)throws DataAccessException;
	
	//按照积分动作查找Pointaction类
	Pointaction findPointactionByPointAction(String pointAction)throws DataAccessException;
	
	//保存积分记录
	void savePointrecord(Pointrecord pointrecord) throws DataAccessException;
	void updatePointrecord(Pointrecord pointrecord) throws DataAccessException;
	
	//保存好友信息
	void saveFriend(Friendrecord friend) throws DataAccessException;
	void updateFriend(Friendrecord friend) throws DataAccessException;
	
	//保存黑名单会员
	void saveBlackFriend(Blackrecord friend) throws DataAccessException;
	void updateBlackFriend(Blackrecord friend) throws DataAccessException;
	
	//随机从数据库查找一名
	List<Memberinfo> findOneFriend(String name) throws DataAccessException;
	//从数据库有条件查找
	List<Memberinfo> findFriends(Map<String, Object> map) throws DataAccessException;
	
	//查找本人的所有好友
	List<Friendrecord> listFriend(String selfname) throws DataAccessException;
	
	//查找本人的所有黑名单
	List<Blackrecord> listBlack(String selfname) throws DataAccessException;

	//查找好友
	Friendrecord findfriend(String selfName, String friendName) throws DataAccessException;
	
	//查找黑名单
	Blackrecord findBlack(String selfName, String blackName) throws DataAccessException;
	
	//查找个人空间
	Memberspace findSpace(Long id) throws DataAccessException;
	//保存或更新个人空间
	void saveSpace(Memberspace space) throws DataAccessException;
	void updateSpace(Memberspace space) throws DataAccessException;
	//删除个人空间
	void delSpace(Memberspace space) throws DataAccessException;
}
