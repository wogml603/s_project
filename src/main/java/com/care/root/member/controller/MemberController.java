package com.care.root.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.common.SessionName;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.sevice.MemberService;

@Controller
@RequestMapping("member")
public class MemberController implements SessionName{
	@Autowired
	MemberService ms;
	
	@GetMapping("**")
	public void getMapping() {}
	
	@PostMapping("user_check")
	public String user_check(HttpServletRequest request,
								RedirectAttributes rs) {
		int result = ms.user_check(request);
		if(result == 0) {
			rs.addAttribute("id",request.getParameter("id"));
			rs.addAttribute("autoLogin",
							request.getParameter("autoLogin"));
			return "redirect:successLogin";
		}
		return "redirect:login";
	}
	@GetMapping("successLogin")
	public String successLogin(@RequestParam String id,
				@RequestParam(required = false ) String autoLogin,
								HttpSession session,
							HttpServletResponse response) {
		System.out.println("autoLogin : "+autoLogin);
		session.setAttribute(LOGIN, id);
		if(autoLogin != null) {
			int t = 60*60*24*90; //90일
			Cookie cook = 
				new Cookie("loginCookie", session.getId());
			cook.setMaxAge( t );
			
			cook.setPath("/");
			
			response.addCookie( cook );
			
			ms.keepLogin(session.getId(), id);
		}
		return "member/successLogin";
	}
	@GetMapping("logout")
	public String logout(HttpSession session,
			@CookieValue(required = false) Cookie loginCookie,
			HttpServletResponse response) {
		if(loginCookie != null) {
			loginCookie.setMaxAge(0);
			loginCookie.setPath("/");
			response.addCookie(loginCookie);
			
			ms.keepLogin("nan", (String)session.getAttribute(LOGIN));
		}
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("memberInfo")
	public String memberInfo(Model model) {
		ms.memberInfo(model);
		return "member/memberInfo";
	}
	@GetMapping("info")
	public String info(@RequestParam String id,
							Model model) {
		ms.info(model, id);
		return "member/info";
	}
	
	@PostMapping("register")
	public String register(MemberDTO dto) {
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		System.out.println(dto.getAddr());
		
		String[] str = dto.getAddr().split(",");
		for(String s : str) {
			System.out.println(s);
		}
		int result = ms.register(dto);
		if(result == 1)
			return "redirect:login";
		return "redirect:register_form";
	}
	@GetMapping("delete")
	public String delete(@RequestParam String id, 
							HttpSession session) {
		ms.delete(id);
		session.invalidate();
		return "redirect:login";
	}
	@GetMapping("modify_form")
	public String modify_form(Model model,
					@RequestParam String id) {
		ms.info(model, id);
		return "member/modify_form";
	}
	@PostMapping("modify")
	public String modify(MemberDTO dto) {
		ms.modify(dto);
		return "redirect:info?id="+dto.getId();
	}
}
























