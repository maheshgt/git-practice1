package com.example.practise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practise.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer>{
	
}
