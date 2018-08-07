package com.onegroup.dto;

import java.sql.Timestamp;

public class NoteVO {
	private int notenum;
	private String toid;
	private String userid;
	private String title;
	private String content;
	private Timestamp notedate;
	
	public NoteVO() {
		super();
	}
	
	public NoteVO(int notenum, String toid, String userid, String title, String content, Timestamp notedate) {
		super();
		this.notenum = notenum;
		this.toid = toid;
		this.userid = userid;
		this.title = title;
		this.content = content;
		this.notedate = notedate;
	}
	
	public int getNotenum() {
		return notenum;
	}
	public void setNotenum(int notenum) {
		this.notenum = notenum;
	}
	public String getToid() {
		return toid;
	}
	public void setToid(String toid) {
		this.toid = toid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getNotedate() {
		return notedate;
	}
	public void setNotedate(Timestamp notedate) {
		this.notedate = notedate;
	}
	@Override
	public String toString() {
		return "NoteVO [notenum=" + notenum + ", toid=" + toid + ", userid=" + userid + ", title=" + title
				+ ", content=" + content + ", notedate=" + notedate + "]";
	}
}
