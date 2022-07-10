package com.care.root.notice.dto;

public class NoticeDTO {
	private int n_number,n_hit;
	private String n_title,n_saveDate;
	public int getN_number() {
		return n_number;
	}
	public void setN_number(int n_number) {
		this.n_number = n_number;
	}
	public int getN_hit() {
		return n_hit;
	}
	public void setN_hit(int n_hit) {
		this.n_hit = n_hit;
	}
	public String getN_title() {
		return n_title;
	}
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}
	public String getN_saveDate() {
		return n_saveDate;
	}
	public void setN_saveDate(String n_saveDate) {
		this.n_saveDate = n_saveDate;
	}

}
