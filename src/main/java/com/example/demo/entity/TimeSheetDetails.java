package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
//import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="time_sheet")
public class TimeSheetDetails {
	@Id
	private int time_id;
	private int resource_id;
	private String timesheet_number;
	private String period_start;
	private String period_end;
	private float hours; 
	private String approval_status;
	private String project_id;
	
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public int getResource_id() {
		return resource_id;
	}
	public void setResource_id(int resource_id) {
		this.resource_id = resource_id;
	}
	public String getTimesheet_number() {
		return timesheet_number;
	}
	public void setTimesheet_number(String timesheet_number) {
		this.timesheet_number = timesheet_number;
	}
	public String getPeriod_start() {
		return period_start;
	}
	public void setPeriod_start(String period_start) {
		this.period_start = period_start;
	}
	public String getPeriod_end() {
		return period_end;
	}
	public void setPeriod_end(String period_end) {
		this.period_end = period_end;
	}
	public float getHours() {
		return hours;
	}
	public void setHours(float hours) {
		this.hours = hours;
	}
	public String getApproval_status() {
		return approval_status;
	}
	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}
	

}
