package com.example.practise.service;

import org.springframework.stereotype.Service;

import com.example.practise.dto.EmpDto;
import com.example.practise.dto.EmpRDto;
import com.example.practise.exception.UserException;

@Service
public interface EmpService {

	EmpRDto addEmp(EmpDto empDto) throws UserException;

	EmpRDto getEmp(int id) throws UserException;

}
