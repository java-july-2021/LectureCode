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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.sports.models.Player;
import com.matthew.sports.models.Team;
import com.matthew.sports.services.PlayerService;
import com.matthew.sports.services.TeamService;

@Controller
public class HomeController {
	@Autowired
	private TeamService tService;
	@Autowired
	private PlayerService pService;
	
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
	
	@GetMapping("/{id}")
	public String displayTeams(@PathVariable("id") Long id, Model viewModel) {
		Team teamToDisplay = this.tService.getOne(id);
		viewModel.addAttribute("team", teamToDisplay);
		return "show.jsp";
	}
	
	@GetMapping("/player/new")
	public String newPlayer(Model viewModel, @ModelAttribute("player") Player player) {
		List<Team> allTeams = this.tService.getAll();
		viewModel.addAttribute("allTeams", allTeams);
		return "player/new.jsp";
	}
	
	@PostMapping("/newPlayer")
	public String addPlayer(@Valid @ModelAttribute("player") Player player, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			List<Team> allTeams = this.tService.getAll();
			viewModel.addAttribute("allTeams", allTeams);
		}
		this.pService.createPlayer(player);
		Long teamsId = player.getTeam().getId();
		return "redirect:/" + teamsId;
	}
	
	@GetMapping("/edit/{id}")
	public String editPlayer(@PathVariable("id") Long id, @ModelAttribute("team") Team team, Model viewModel) {
		viewModel.addAttribute("team", this.tService.getOne(id));
		return "edit.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String processEdit(@Valid @ModelAttribute("team") Team team, BindingResult result, Model viewModel, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			viewModel.addAttribute("team", this.tService.getOne(id));
			return "edit.jsp";
		}
		this.tService.update(team);
		return "redirect:/" + id;
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.tService.deleteById(id);
		return "redirect:/";
	}
}
