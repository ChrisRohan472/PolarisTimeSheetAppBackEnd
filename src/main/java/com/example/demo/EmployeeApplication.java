package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.entity.ProjectDetails;
import com.example.demo.entity.ProjectRequest;
import com.example.demo.entity.ResourceDetails;
import com.example.demo.entity.ResourceProject;
import com.example.demo.entity.TimeSheetDetails;
import com.example.demo.entity.UserAdmin;
import com.example.demo.entity.Users;
import com.example.demo.repository.TimeSheetDetailsRepository;

@ComponentScan({"com.example.demo","com.example.demo.entity","com.example.demo.repository","com.example.demo.service"})
@SpringBootApplication
public class EmployeeApplication {
	
	@Bean
	public Users user()
	{
		return new Users();
	}
	
	@Bean
	public UserAdmin userAdmin()
	{
		return new UserAdmin();
	}
	
	@Bean
	public ProjectDetails projectDetails()
	{
		return new ProjectDetails();
	}
	
	@Bean
	public ProjectRequest projectRequest()
	{
		return new ProjectRequest();
	}
	
	@Bean
	public ResourceProject resourceProject()
	{
		return new ResourceProject();
	}
	
	@Bean
	public ResourceDetails resourceDetails()
	{
		return new ResourceDetails();
	}
	
	@Bean
	public TimeSheetDetails timeSheetDetails()
	{
		return new TimeSheetDetails();
	}
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
