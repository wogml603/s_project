package com.care.root.mybatis;

import java.util.List;
import java.util.Map;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	public MemberDTO user_check(String id);
	public List<MemberDTO> memberInfo();
	public int register(MemberDTO dto);
	public void delete(String id);
	
	public void modify(MemberDTO dto);
	
	public void keepLogin(Map<String, Object> map );
	
	public MemberDTO getSessionId(String sessionId);
	public int idChk(String id);
}













