package com.example.demo.entity;

import java.util.Objects;

public class ProjectResponse {

	private String name;
	private int SAPID;
	private float Projhrs;
	private float leavehrs;
	
	
	public ProjectResponse() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(SAPID);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectResponse other = (ProjectResponse) obj;
		return SAPID == other.SAPID;
	}
	
	public ProjectResponse(String name, int SAPID, float Projhrs, float leavehrs) {
		super();
		this.name = name;
		this.SAPID = SAPID;
		this.Projhrs = Projhrs;
		this.leavehrs = leavehrs;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSAPID() {
		return SAPID;
	}
	public void setSAPID(int SAPID) {
		this.SAPID = SAPID;
	}
	public float getProjhrs() {
		return Projhrs;
	}
	public void setProjhrs(float Projhrs) {
		this.Projhrs = Projhrs;
	}
	public float getleavehrs() {
		return leavehrs;
	}
	public void setleavehrs(float leavehrs) {
		this.leavehrs = leavehrs;
	}
	
}
