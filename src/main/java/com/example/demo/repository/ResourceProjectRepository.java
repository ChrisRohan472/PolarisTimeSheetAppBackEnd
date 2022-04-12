package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ResourceProject;

public interface ResourceProjectRepository extends JpaRepository<ResourceProject,Integer> {

}
