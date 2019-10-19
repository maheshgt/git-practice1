package com.example.practise.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practise.dto.EmpDto;
import com.example.practise.dto.EmpRDto;
import com.example.practise.entity.Employee;
import com.example.practise.exception.UserException;
import com.example.practise.repository.EmpRepo;

/**
 * 
 * @author mahesh
 *
 */
@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	EmpRepo empRepo;
	
	@Override
	public EmpRDto addEmp(EmpDto empDto) throws UserException {
		
		Employee employee = new Employee();
		BeanUtils.copyProperties(empDto, employee);
		Employee emp  = empRepo.save(employee);
		if(emp.getUserName().equals(""))
			throw new UserException("Plz try again");
		EmpRDto empRDto = new EmpRDto();
		BeanUtils.copyProperties(emp, empRDto);
		return empRDto;
	}

	@Override
	public EmpRDto getEmp(int id) throws UserException {
		EmpRDto empRDto1 = new EmpRDto();
		Optional<Employee> emp = empRepo.findById(id);
		if(emp.isPresent()) {
		BeanUtils.copyProperties(emp.get(), empRDto1);
		}
		else {
			throw new UserException("Invalid User");
		}
		return empRDto1;
	}

	@Override
	public EmpRDto updateEmp(Integer id, String userCity, Integer userPh) throws UserException {
		EmpRDto empRDto1 = new EmpRDto();
		Optional<Employee> emp = empRepo.findById(id);
		if(emp.isPresent()) {
			emp.get().setUserCity(userCity);
			emp.get().setUserPh(userPh);
			Employee emp1  = empRepo.save(emp.get());
			if(emp1.getUserName().equals(""))
				throw new UserException("Plz try again");
			BeanUtils.copyProperties(emp1, empRDto1);
		}
		else {
			throw new UserException("invalid user");
		}
		return empRDto1;
	}

	@Override
	public String deleteEmp(int id) throws UserException {
		if(id==0) {
			throw new UserException();
		}
	 empRepo.deleteById(id);
		return "deleted successfully";
	}

}
