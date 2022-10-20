package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gcu.model.UserRegistrationModel;

@Controller
@RequestMapping("/register/")
public class RegistrationController
{
	//Displays the register view.
	@GetMapping("")
	public String display(Model model)
	{
		model.addAttribute("title", "Registration Form");
		//UserModel registering = new UserRegistrationModel();
		model.addAttribute("userRegistrationModel", new UserRegistrationModel());
		return "register";
	}
	
	//Post request to add user data to the database and redirect the user to the products page.
	@PostMapping("/doRegister")
	public String doRegister(@Valid UserRegistrationModel userRegistrationModel, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Registration Form");
			return "register";
		}
		System.out.println(String.format("Form with Username of %s and Password of %s and First Name of %s and Last Name of %s and"
				+ " Email of %s and Phone Number of %d", userRegistrationModel.getUsername(), 
				userRegistrationModel.getPassword(), userRegistrationModel.getFname(), 
				userRegistrationModel.getLname(), userRegistrationModel.getEmail(), 
				userRegistrationModel.getPhone()));
		return "products";
	}
}