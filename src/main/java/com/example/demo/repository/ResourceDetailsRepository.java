package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ResourceDetails;

public interface ResourceDetailsRepository extends JpaRepository<ResourceDetails, Integer> {

}
