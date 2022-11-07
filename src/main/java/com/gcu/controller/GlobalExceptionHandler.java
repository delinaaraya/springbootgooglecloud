package com.gcu.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	/*
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Error Page");
		model.addObject("error", "Error has occured. It states: " + e.getMessage());
		model.setViewName("exception");
		return model;
	}
	*/
	//Global exception handler that will catch any exception and redirect the user to a general error page.
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		return "error";
	}
}
