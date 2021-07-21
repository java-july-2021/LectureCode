package com.matthew.havingfun.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	private String index() {
		return "index.jsp";
	}
	
	
	@RequestMapping(value="/tellAJoke", method=RequestMethod.POST)
	private String processJoke(@RequestParam("name") String name, @RequestParam("joke") String joke, Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("joke", joke);
		return "showJoke.jsp";
	}
	
	@RequestMapping("/{color}")
	private String favColor(@PathVariable("color") String color, Model viewModel ) {
		viewModel.addAttribute("color", color);
		return "favcolor.jsp";
	}
}
