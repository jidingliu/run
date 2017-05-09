package com.briup.run.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.run.common.bean.Blackrecord;
import com.briup.run.common.bean.Friendrecord;
import com.briup.run.common.bean.Graderecord;
import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Memberspace;
import com.briup.run.common.bean.Pointaction;
import com.briup.run.common.bean.Pointrecord;
import com.briup.run.common.exception.DataAccessException;
import com.briup.run.common.exception.MemberServiceException;
import com.briup.run.common.util.MD5;
import com.briup.run.common.util.RandomChar;
import com.briup.run.dao.IMemberDao;
import com.briup.run.service.IMemberService;

@Service
public class MemberServiceImpl implements IMemberService{

	@Resource
	IMemberDao memberDao;
	/**
	 * 注册用户
	 */
	@Override
	public void registerMemberinfo(Memberinfo memberinfo)
			throws MemberServiceException {
		Date date = new Date();
		String name = memberinfo.getNickname();
		Memberinfo member = findMemberinfoByName(name);
			try {
				if(member == null) { 
				//从数据库查到积米数 再赋给用户
				memberinfo.setPoint(memberDao.findPointactionByPointAction("REGISTER").getPoint());
				
				//获取推荐人  并且做相应处理
				String recommender = memberinfo.getRecommender();
				Memberinfo mf = findMemberinfoByName(recommender);
				if(mf != null){
					mf.setPoint(mf.getPoint()+memberDao.findPointactionByPointAction("RECOMMEND").getPoint());
					mf.setGraderecord(memberDao.findMemberinfoLevel(mf.getPoint()));
					memberDao.updateMemberinfo(mf);
				}
				//保存等级
				memberinfo.setGraderecord(memberDao.findMemberinfoLevel(memberinfo.getPoint()));
				//保存注册时间
				memberinfo.setRegisterdate(date);
				memberinfo.setPassword(MD5.getMD5Str(memberinfo.getPassword()));
				memberDao.saveMemberinfo(memberinfo);
				} else {
					throw new MemberServiceException("该用户已经注册,请重新注册");
				}
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
		
	}

	//根据名字查找到用户
	@Override
	public Memberinfo findMemberinfoByName(String nickname)
			throws MemberServiceException {
		try {
			Memberinfo memberinfo = memberDao.findMemberinfoByName(nickname);
			return memberinfo;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	//登录操作
	@Override
	public Memberinfo login(String username, String passwd)
			throws MemberServiceException {
		Date date = new Date();
		try {
		Memberinfo member = findMemberinfoByName(username);
		if(member == null) {
			throw new MemberServiceException("该用户不存在");
		}
		if(MD5.getMD5Str(passwd).equals(member.getPassword())) {
			if(member.getLatestdate() != null) {
				if(date.getDate() != member.getLatestdate().getDate()) {
				member.setPoint(member.getPoint()+memberDao.findPointactionByPointAction("LOGIN").getPoint());
				}
			}
			member.setIsonline(1L);
			member.setLatestdate(date);
			member.setGraderecord(memberDao.findMemberinfoLevel(member.getPoint()));
			memberDao.updateMemberinfo(member);
		}else{
			throw new MemberServiceException("密码不正确");
		}
			return member;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//更新个人信息
	@Override
	public void update(Memberinfo memberinfo) throws MemberServiceException {
		try {
			memberDao.updateMemberinfo(memberinfo);
		} catch (DataAccessException e) {
			
			e.printStackTrace();
		}
	}

	
	//找回密码
	@Override
	public String getBackPasswd(String nickname, String passwordquestion,
			String passwordanswer) throws MemberServiceException {
			Memberinfo member;
			try {
				member = memberDao.findMemberinfoByName(nickname);
			
			if(member == null) {
				throw new MemberServiceException("没有该成员");
			}
			if(passwordquestion.equals(member.getPasswordquestion())){
					if(passwordanswer.equals(member.getPasswordanswer())){
						String password = RandomChar.getChars(RandomChar.RANDOM_NUMBERS,6);
						member.setPassword(MD5.getMD5Str(password));
						memberDao.updateMemberinfo(member);
						return password;
					}else{
						throw new MemberServiceException("密码提示答案输入错误");
					}
			}else{
				throw new MemberServiceException("密码提示问题输入错误");
			}
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
		return null;
	}


	//登出操作
	@Override
	public void logout(String nickname) throws MemberServiceException {
		try {
			Memberinfo member = memberDao.findMemberinfoByName(nickname);
			member.setStatus(1L);
			member.setIsonline(0L);
			memberDao.updateMemberinfo(member);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
	//判断是否有个人空间
	@Override
	public Memberspace isMemberspace(Long id) throws MemberServiceException {
		try {
			Memberspace space = memberDao.findSpace(id);
			return space;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//保存个人空间
	public void saveSpace(Memberspace memberspace) throws MemberServiceException {
		try {
			memberDao.saveSpace(memberspace);
		} catch (DataAccessException e) {
			throw new MemberServiceException(e.getMessage());
		}
		
	}

	//更新个人空间
	@Override
	public void updateSpace(Memberspace space)
			throws MemberServiceException {
		try {
			memberDao.updateSpace(space);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	

	//查出前十个成员
	@Override
	public List<Memberinfo> findMemberinfoByNum(int number)
			throws MemberServiceException {
		try {
			List<Memberinfo> member = memberDao.findMemberinfoByNum(number);
			return member;
		} catch (DataAccessException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	//查找在线成员数量
	@Override
	public int findMemberinfoOnline() throws MemberServiceException {
		try {
			Integer count = memberDao.findMemberinfoOnline();
			return count;
		} catch (DataAccessException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

	//随机从数据库查找一名好友
	@Override
	public List<Memberinfo> findOneFriend(String name) throws MemberServiceException {
		try {
			List<Memberinfo> members = memberDao.findOneFriend(name);
			return members;
		} catch (DataAccessException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	//从数据库有条件查找
		public List<Memberinfo> findFriends(String nickname,String age,String gender,String provincecity) throws MemberServiceException {
			long min;
			long max;
			if(gender.equals("unlimited")) {
				gender = null;
			}
			if(provincecity.equals("unlimited")) {
				provincecity = null;
			}
			if(age.equals("unlimited")) {
				min = 0;
				max = 120;
			}else {
				min = Long.parseLong(age.split("-")[0]);
				max = Long.parseLong(age.split("-")[1]);
			}
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("min", min);
			map.put("max", max);
			map.put("gender", gender);
			map.put("provincecity", provincecity);
			map.put("nickname", nickname);
			List<Memberinfo> friends;
			try {
				friends = memberDao.findFriends(map);
				return friends;
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			return null;
		} 
	//查找好友
	@Override
	public List<Friendrecord> listFriend(String selfname)
			throws MemberServiceException {
		try {
			List<Friendrecord> friend = memberDao.listFriend(selfname);
			return friend;
		} catch (DataAccessException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	//添加好友
	@Override
	public void saveFriend(String selfname, String friendname)
			throws MemberServiceException {
		try {
			List<Friendrecord> listFriend = listFriend(selfname);
			if(listFriend != null) {
				for (Friendrecord friendrecord : listFriend) {
					if(friendname.equals(friendrecord.getFriendname()))
						throw new MemberServiceException("您已经添加该好友");
				}
			}
			List<Blackrecord> listBlack = listBlack(selfname);
			if(listBlack != null){
				for (Blackrecord blackrecord : listBlack) {
					if(friendname.equals(blackrecord.getBlackname()))
						throw new MemberServiceException("您已经添加该好友，并且已将他设置为黑名单!如需添加，请去黑名单列表移到好友列表");
				}
			}
			memberDao.saveFriend(new Friendrecord(selfname, friendname));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
	//更新好友
	@Override
	public void updateFriend(String selfname, String friendname)
			throws MemberServiceException {
		try {
			memberDao.updateFriend(new Friendrecord(selfname, friendname));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	//添加到黑名单
	public void moveToBlack(String selfname, String blackname)
			throws MemberServiceException {
		try {
			memberDao.saveBlackFriend(new Blackrecord(selfname, blackname));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
	//从黑名单移除
	@Override
	public void deleteBlack(String selfname, String black)
			throws MemberServiceException {
		try {
			memberDao.updateBlackFriend(new Blackrecord(selfname, black));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	//查出所以黑名单
	@Override
	public List<Blackrecord> listBlack(String selfname)
			throws MemberServiceException {
		try {
			List<Blackrecord> listBlack = memberDao.listBlack(selfname);
			return listBlack;
		} catch (DataAccessException e) {
			
			e.printStackTrace();
		}
		return null;
	}

		
	
	
	
	@Override
	public Graderecord findMemberinfoLevel(Long point)
			throws MemberServiceException {
		
		return null;
	}

	@Override
	public Memberinfo saveOrUpDate(Memberinfo memberinfo, String oldPasswd)
			throws MemberServiceException {
		
		return null;
	}

	@Override
	public Friendrecord findFriend(String friend) throws MemberServiceException {
		
		return null;
	}


	@Override
	public void moveToFriend(String selfName, String name_searching)
			throws MemberServiceException {
	}

	
	@Override
	public void deleteFriend(String selfName, String friend)
			throws MemberServiceException {
	}

	@Override
	public void delSpace(Long id) throws MemberServiceException {
	}

	@Override
	public Pointaction findPointactionByPointAction(String actionName)
			throws MemberServiceException {
		
		return null;
	}

	@Override
	public void save(Pointrecord pointrecord) throws MemberServiceException {
	}

	@Override
	public boolean findNewPassword(String nickname, String passwdQuestion,
			String passwdAnswer) throws MemberServiceException {
		// TODO Auto-generated method stub
		return false;
	}



	
	
}
