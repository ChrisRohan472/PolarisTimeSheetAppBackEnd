package com.example.demo.service;

import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAdmin;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserAdminRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserAdminService implements IuserAdminService {
	
	@Autowired
	UserAdminRepository adminRep;
	
	@Autowired
	UserAdmin userAdmin;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRep;
	

	public void add(String userid, String name, String Role)
	{
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MMM-yyyy");
		Date d=new Date();
		UserAdmin u1 = new UserAdmin();
		u1.setUserid(userid);
		u1.setName(name);
		u1.setRole(Role);
		u1.setActiveFrom(sdf.format(d));
		u1.setStatus("Requested");  
		adminRep.save(u1);
	}
	
	public String update(String userid, String role, String status)
	{
		Optional<UserAdmin> u=adminRep.findAll().stream().filter(x->x.getUserid().equals(userid)).findAny();
		UserAdmin us2= new UserAdmin();
		us2=u.get();
		us2.setRole(role);
		us2.setStatus(status);
		adminRep.save(us2);
		
		Optional<Users> user = userRep.findAll().stream().filter(x->x.getUserid().equals(userid)).findAny();
		if(status.equals("Active"))
		{

			if(user.isPresent())
			{
				Users updaterole = new Users();
				updaterole = user.get();
//				us2.setRole(role);
//				adminRep.save(us2);
				updaterole.setRole(role);
				userRep.save(updaterole);
				return "UserAccessGranted";
			}
			else
			{
				userService.create(us2.getUserid(), null, us2.getRole());
				return "UserAccessGranted";
			}

		}
		else if((status.equals("Requested")) || (status.equals("Inactive")))
		{
			if(user.isPresent())
			{
				Users us1=user.get();
				userService.delete(us1);
				return "UserAccessRemoved";
			}
			else
			{
				return "Access Already Denied";
			}
		}
		return "UserUpdated";
	}

	@Override
	public List<UserAdmin> findAllOrderByIdDesc() {
		return adminRep.findAllOrderByIdDesc();

	}

}
