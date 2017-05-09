package com.briup.run.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Messagerecord;
import com.briup.run.common.exception.DataAccessException;
import com.briup.run.common.exception.MessengerServiceException;
import com.briup.run.dao.IMessengerDao;
import com.briup.run.service.IMessengerService;
@Service
public class MessageServiceImpl implements IMessengerService {

	@Resource
	IMessengerDao messagedao;
	//保存新信息
	@Override
	public void saveMessage(Messagerecord message)
			throws MessengerServiceException {
		message.setSenddate(new Date());
		message.setStatus(0L);
		message.setSenderstatus(0L);
		message.setReceiverstatus(0L);
		try {
			messagedao.saveMessage(message);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
	//更新信息
	public void updateMessage(Messagerecord message) throws MessengerServiceException {
		try {
			messagedao.updateMessage(message);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
	
	//发件箱 
	public List<Messagerecord> listSendMessage(String senderName) throws MessengerServiceException {
		try {
			List<Messagerecord> listSendMessage = messagedao.listSendMessage(senderName);
			return listSendMessage;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	 //获取已收已读的邮件
	public List<Messagerecord> listRecieveMessageRe(String recieveName) throws  MessengerServiceException  {
		try {
			List<Messagerecord> listRecieveMessageRe = messagedao.listRecieveMessageRe(recieveName);
			return listRecieveMessageRe;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	//获取已收未读的邮件
	public List<Messagerecord> listRecieveMessageR(String recieveName) throws  MessengerServiceException  {
		try {
			List<Messagerecord> listRecieveMessageR = messagedao.listRecieveMessageR(recieveName);
			return listRecieveMessageR;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Messagerecord findMessage(Long id) throws MessengerServiceException {
		try {
			Messagerecord findMessage = messagedao.findMessage(id);
			findMessage.setStatus(1L);
			messagedao.updateMessage(findMessage);
			return findMessage;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delRecieveMessage(Long id) throws MessengerServiceException {
		try {
			messagedao.delRecieveMessage(id);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delSendMessage(Long id) throws MessengerServiceException {
		try {
			messagedao.delSendMessage(id);
		} catch (DataAccessException e) {
			
			e.printStackTrace();
		}
	}

	
	
	@Override
	public List<Memberinfo> findFriends(String age, String gender, String city)
			throws MessengerServiceException {
		
		return null;
	}
	@Override
	public Integer findNewMessageNum(String nickname)
			throws MessengerServiceException {

		return null;
	}

	@Override
	public Memberinfo findOneMemberinfo() throws MessengerServiceException {

		return null;
	}
	
}
