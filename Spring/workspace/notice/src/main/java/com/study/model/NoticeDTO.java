package com.study.model;
import java.util.Objects;

import lombok.Data;
@Data
public class NoticeDTO {
  private int    noticeno     ;
  private String title        ;
  private String content      ;
  private String wname        ;
  private String passwd       ;
  private int    cnt          ;
  private String rdate        ;
public int getNoticeno() {
	return noticeno;
}
public void setNoticeno(int noticeno) {
	this.noticeno = noticeno;
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
public String getWname() {
	return wname;
}
public void setWname(String wname) {
	this.wname = wname;
}
public String getPasswd() {
	return passwd;
}
public void setPasswd(String passwd) {
	this.passwd = passwd;
}
public int getCnt() {
	return cnt;
}
public void setCnt(int cnt) {
	this.cnt = cnt;
}
public String getRdate() {
	return rdate;
}
public void setRdate(String rdate) {
	this.rdate = rdate;
}
@Override
public String toString() {
	return "NoticeDTO [noticeno=" + noticeno + ", title=" + title + ", content=" + content + ", wname=" + wname
			+ ", passwd=" + passwd + ", cnt=" + cnt + ", rdate=" + rdate + "]";
}
@Override
public int hashCode() {
	return Objects.hash(cnt, content, noticeno, passwd, rdate, title, wname);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	NoticeDTO other = (NoticeDTO) obj;
	return cnt == other.cnt && Objects.equals(content, other.content) && noticeno == other.noticeno
			&& Objects.equals(passwd, other.passwd) && Objects.equals(rdate, other.rdate)
			&& Objects.equals(title, other.title) && Objects.equals(wname, other.wname);
}
public NoticeDTO(int noticeno, String title, String content, String wname, String passwd, int cnt, String rdate) {
	super();
	this.noticeno = noticeno;
	this.title = title;
	this.content = content;
	this.wname = wname;
	this.passwd = passwd;
	this.cnt = cnt;
	this.rdate = rdate;
}
public NoticeDTO() {
	super();
	// TODO Auto-generated constructor stub
}
 
}
