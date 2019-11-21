package com.serjer.freeter.controller;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ControllerUtils {
	  static Map<String, String> getErrors(BindingResult bindingResult) {
	        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
	                fieldError -> fieldError.getField() + "Error",
	                FieldError::getDefaultMessage
	        );
	        return bindingResult.getFieldErrors().stream().collect(collector);
	    }
}
