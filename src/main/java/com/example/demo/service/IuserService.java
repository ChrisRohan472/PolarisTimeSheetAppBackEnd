package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;


@Service
public interface IuserService {
	
	Users FindByUserId(String userid);

}
