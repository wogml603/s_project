package com.care.root.board.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class BoardFileServiceImpl 
							implements BoardFileService{
	public String getMessage(String msg, String url) {
		String message = null;
		message = "<script>alert('"+msg+"');";
		message += "location.href='"+url+"';</script>";
		return message;
	}
	public String saveFile(MultipartFile file) {
		SimpleDateFormat s = 
				new SimpleDateFormat("yyyyMMddHHmmss-");
		String sysFileName = s.format( new Date() );
		sysFileName += file.getOriginalFilename();
		File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
		try {
			file.transferTo( saveFile );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysFileName;
	}
	public void deleteImage(String n) {
		File d = new File(IMAGE_REPO+"/"+n);
		d.delete();
	}
}







