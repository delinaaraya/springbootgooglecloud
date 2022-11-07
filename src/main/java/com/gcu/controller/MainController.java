package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController
{
	//Displays the home view.
	@GetMapping("")
	public String display(Model model) throws Exception
	{
		model.addAttribute("title", "Home Page");
		return "home";
	}
}