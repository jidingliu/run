package com.briup.run.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.briup.run.common.bean.Memberinfo;
import com.briup.run.common.bean.Messagerecord;
import com.briup.run.common.exception.MemberServiceException;
import com.briup.run.common.exception.MessengerServiceException;
import com.briup.run.service.IMemberService;
import com.briup.run.service.IMessengerService;


@Controller
@SessionAttributes(value="member")
public class MessageController {

	@Resource
	IMessengerService messageService;
	@Resource
	IMemberService memberService;
	@RequestMapping("/sendMessage.do")
	public ModelAndView sendMessage(@ModelAttribute("member") Memberinfo member,Messagerecord messagerecord) {
		ModelAndView mv = new ModelAndView();
		try {
			Memberinfo memberinfo = memberService.findMemberinfoByName(messagerecord.getReceiver());
			if(member.getNickname().equals(messagerecord.getReceiver())){
				throw new MemberServiceException("不能给自己发信息哦！");
			}
			if(memberinfo == null) {
				throw new MemberServiceException("该接收者不存在");
			}
			messagerecord.setSender(member.getNickname());
			messageService.saveMessage(messagerecord);
			mv.addObject("msg", "发送成功");
			mv.setViewName("sendInfo");
		} catch (Exception e) {
			mv.addObject("msg", "发送失败,原因："+e.getMessage());
			mv.setViewName("sendInfo");
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("/outbox")
	public String goOutbox(@ModelAttribute("member") Memberinfo member,Model model) {
		try {
			List<Messagerecord> listSendMessage = messageService.listSendMessage(member.getNickname());
			model.addAttribute("listSendMessage", listSendMessage);
		} catch (MessengerServiceException e) {
			e.printStackTrace();
		}
		return "outbox";
	}
	@RequestMapping("/inbox")
	public String goInbox(@ModelAttribute("member") Memberinfo member,Model model) {
		try {
			List<Messagerecord> listRecieveMessageRe = messageService.listRecieveMessageRe(member.getNickname());
			List<Messagerecord> listRecieveMessageR = messageService.listRecieveMessageR(member.getNickname());
			model.addAttribute("listRecieveMessageRe", listRecieveMessageRe);
			model.addAttribute("listRecieveMessageR", listRecieveMessageR);
		} catch (MessengerServiceException e) {
			e.printStackTrace();
		}
		return "inbox";
	}
	
	@RequestMapping("/view")
	public String goView(Long id,ModelMap model) {
			try {
				Messagerecord message = messageService.findMessage(id);
				model.addAttribute("message", message);
			} catch (MessengerServiceException e) {
				e.printStackTrace();
			}
		return "view";
	}
	@RequestMapping("/delReceiveMessage.action")
	public ModelAndView delReceiveMessage(Long[] id) {
		ModelAndView mv = new ModelAndView();
		try {
		for (Long long1 : id) {
				messageService.delRecieveMessage(long1);
				mv.setViewName("inbox");
		}
		} catch (MessengerServiceException e) {
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping("/delSendMessage.action")
	public ModelAndView delSendMessage(Long[] id) {
		ModelAndView mv = new ModelAndView();
		try {
			for (Long long1 : id) {
					messageService.delSendMessage(long1);
					mv.setViewName("outbox");
			}
			} catch (MessengerServiceException e) {
				e.printStackTrace();
			}
			return mv;
		}
	@RequestMapping("/sendInfo")
	public String goSendInfo() {
		return "sendInfo";
	}
	@RequestMapping("/zsendInfo") 
	public String zsendInfo(String nickname,Model model){
		model.addAttribute("receivename", nickname);
		return "zsendInfo";
	}
	@RequestMapping("/zsend.do")
	public ModelAndView zsend(@ModelAttribute("member") Memberinfo member,Messagerecord messagerecord) {
		ModelAndView mv = new ModelAndView();
	try{
		messagerecord.setSender(member.getNickname());
		messageService.saveMessage(messagerecord);
		mv.addObject("msg", "发送成功");
		mv.setViewName("matchFriend");
		return mv;
	} catch (Exception e) {
		mv.addObject("msg", "发送失败,原因："+e.getMessage());
		mv.setViewName("sendInfo");
		e.printStackTrace();
		return mv;
	}
	}
}
