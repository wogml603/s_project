package com.care.root.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.sevice.MemberService;

public class AutoLogin extends HandlerInterceptorAdapter{
	@Autowired MemberService ms;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("컨트롤 전 실행됩니다!!!!");
		Cookie cook = 
			WebUtils.getCookie(request, "loginCookie");
		if( cook != null ) {
			MemberDTO dto = ms.getSessionId( cook.getValue() );
			if(dto != null) {
				request.getSession().setAttribute(
						SessionName.LOGIN, dto.getId() );
			}
		}
		
		return true;
	}
}







