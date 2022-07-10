package com.care.root.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired BoardMapper mapper;
	@Autowired BoardFileService bfs;
	
	public void boardAllList(Model model, int num) {
		int pageLetter = 3;
		int allCount = mapper.selectBoardCount();
		int repeat = allCount/ pageLetter;
		if(allCount % pageLetter != 0 )
			repeat += 1;
		int end = num * pageLetter;
		int start = end+1-pageLetter;
		model.addAttribute("repeat", repeat);
		
		model.addAttribute("boardList", 
						mapper.boardAllList(start, end));
	}
	public String writeSave(MultipartHttpServletRequest mul,
							HttpServletRequest request) {
		BoardDTO dto = new BoardDTO();
		dto.setTitle(mul.getParameter("title"));
		dto.setContent(mul.getParameter("content"));
		dto.setId(mul.getParameter("id"));
		
		MultipartFile file = mul.getFile("image_file_name");
		if(file.getSize() != 0) {
			dto.setImageFileName( bfs.saveFile(file) );
		}else {
			dto.setImageFileName("nan");
		}
		int result = 0;
		result = mapper.writeSave(dto);
		String msg, url;
		if(result == 1) {
			msg = "새글이 추가되었습니다";
			url = "/root/board/boardAllList";
		}else {
			msg = "문제 발생";
			url = "/root/board/writeForm";
		}
		return bfs.getMessage(msg, url);
	}
	private void upHit(int writeNo) {
		mapper.upHit(writeNo);
	}
	
	public void contentView(int writeNo,Model model) {
		
		upHit(writeNo);
		
		model.addAttribute("dto", 
						mapper.contentView(writeNo));
	}
	public String modify(MultipartHttpServletRequest mul) {
		BoardDTO dto = new BoardDTO();
		dto.setWriteNo( 
			Integer.parseInt(mul.getParameter("writeNo")) );
		dto.setTitle(mul.getParameter("title"));
		dto.setContent(mul.getParameter("content"));
		
		MultipartFile file = mul.getFile("imageFileName");
		if(file.getSize() != 0) {
			dto.setImageFileName(bfs.saveFile(file));
	bfs.deleteImage(mul.getParameter("originFileName"));
		}else {
			dto.setImageFileName(
					mul.getParameter("originFileName"));
		}
		int result = mapper.modify(dto);
		String msg, url;
		if(result == 1) {
			msg = "수정 성공!!!";
			url = "/root/board/boardAllList";
		}else {
			msg = "수정 실패!!!";
			url = "/root/board/modify_form";
		}
		return bfs.getMessage(msg, url);
	}
	public String delete(int writeNo, String imageFileName) {
		int result = mapper.delete(writeNo);
		String msg, url;
		if(result == 1) {
			bfs.deleteImage(imageFileName);
			msg = "삭제 성공";
			url="/root/board/boardAllList";
		}else {
			msg = "삭제 실패";
			url = "/root/board/contentView";
		}
		return bfs.getMessage(msg, url);
	}
	public void addReply(BoardRepDTO dto) {
		mapper.addReply(dto);
	}
	public List<BoardRepDTO> getRepList(int write_group){
		return mapper.getRepList(write_group);
	}
}










