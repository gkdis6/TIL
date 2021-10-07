package com.example.sample.bean;

public class Member {

	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + "]";
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

}
