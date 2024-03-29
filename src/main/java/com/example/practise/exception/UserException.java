package com.example.practise.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserException extends Exception {

	private String message;

	private static final long serialVersionUID = 1L;

}
