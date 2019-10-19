package com.example.practise.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.practise.dto.EmpDto;
import com.example.practise.dto.EmpRDto;
import com.example.practise.exception.UserException;
import com.example.practise.service.EmpService;
import com.sun.istack.NotNull;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author mahesh
 *
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class EmplController {
	
	@Autowired
	EmpService empService;
	
	
	/**
	 * used to create employee
	 * @param empDto
	 * @return empDto
	 * @throws UserException 
	 */
	@PostMapping("/employee")
	public ResponseEntity<EmpRDto> addEmp(@Valid @NotNull @RequestBody EmpDto empDto) throws UserException{
		
		log.info("employee add method in clontroller class");
		return new ResponseEntity<>(empService.addEmp(empDto),HttpStatus.OK);
	}
	
	@GetMapping("/employee")
	public ResponseEntity<EmpRDto> getEmp(@NotNull @RequestParam int id) throws UserException{
		log.info("employee get method in clontroller class");
		return new ResponseEntity<>(empService.getEmp(id),HttpStatus.OK);
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<EmpRDto> updateEmp(@NotNull @PathVariable Integer id, @NotNull @RequestParam String userCity, @NotNull @RequestParam Integer userPh ) throws UserException{
		return new ResponseEntity<>(empService.updateEmp(id,userCity,userPh),HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmp(@NotNull @PathVariable int id) throws UserException{
		return new ResponseEntity<>(empService.deleteEmp(id),HttpStatus.OK);
	}

}
