package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository usersrep;
	
	@Autowired
	Users user;
	
	public String Auth(String userid, String password)
	{
		Optional<Users> u=usersrep.findAll().stream().filter(x->x.getUserid().equals(userid)).findAny();
		if(u.isPresent())
		{Users us=u.get();
			if(us.getPassword().equals(password))
			return "Logged In As "+us.getRole();
			else
				return "Invalid Password";
		}
		else
			return "Invalid Username";
		
	}

	public void create(String userid,String password, String Role)
	{
		user.setUserid(userid);
		user.setPassword(password);
		user.setRole(Role);
		usersrep.save(user);
		
	}
	
	public List<Users> getAll()
	{
		return usersrep.findAll();
	}

	public Optional<Users> findById(int id){
		return usersrep.findById(id);
	}
	
	public List<Users> findByuserId(String userid){
		 return usersrep.findAll().stream().filter(o -> o.getUserid().equals(userid)).toList();
		
	}

	
	
}