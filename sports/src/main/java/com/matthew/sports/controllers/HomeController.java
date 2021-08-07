package com.matthew.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
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
import com.matthew.sports.models.Rate;
import com.matthew.sports.models.Team;
import com.matthew.sports.models.User;
import com.matthew.sports.services.PlayerService;
import com.matthew.sports.services.RateService;
import com.matthew.sports.services.TeamService;
import com.matthew.sports.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private TeamService tService;
	@Autowired
	private PlayerService pService;
	@Autowired
	private UserService uService;
	@Autowired
	private RateService rService;
	
	public void sessionSettings(HttpSession session) {
		session.setMaxInactiveInterval(-1);
	}
	
	@GetMapping("/")
	public String login(Model viewModel, HttpSession session) {
		sessionSettings(session);
		viewModel.addAttribute("users", this.uService.getAllUsers());
		return "landing.jsp";
	}
	
	@PostMapping("/login")
	public String loggingIn(@RequestParam("userToLogIn") Long userId, HttpSession session) {
		session.setAttribute("user___id", userId);
		System.out.println(session.getMaxInactiveInterval());
		System.out.println(session.getAttribute("butt"));
		return "redirect:/dashboard";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redirectAttr) {
		redirectAttr.addFlashAttribute("message", "You have been successfully logged out!");
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/dashboard")
	public String index(Model viewModel, HttpSession session, RedirectAttributes redirectAttr) {
		if(session.getAttribute("user___id") == null) {
			redirectAttr.addFlashAttribute("message", "You're not slick.... Login");
			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user___id");
		List<Team> allTheTeams = this.tService.getAll();
		viewModel.addAttribute("allTeams", allTheTeams);
		viewModel.addAttribute("user", this.uService.getOneUser(userId));
		return "index.jsp";
	}
	
	@GetMapping("/like/{id}")
	public String likeTeam(HttpSession session, @PathVariable("id") Long teamId) {
		Long userId = (Long)session.getAttribute("user___id");
		User userToLike = this.uService.getOneUser(userId);
		Team teamToLike = this.tService.getOne(teamId);
		this.tService.likeTeam(teamToLike, userToLike);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/unlike/{id}")
	public String unlikeTeam(HttpSession session, @PathVariable("id") Long teamId) {
		Long userId = (Long)session.getAttribute("user___id");
		User userToLike = this.uService.getOneUser(userId);
		Team teamToLike = this.tService.getOne(teamId);
		this.tService.unlikeTeam(teamToLike, userToLike);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/rate/{id}")
	public String rateTeam(HttpSession session, @PathVariable("id") Long teamId, @RequestParam("rating") Double rating) {
		Long userId = (Long)session.getAttribute("user___id");
		User userToRate = this.uService.getOneUser(userId);
		Team teamToRate = this.tService.getOne(teamId);
		Rate newRating = new Rate(rating, teamToRate, userToRate);
		this.rService.createRating(newRating);
		return "redirect:/{id}";
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
	public String displayTeams(@ModelAttribute("rate") Rate rate, @PathVariable("id") Long id, Model viewModel, HttpSession session) {
		Team teamToDisplay = this.tService.getOne(id);
		viewModel.addAttribute("team", teamToDisplay);
		viewModel.addAttribute("user", this.uService.getOneUser((Long)session.getAttribute("user___id")));
		return "show.jsp";
	}
	
	@PostMapping("/rate")
	public String rateTeam(@Valid @ModelAttribute("rate") Rate rate, BindingResult result) {
		if(result.hasErrors()) {
			return "show.jsp";
		}
		this.rService.createRating(rate);
		return "redirect:/dashboard";
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
