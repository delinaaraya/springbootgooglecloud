package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/register/")
public class RegistrationController
{
	@GetMapping("")
	public String display(Model model)
	{
		model.addAttribute("title", "Registration Form");
		//UserModel registering = new UserModel();
		model.addAttribute("userModel", new UserModel());
		return "register";
	}
	
	@PostMapping("/doRegister")
	public String doRegister(@Valid UserModel userModel, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Registration Form");
			return "register";
		}
		System.out.println(String.format("Form with Username of %s and Password of %s and First Name of %s and Last Name of %s and"
				+ " Email of %s and Phone Number of %d", userModel.getUsername(), 
				userModel.getPassword(), userModel.getFname(), userModel.getLname(), userModel.getEmail(),
				userModel.getPhone()));
		return "products";
	}
}