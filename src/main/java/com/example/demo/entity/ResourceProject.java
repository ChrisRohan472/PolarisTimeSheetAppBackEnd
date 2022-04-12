package com.example.demo.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ResourceProject {
	@Id
	private int id;
	private int resource_id;
	private String project_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getResource_id() {
		return resource_id;
	}
	public void setResource_id(int resource_id) {
		this.resource_id = resource_id;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public ResourceProject() {
		super();
	}
	

}
