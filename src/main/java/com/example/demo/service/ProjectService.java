package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProjectDetails;
import com.example.demo.entity.ProjectResponse;
import com.example.demo.entity.ResourceDetails;
import com.example.demo.entity.ResourceProject;
import com.example.demo.entity.TimeSheetDetails;
import com.example.demo.entity.Users;
import com.example.demo.repository.ProjectDetailsRepository;
import com.example.demo.repository.ResourceDetailsRepository;
import com.example.demo.repository.ResourceProjectRepository;
import com.example.demo.repository.TimeSheetDetailsRepository;


@Service
public class ProjectService {
	
	@Autowired
	ProjectDetails projectDetails;
	
	@Autowired
	ProjectDetailsRepository projectDetailsRepository;
	
	@Autowired
	ResourceProjectRepository resourceProjectRepository;
	
	@Autowired
	ResourceDetailsRepository resourceDetailsRepository;
	
	@Autowired
	ResourceDetails resourceDetails;
	
	@Autowired
	TimeSheetDetails timeSheetDetails;
	
	@Autowired
	TimeSheetDetailsRepository timeSheetDetailsRepository;
	
	 ArrayList<ResourceDetails> resourcelist = new ArrayList();
	 ArrayList<TimeSheetDetails> timesheetlist = new ArrayList();
	 ArrayList<TimeSheetDetails> timesheetleavelist = new ArrayList();
	
//	public List<TimeSheetDetails> response(String projectname,String startdate,String enddate)
//	{
//		ResourceDetails reslist = new ResourceDetails();
//		Optional<ProjectDetails> pro= projectDetailsRepository.findAll().stream().filter(x -> x.getProject_name().equals(projectname)).findAny();
//		String projectid = pro.get().getProject_id();
//		List<Integer> resproject= resourceProjectRepository.findAll().stream().filter(x -> x.getProject_id().equals(projectid)).map( x-> x.getResource_id()).toList();
//		for(Integer res:resproject)
//		{
//			Optional<ResourceDetails> resdetails = resourceDetailsRepository.findAll().stream().filter(x -> x.getResource_id() == res).findAny();
//			resourcelist.add(resdetails.get());
//		}
//		 timesheetleavelist.addAll(timeSheetDetailsRepository.findAll().stream().filter(x -> x.getPeriod_start().equals(startdate)).filter(x -> x.getProject_id().equals("IT-PROJ-00176") || x.getProject_id().equals("IT-PROJ-00178") || x.getProject_id().equals("II-PROJ-00386")).toList());
//		 for(ResourceProject res: resourcelist)
//		 {
//			 if(res.getResource_id()
//		 }
//	}
}
