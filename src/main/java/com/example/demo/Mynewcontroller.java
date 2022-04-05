package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;



@RestController
public class Mynewcontroller {
	
	@Autowired
	UserService us;
	
	@Autowired 
	Users emp;
	
	@Autowired
	UserRepository ur;
	
	@PostMapping("/create")
	@ResponseBody
	public String create(@RequestBody Users u)
	{
		us.create(u.getUserid(), u.getPassword(), u.getRole());
		return "Account Created" + u.getUserid()+ " "+  u.getPassword();
	}
	
	@GetMapping("/auth")
	public String auth(@RequestBody Users u)
	{
		return us.Auth(u.getUserid(), u.getPassword());
	}
	
	@GetMapping("/getall")
	public List<Users> getall()
	{
		return us.getAll();
	}
	
	@GetMapping("/getbyid")
	public Optional<Users> getbyid(@RequestParam int id)
	{
		return us.findById(id);
	}
	
	@GetMapping("/getbyuserid")
	public List<Users> getbyuserid(@RequestParam String userid)
	{
		return us.findByuserId(userid);
	} 
	
}