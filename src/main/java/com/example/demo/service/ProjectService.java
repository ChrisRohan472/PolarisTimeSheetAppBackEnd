package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
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
	
	@Autowired
	ProjectResponse projectResponse;
	
	

	
		public List<ProjectResponse> response(String projectname,String startdate,String enddate)
		{
			ArrayList<ProjectResponse> projectresponselist = new ArrayList();
			 ArrayList<ResourceDetails> resourcelist = new ArrayList();
			 ArrayList<TimeSheetDetails> timesheetlist = new ArrayList();
			 ArrayList<TimeSheetDetails> timesheetleavelist = new ArrayList();
			Optional<ProjectDetails> pro= projectDetailsRepository.findAll().stream().filter(x -> x.getProject_name().equals(projectname)).findAny();
			String projectid = pro.get().getProject_id();
			timesheetlist.addAll(timeSheetDetailsRepository.findAll().stream().filter(x -> x.getPeriod_start().equals(startdate)).filter(x -> x.getProject_id().equals(projectid)).toList());
			timesheetlist.forEach(x->{timesheetleavelist.addAll(timeSheetDetailsRepository.findAll().stream().filter(x1 -> x1.getPeriod_start().equals(startdate)).filter(x2 -> x2.getProject_id().equals("IT-PROJ-00176") || x2.getProject_id().equals("IT-PROJ-00178") || x2.getProject_id().equals("II-PROJ-00386")).filter(y->y.getTimesheet_number().equals(x.getTimesheet_number())).toList());});
			 timesheetlist.addAll(timesheetleavelist);
			 timesheetlist.stream().filter(x->x.getApproval_status().equals("Awaiting Approval")).toList();
			 List<Integer> resourceid = timesheetlist.stream().map(y -> y.getResource_id()).toList();
//			 return resourceid;
//			 List<Integer> resproject= resourceProjectRepository.findAll().stream().filter(x -> x.getProject_id().equals(projectid)).map( x-> x.getResource_id()).toList();
			 for(Integer res:resourceid)
			 {
				 Optional<ResourceDetails> resdetails = resourceDetailsRepository.findAll().stream().filter(x -> x.getResource_id() == res).findAny();
				 resourcelist.add(resdetails.get());
			 }
//			 return resourcelist;
			 for(Integer res:resourceid)
			 {
				 if(timesheetleavelist.stream().filter(x -> x.getResource_id() == res).findAny().isEmpty())
				 {
					 projectresponselist.add(new ProjectResponse(resourcelist.stream().filter(x ->x.getResource_id() == res).findAny().get().getResource_name(), res, timesheetlist.stream().filter(x -> x.getResource_id() == res).findAny().get().getHours(),0 ) );
				 }
				 else
				 {
					 projectresponselist.add(new ProjectResponse(resourcelist.stream().filter(x ->x.getResource_id() == res).findAny().get().getResource_name(), res, timesheetlist.stream().filter(x -> x.getResource_id() == res).findAny().get().getHours(),timesheetleavelist.stream().filter(x -> x.getResource_id() == res).findAny().get().getHours() ) );
				 } 
			 }
			 return projectresponselist.stream().distinct().toList();
	}
	
}