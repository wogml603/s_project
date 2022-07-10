package com.care.root.member.sevice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {
	public int user_check(HttpServletRequest request);
	public void memberInfo(Model model);
	public void info(Model model, String id);
	
	public int register(MemberDTO dto);
	public void delete(String id);
	
	public void modify(MemberDTO dto);
	public void keepLogin(String sessionId,String id);
	
	public MemberDTO getSessionId(String sessionId);
}

















