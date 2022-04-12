package com.example.demo.entity;

public class ProjectRequest{
	
	private String projectname;
	private String startdate;
	private String enddate;
	
	public ProjectRequest() {
		super();
	}
	public ProjectRequest(String project, String startdate, String enddate) {
		super();
		this.projectname = project;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String project) {
		this.projectname = project;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


}