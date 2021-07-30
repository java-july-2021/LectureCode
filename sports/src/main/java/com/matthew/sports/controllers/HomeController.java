package com.matthew.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.sports.models.Team;
import com.matthew.sports.services.TeamService;

@Controller
public class HomeController {
	@Autowired
	private TeamService tService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		List<Team> allTheTeams = this.tService.getAll();
		viewModel.addAttribute("allTeams", allTheTeams);
		return "index.jsp";
	}
	
	@GetMapping("/new")
	public String newTeam(@ModelAttribute("team") Team team) {
		return "new.jsp";
	}
	
	@PostMapping("/addTeam")
	public String addTeam(@Valid @ModelAttribute("team") Team team, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		this.tService.create(team);
		return "redirect:/";
	}
	

	@PostMapping("/newTeamHTML")
	public String addTeamHTML(@RequestParam("teamName") String teamName, @RequestParam("city") String city, @RequestParam("sport") String sport, @RequestParam("budget") Double budget, @RequestParam("isActive") Boolean active, RedirectAttributes redirectAttr) {
		ArrayList<String> errors = new ArrayList<String>();
		if(teamName.equals("")) {
			errors.add("Hey you, you forgot to add a name!");
		}
		if(errors.size() > 0) {
			for(String e : errors) {
				redirectAttr.addFlashAttribute("error", e);
			}
			return "redirect:/new";
		}
		
		Team newTeam = new Team(teamName, city, sport, budget, active);
		this.tService.create(newTeam);
		return "redirect:/";
		
	}
}
