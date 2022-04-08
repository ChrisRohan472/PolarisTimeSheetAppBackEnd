package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.UserAdmin;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserAdminRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserAdminService;
import com.example.demo.service.UserService;


@CrossOrigin ("http://localhost:3000/")
@RestController
public class Mynewcontroller {
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserAdminService userAdminService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserAdminRepository userAdminRep;
	

	//Responsible for the Authenticate User In UserTable.
	@PostMapping("/auth")
	@ResponseBody
	public String auth(@RequestBody Users u)
	{
		return userService.Auth(u.getUserid(), u.getPassword());
	}
	
//	Function Responsible for the adding new Request to UserAdmin Table.
	@PostMapping("/AddUserAdminTable")
	public String Create(@RequestBody UserAdmin u)
	{
		userAdminService.add(u.getUserid(), u.getName(), u.getRole());	
		return "updated";
	}
	
		
// Responsible for Adding or Removing Access from User table.Confirm Button Maps to this Function
	@PostMapping("/UpdateUserAdmin")
	public String update(@RequestBody UserAdmin ua)
	{
		
		return userAdminService.update(ua.getUserid(),ua.getRole(),ua.getStatus());
		
	}
	
//	Returns all datas in the UserAdmin Table to the UserDashboard Page.
	@GetMapping("/requestUserAdmin")
	public List<UserAdmin> request()
	{
		return userAdminRep.findAllOrderByIdDesc();
	}

	
//	@GetMapping("/getall")
//	public List<Users> getall()
//	{
//		return us.getAll();
//	}
	
//	@GetMapping("/getbyid")
//	public Optional<Users> getbyid(@RequestParam int id)
//	{
//		return us.findById(id);
//	}

	

	

	
}