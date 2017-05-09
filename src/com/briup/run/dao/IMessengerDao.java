package com.briup.run.dao;

import java.util.List;

import com.briup.run.common.exception.DataAccessException;
import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Messagerecord;

public interface IMessengerDao {
	//查找新邮件数量
	Integer findNewMessageNum(String nickname) throws DataAccessException;
	
	//查找会员个数
	Integer findMemberinfoNum() throws DataAccessException;
	
	//查找一个会员
	Memberinfo findOneMemberinfo(int sum) throws DataAccessException;
	
	//通过年龄，性别，城市查找朋友
	List findFriends(String age, String gender, String city) throws DataAccessException;
	
	//保存短信
	void saveMessage(Messagerecord message) throws DataAccessException;
	//更新短信
	void updateMessage(Messagerecord message) throws DataAccessException;
	//获取已发的邮件
	List<Messagerecord> listSendMessage(String sender) throws DataAccessException;
	
	//获取已收已读的邮件
	List<Messagerecord> listRecieveMessageRe(String recieveName) throws DataAccessException;
	//获取已收未读的邮件
	List<Messagerecord> listRecieveMessageR(String recieveName) throws DataAccessException;
	//查看邮件
	Messagerecord findMessage(Long id) throws DataAccessException;
	
	//删除收到的邮件
	void delRecieveMessage(Long id) throws DataAccessException;
	
	//删除已发的邮件
	void delSendMessage(Long id) throws DataAccessException;
}
