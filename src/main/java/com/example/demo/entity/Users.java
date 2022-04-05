package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(generator="u_seq")
	@SequenceGenerator(name="u_seq",initialValue=1001,allocationSize=1)
	private int id;
	private String userid;
	private String password;
	private String role;
	
	public Users(String userid, String password, String role) {
		super();
		this.userid = userid;
		this.password = password;
		this.role = role;
	}
	public Users() {
		super();
		
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
