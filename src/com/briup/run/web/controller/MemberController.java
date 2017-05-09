package com.briup.run.web.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.briup.run.common.bean.Blackrecord;
import com.briup.run.common.bean.Friendrecord;
import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Memberspace;
import com.briup.run.common.exception.DataAccessException;
import com.briup.run.common.exception.MemberServiceException;
import com.briup.run.common.util.MD5;
import com.briup.run.service.IMemberService;

@Controller
@SessionAttributes(value={"authCode","member"})
public class MemberController {
	@Resource
	IMemberService service;
	
	@RequestMapping("/register")
	public String goRegister() {
		return "register";
	}
	/**
	 * 注册部分
	 */
	@RequestMapping("/register.action") 
		public ModelAndView Register(Memberinfo member,String authCode,@ModelAttribute("authCode") String authcode) {
			ModelAndView mv=new ModelAndView();
			try {
				if(authCode.equals(authcode)) {
					service.registerMemberinfo(member);
				mv.setViewName("forward:/login");
				mv.addObject("msg", "注册成功");
				return mv;
				}else {
					throw new MemberServiceException("同志，验证码不正确呢");
				}
			} catch (Exception e) {
				mv.addObject("msg", e.getMessage());
				mv.setViewName("register");
				return mv;
			}
			
		}
	@RequestMapping("/checkCode")
	public @ResponseBody Map<String,Object> checkCode(String authCode,@ModelAttribute("authCode") String authcode){
		Map<String,Object> map = new HashMap<>();
		if(authCode.equals(authcode)) {
			map.put("msg", "验证通过");
		}else{
			map.put("msg", "验证码不正确");
		}
		return map; 
	}
	@RequestMapping("/checkRMember")
	public @ResponseBody Map<String,Object> checkRMember(String nickname){
		Map<String,Object> map = new HashMap<>();
		try {
			Memberinfo member = service.findMemberinfoByName(nickname);
			if(member != null) {
				map.put("msg", "该用户名已被注册!");
			}else{
				map.put("msg", "该用户名可以注册!");
			}
		} catch (MemberServiceException e) {
			e.printStackTrace();
		}
		return map; 
	}
	@RequestMapping("/checkLMember")
	public @ResponseBody Map<String,Object> checkLMember(String nickname){
		Map<String,Object> map = new HashMap<>();
		try {
			Memberinfo member = service.findMemberinfoByName(nickname);
			if(member != null) {
				map.put("msg", "可以登录");
			}else{
				map.put("msg", "用户名不存在");
			}
		} catch (MemberServiceException e) {
			e.printStackTrace();
		}
		return map; 
	}
	/**
	 * 登录登出部分
	 */
	@RequestMapping("/index")
	public ModelAndView index(ModelMap model,HttpServletRequest request)
	{
		//在此处查找是否自动登录
				ModelAndView mv = new ModelAndView();
				try {
				model.addAttribute("count", service.findMemberinfoOnline());
				model.addAttribute("list", service.findMemberinfoByNum(10));	
				Cookie[] cookie = request.getCookies();

				String nickname = null;
				String password = null;
				if(cookie == null) {
					mv.setViewName("login");
				}
				for(Cookie c : cookie){
					String name = c.getName();
					if("nickname".equals(name)){
						nickname = c.getValue();
					}
					if("password".equals(name)){
						password = c.getValue();
					}
				}
						Memberinfo member = service.login(URLDecoder.decode(nickname), URLDecoder.decode(password));
						if(member != null) {
						model.addAttribute("member", member);
						mv.addObject("msg",URLDecoder.decode(nickname)+"登录成功");
						mv.setViewName("activity");
						}
					} catch (Exception e) {
						mv.setViewName("login");
						e.printStackTrace();
					}
				return mv;
			}
	@RequestMapping("/login")
	public String login(Model model){
		try {
			model.addAttribute("list", service.findMemberinfoByNum(10));
		} catch (MemberServiceException e) {
			e.printStackTrace();
		}
		return "login";
	}
	
