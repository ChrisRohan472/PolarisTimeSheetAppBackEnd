package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProjectDetails;
import com.example.demo.entity.ProjectRequest;
import com.example.demo.entity.ProjectResponse;
import com.example.demo.entity.ResourceDetails;
import com.example.demo.entity.ResourceProject;
import com.example.demo.entity.TimeSheetDetails;
import com.example.demo.entity.UserAdmin;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserAdminRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenUtil;
import com.example.demo.service.ProjectService;
import com.example.demo.service.UserAdminService;
import com.example.demo.service.UserService;


@CrossOrigin 
@RestController
public class Mynewcontroller {

	@Autowired
	JwtTokenUtil jtw;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserAdminService userAdminService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserAdminRepository userAdminRep;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	ProjectDetails projectDetails;
	
	@Autowired
	ProjectRequest projectRequest;

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
	
	@GetMapping("/requestRole")
	public String requestRole(HttpServletRequest request)
	{
		String str=request.getHeader("Authorization");
		String s=jtw.getUsernameFromToken(str.substring(7));
		return userRepository.findAll().stream().filter(x->x.getUserid().equals(s)).findAny().get().getRole();
		
	}
	@GetMapping("/requestUserId")
	public String requestUser(HttpServletRequest request)
	{
		String str=request.getHeader("Authorization");
		String s=jtw.getUsernameFromToken(str.substring(7));
return s;		
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
	
	
//	@GetMapping("/GetProjectDetails")
//	public List<TimeSheetDetails> getProjectDetails(@RequestBody ProjectRequest pr)
//	{
//		return projectService.response(pr.getProjectname(), pr.getStartdate(), pr.getEnddate());
//	}

	
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