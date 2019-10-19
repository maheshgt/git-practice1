package com.example.practise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmpDto {
	
	private String userName;
	private String userJob;
	private String userCity;
	private Integer userPh;

}
