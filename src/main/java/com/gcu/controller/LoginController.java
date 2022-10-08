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
@RequestMapping("/login/")
public class LoginController {
	
	@GetMapping("")
	public String display(Model model)
	{
		model.addAttribute("title", "Login");
		UserModel login = new UserModel();
		model.addAttribute("userModel", login);
		login.setFname("Test");
		login.setLname("Test");
		login.setEmail("Test");
		login.setPhone(1234567890);
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid UserModel userModel, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login");
			return "login";
		}
		System.out.println(String.format("Logged in as Username: %s \n Password: %s", userModel.getUsername(), userModel.getPassword()));
		return "products";
	}
}
