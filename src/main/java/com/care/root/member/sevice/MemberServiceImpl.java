package com.care.root.member.sevice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.MemberMapper;

@Service
public class MemberServiceImpl 
						implements MemberService{
	BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
	
	@Autowired
	MemberMapper mapper;
	public int user_check(HttpServletRequest request) {
		MemberDTO dto = 
			mapper.user_check( request.getParameter("id") );
		if(dto != null) {
			if( enc.matches(request.getParameter("pw"), dto.getPw()) || dto.getPw().equals(request.getParameter("pw")) ) {
				return 0;
			}
		}
		return 1;
	}
	public void memberInfo(Model model) {
		model.addAttribute("list",mapper.memberInfo() );
	}
	public void info(Model model, String id) {
		model.addAttribute("data", mapper.user_check(id));
	}
	public int register(MemberDTO dto) {
		
		String s = enc.encode( dto.getPw() );
		
		dto.setPw(s);
		
		return mapper.register(dto);
	}
	public void delete(String id) {
		mapper.delete(id);
	}
	public void modify(MemberDTO dto) {
		
		System.out.println(dto.getPw());
		System.out.println( dto.getPw().length() );
		
		if(dto.getPw().length() < 60) {
			String s = enc.encode( dto.getPw() );
			dto.setPw(s);
		}
		
		mapper.modify(dto);
	}
	public void keepLogin(String sessionId,String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("sessionId", sessionId);
		map.put("id", id);
		
		mapper.keepLogin( map );

	}
	public MemberDTO getSessionId(String sessionId) {
		return mapper.getSessionId(sessionId);
	}
}












