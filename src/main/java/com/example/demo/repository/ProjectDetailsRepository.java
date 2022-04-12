package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ProjectDetails;

public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails, String> {

}
