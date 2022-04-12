package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TimeSheetDetails;

public interface TimeSheetDetailsRepository extends JpaRepository<TimeSheetDetails, Integer> {

}
