package com.care.root.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardRepDTO;

public interface BoardService {
	public void boardAllList(Model model, int num);
	public String writeSave(MultipartHttpServletRequest mul,
							HttpServletRequest request);
	public void contentView(int writeNo,Model model);
	public String modify(MultipartHttpServletRequest mul);
	public String delete(int writeNo, String imageFileName);
	
	public void addReply(BoardRepDTO dto);
	
	public List<BoardRepDTO> getRepList(int write_group);

}










