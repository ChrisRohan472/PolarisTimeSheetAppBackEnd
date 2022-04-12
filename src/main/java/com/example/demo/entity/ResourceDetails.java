package com.example.demo.entity;


import javax.persistence.*;



@Entity
public class ResourceDetails {
@Id
private int resource_id;
private String resource_name;

public ResourceDetails() {
	super();
}

private String customer_id;

public int getResource_id() {
	return resource_id;
}

public void setResource_id(int resource_id) {
	this.resource_id = resource_id;
}

public String getResource_name() {
	return resource_name;
}

public void setResource_name(String resource_name) {
	this.resource_name = resource_name;
}


public String getCustomer_id() {
	return customer_id;
}

public void setCustomer_id(String customer_id) {
	this.customer_id = customer_id;
}





}