	@RequestMapping("/login.action")
	public ModelAndView Login(ModelMap model,String nickname,String password,String autoLogin,String authCode,
				@ModelAttribute("authCode") String authcode,HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		try {
			
			if(authCode.equals(authcode)) {
				Memberinfo member = service.login(nickname, password);
				if(member != null) {
					model.addAttribute("count", service.findMemberinfoOnline());
					model.addAttribute("list", service.findMemberinfoByNum(10));
					model.addAttribute("member", member);
					if(autoLogin != null) {
						Cookie c1 = new Cookie("nickname", URLEncoder.encode(nickname));
						Cookie c2 = new Cookie("password", URLEncoder.encode(password));
						
						c1.setMaxAge(60*60);
						c2.setMaxAge(60*60);
						
						response.addCookie(c1);
						response.addCookie(c2);
					}
					mv.addObject("msg", nickname+"登录成功");
					mv.setViewName("activity");
				}
			} else {
				throw new MemberServiceException("验证码不正确,请重新登录");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("login");
		}
		return mv;
	}
	
	@RequestMapping("/activity")
	public String goActivity(@ModelAttribute("member") Memberinfo member,Model model) {
		try {
			if(member == null){
				return "index";
			}
			model.addAttribute("count", service.findMemberinfoOnline());
			model.addAttribute("list", service.findMemberinfoByNum(10));	
		} catch (MemberServiceException e) {
			e.printStackTrace();
		}
		return "activity";
	}
	@RequestMapping("/logout") 
	public String logout(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			session.setAttribute("count", service.findMemberinfoOnline());
			session.setAttribute("list", service.findMemberinfoByNum(10));
		Cookie[] cookies = request.getCookies();
		String nickname = null;
		for (Cookie cookie : cookies) {
			if("nickname".equals(cookie.getName())){
				nickname = cookie.getValue();
				service.logout(nickname);
			}
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/login";
	}
	//修改个人信息
	@RequestMapping("modify.action")
	public ModelAndView modify(ModelMap model,@ModelAttribute("member") Memberinfo member,String oldpasswd,String newpasswd,String newpasswdre,
			String email,String passwdquestion,String passwdanswer,String gender,String provincecity,
			String phone,String address) {
			ModelAndView mv = new ModelAndView();
		try {
			if(MD5.getMD5Str(oldpasswd).equals(member.getPassword())){
				member.setPassword(MD5.getMD5Str(newpasswdre));
				member.setEmail(email);
				member.setPasswordquestion(passwdquestion);
				member.setPasswordanswer(passwdanswer);
				member.setGender(gender);
				member.setProvincecity(provincecity);
				member.setPhone(phone);
				member.setAddress(address);
			
				System.out.println("..."+member);
				service.update(member);
				
				model.addAttribute("count", service.findMemberinfoOnline());
				model.addAttribute("list", service.findMemberinfoByNum(10));
				model.addAttribute("member", member);
				
				mv.addObject("msg", "修改成功,点击确认返回主页");
				mv.setViewName("activity");
			} else {
				throw new MemberServiceException("原密码不对");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.getMessage());
			mv.setViewName("modify");
		}
		return mv;
	}
	
	@RequestMapping("modify")
	public String goModify() {
		return "modify";
	}
	
	//处理密码丢失
		@RequestMapping("/passwd_missing")
		public String passwd_missing() {
			return "passwd_missing";
		}
		@RequestMapping("/passwd_missing.action")
		public ModelAndView dopassword(ModelMap model,String nickname,String passwordquestion,String passwordanswer,HttpSession session) {
			ModelAndView mv = new ModelAndView();
				try {
					model.addAttribute("count", service.findMemberinfoOnline());
					model.addAttribute("list", service.findMemberinfoByNum(10));
					String backPasswd = service.getBackPasswd(nickname, passwordquestion, passwordanswer);
					mv.addObject("msg", "新密码是"+backPasswd);
					mv.setViewName("login");
				} catch (MemberServiceException e) {
					mv.addObject("msg", e.getMessage());
					mv.setViewName("passwd_missing");
				}
			return mv;
		}
		
		@RequestMapping("/findOneFriend.do")
		public ModelAndView findOneFriend(@ModelAttribute("member") Memberinfo member,ModelMap model) {
			ModelAndView mv = new ModelAndView();
			System.out.println(member);
			try {
				List<Memberinfo> members = service.findOneFriend(member.getNickname());
				if(members != null) {
					model.addAttribute("members", members);
					mv.setViewName("matchFriend");
				}else {
					throw new MemberServiceException("查找不到任何成员");
				}
			} catch (MemberServiceException e) {
				mv.addObject("msg", e.getMessage());
				mv.setViewName("matchFriend");
				e.printStackTrace();
			}
			
			return mv;
		}
		
		@RequestMapping("/matchFriends.do")
		public ModelAndView matchFriends(HttpSession session,Model model,String age,String gender,String provincecity) {
			ModelAndView mv = new ModelAndView();
			try {
				Memberinfo member = (Memberinfo) session.getAttribute("member");
				List<Memberinfo> members = service.findFriends(member.getNickname(),age, gender, provincecity);
				if(members != null) {
					System.out.println(members);
					model.addAttribute("members", members);
					mv.setViewName("matchFriend");
				}else {
					throw new MemberServiceException("查找不到任何成员");
				}
			} catch (MemberServiceException e) {
				mv.addObject("msg", e.getMessage());
				mv.setViewName("matchFriend");
				e.printStackTrace();
			}
			return mv;
		
		}
		@RequestMapping("/addFriends.action")
		public ModelAndView addFriends(HttpSession session,String nickname) {
			ModelAndView mv = new ModelAndView();
			Memberinfo member = (Memberinfo)session.getAttribute("member");
			try {
				service.saveFriend(member.getNickname(), nickname);
				mv.addObject("msg", "添加好友"+nickname+"成功");
				mv.setViewName("forward:/matchFriend");
			} catch (MemberServiceException e) {
				mv.addObject("msg",e.getMessage());
				mv.setViewName("forward:/matchFriend");
				e.printStackTrace();
			}
			return mv;
		}
		@RequestMapping("/buddyList")
		public String goBuddyList(@ModelAttribute("member") Memberinfo member,ModelMap model) {
			try {
				List<Memberinfo> list = new ArrayList<>();
				List<Friendrecord> listFriend = service.listFriend(member.getNickname());
				for (Friendrecord friendrecord : listFriend) {
					String friendname = friendrecord.getFriendname();
					Memberinfo memberinfo = service.findMemberinfoByName(friendname);
					list.add(memberinfo);
				}
				model.addAttribute("friends", list);
			} catch (MemberServiceException e) {
				e.printStackTrace();
			}
			
			return "buddyList";
		}
		@RequestMapping("/moveToBlackList.do")
		public ModelAndView movetoblack(HttpSession session,String blackName) {
			ModelAndView mv = new ModelAndView();
			Memberinfo member = (Memberinfo)session.getAttribute("member");
			try {
				service.updateFriend(member.getNickname(), blackName);
				service.moveToBlack(member.getNickname(), blackName);
				mv.addObject("msg", "已将"+blackName+"移到黑名单");
				mv.setViewName("forward:/buddyList");
			} catch (MemberServiceException e) {
				mv.addObject("msg","移除失败");
				mv.setViewName("buddyList");
				e.printStackTrace();
			}
			
			return mv;
		}
		
		@RequestMapping("/blackList")
		public String goBlackList(@ModelAttribute("member") Memberinfo member,Model model) {
			try {
				List<Memberinfo> list = new ArrayList<>();
				List<Blackrecord> listBlack = service.listBlack(member.getNickname());
				for (Blackrecord blackrecord : listBlack) {
					String blackname = blackrecord.getBlackname();
					Memberinfo memberinfo = service.findMemberinfoByName(blackname);
					list.add(memberinfo);
				}
				model.addAttribute("blackfriends", list);
			} catch (MemberServiceException e) {
				e.printStackTrace();
			}
			
			return "blackList";
		}
		
		@RequestMapping("/moveToFriendList.do")
		public ModelAndView moveToBlackList(HttpSession session,String blackName) {
			ModelAndView mv = new ModelAndView();
			Memberinfo member = (Memberinfo)session.getAttribute("member");
			String selfname = member.getNickname();
			try {
				service.deleteBlack(selfname, blackName);
				service.saveFriend(selfname, blackName);
				mv.addObject("msg", "已将"+blackName+"移到好友名单");
				mv.setViewName("forward:/blackList");
			} catch (MemberServiceException e) {
				mv.addObject("msg","移除失败");
				mv.setViewName("blackList");
				e.printStackTrace();
			}
			
			return mv;
		}
		@RequestMapping("/deleteFriendBuddy.action")
		public ModelAndView deleteFriendBuddy(HttpSession session,String[] nickName) {
			ModelAndView mv = new ModelAndView();
			Memberinfo member = (Memberinfo)session.getAttribute("member");
			try{
			for (String friendname : nickName) {
				service.updateFriend(member.getNickname(), friendname);
			}
			mv.setViewName("forward:/buddyList");
			}catch(MemberServiceException e) {
				e.printStackTrace();
			}
			return mv;
		}
		@RequestMapping("/deleteBlackBuddy.action")
		public ModelAndView deleteBlackBuddy(HttpSession session,String[] nickName) {
			ModelAndView mv = new ModelAndView();
			Memberinfo member = (Memberinfo)session.getAttribute("member");
			String selfname = member.getNickname();
			try{
			for (String blackname : nickName) {
				service.deleteBlack(selfname, blackname);
			}
			mv.setViewName("forward:/blackList");
			}catch(MemberServiceException e) {
				e.printStackTrace();
			}
			return mv;
		}
		@RequestMapping("/space")
		public String gospace(@ModelAttribute("member") Memberinfo member,Model model) {
			try {
				Memberspace memberspace = service.isMemberspace(member.getId());
				member.setMemberSpace(memberspace);
				model.addAttribute("member", member);
				System.out.println(member);
			} catch (MemberServiceException e) {
				e.printStackTrace();
			}
			return "space";
		}
		//判断有没有空间
		@RequestMapping("/ishavespace")
		public ModelAndView goSpace(@ModelAttribute("member") Memberinfo member,Model model){
			ModelAndView mv = new ModelAndView();
			try {
					Memberspace memberspace = service.isMemberspace(member.getId());
					if(memberspace != null) {
						mv.setViewName("redirect:/space");
					}else{
						throw new MemberServiceException("没有个性空间");
					}
			} catch (MemberServiceException e) {
				mv.setViewName("nospace");
				e.printStackTrace();
			}
			return mv;
		}
		@RequestMapping("createSpace.action")
		public ModelAndView createSpace(String opinion,String runtime,
				String runhabit,String runstar,String cellphone,String runplace,MultipartFile icon,@ModelAttribute("member")Memberinfo memberinfo,Model model)
		{
			ModelAndView mv = new ModelAndView();
			try {
				
				String path = "C:\\Users\\Administrator\\Desktop\\project\\apache-tomcat-7.0.67\\upload\\"+icon.getOriginalFilename();
				File newFile=new java.io.File(path);
				if(!newFile.getParentFile().exists()){
					newFile.getParentFile().mkdirs();
				}
				icon.transferTo(newFile);
				Memberspace space = new Memberspace();
				space.setIcon("/upload/"+icon.getOriginalFilename());
				space.setMemberinfo(memberinfo);
				space.setOpinion(opinion);
				space.setRuntime(runtime);
				space.setRunhabit(runhabit);
				space.setRunplace(runplace);
				space.setRunstar(runstar);
				space.setCellphone(cellphone);
				service.saveSpace(space);
				memberinfo.setMemberSpace(space);
				model.addAttribute("member",memberinfo);
				
				mv.addObject("msg", "成功创建个性空间");
				mv.setViewName("space");
				return mv;
			} catch (Exception e) {
				mv.addObject("msg", e.getMessage());
				mv.setViewName("createSpace");
				return mv;
			} 
			
		}
		
		@RequestMapping("modifySpace.action") 
		public ModelAndView modifySpace(String opinion,String runtime,
				String runhabit,String runstar,String cellphone,String runplace,MultipartFile icon,@ModelAttribute("member")Memberinfo memberinfo,Model model)
		{
			ModelAndView mv = new ModelAndView();
			try {
				Memberspace memberspace = service.isMemberspace(memberinfo.getId());
				Memberspace space = new Memberspace();
				if(!icon.isEmpty()){
					String path = "C:\\Users\\Administrator\\Desktop\\project\\apache-tomcat-7.0.67\\upload\\"+icon.getOriginalFilename();
					File newFile=new java.io.File(path);
					if(!newFile.getParentFile().exists()){
						newFile.getParentFile().mkdirs();
					}
					icon.transferTo(newFile);
					space.setIcon("/upload/"+icon.getOriginalFilename());
				}else{
					space.setIcon(memberspace.getIcon());
				}
				space.setMemberinfo(memberinfo);
				space.setOpinion(opinion);
				space.setRuntime(runtime);
				space.setRunhabit(runhabit);
				space.setRunplace(runplace);
				space.setRunstar(runstar);
				space.setCellphone(cellphone);
				
				service.updateSpace(space);
				memberinfo.setMemberSpace(space);
				model.addAttribute("member",memberinfo);
				
				mv.addObject("msg", "成功修改个性空间");
				mv.setViewName("space");
				return mv;
			} catch (Exception e) {
				mv.addObject("msg", "修改失败");
				mv.setViewName("modifySpace");
				return mv;
			}
		}
		
		
		@RequestMapping("/matchFriend")
		public String goMatchFriend() {
			return "matchFriend";
		}
		
		@RequestMapping("/memberList")
		public String goMemberList() {
			return "memberList";
		}
		
		@RequestMapping("/nospace")
		public String goNoSpace(){
			return "nospace";
		}
		@RequestMapping("/createSpace")
		public String gocreateSpace(){
			return "createSpace";	
		}
		
		@RequestMapping("/modifySpace")
		public String goModifySpace() {
			return "modifySpace";
		}
		
}
