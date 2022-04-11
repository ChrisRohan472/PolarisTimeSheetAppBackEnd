package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class UserAdmin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@SequenceGenerator(name="ua_seq",initialValue=1001,allocationSize=1)
	private int id;
	private String userid;
	private String name;
	private String activeFrom;
	private String role;
	private String status ;
	public UserAdmin()
	{
		
	}
	public UserAdmin( String userid, String name, String activeFrom, String role, String status) {
		super();
		
		this.userid = userid;
		this.name = name;
		this.activeFrom = activeFrom;
		this.role = role;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getActiveFrom() {
		return activeFrom;
	}
	public void setActiveFrom(String activeFrom) {
		this.activeFrom = activeFrom;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
