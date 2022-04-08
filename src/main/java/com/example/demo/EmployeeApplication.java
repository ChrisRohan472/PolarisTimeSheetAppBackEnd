package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.entity.UserAdmin;
import com.example.demo.entity.Users;

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

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
