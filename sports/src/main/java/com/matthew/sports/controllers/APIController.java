package com.matthew.sports.controllers;



import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matthew.sports.models.Team;
import com.matthew.sports.services.TeamService;

@RestController
@RequestMapping("/api")
public class APIController {
	
	private TeamService tService;
	public APIController(TeamService service) {
		this.tService = service;
	}
	
	// Get all teams
	@GetMapping("")
	public List<Team> index() {
		return this.tService.getAll();
	}
	
	@PostMapping("/create")
	public Team createTeam(Team team) {
		return this.tService.create(team);
	}
	
	// GET localhost:8080/2
	@GetMapping("/{id}")
	public Team getOneTeam(@PathVariable Long id) {
		return this.tService.getOne(id);
	}
	
	@DeleteMapping("/{id}/delete")
	// DELETE localhost:8080/2/delete
	public void delete(@PathVariable Long id) {
		this.tService.deleteById(id);
	}
	
	@PutMapping("/{id}/update")
	public Team update(@PathVariable Long id, Team team) {
		return this.tService.update(team);
	}
}
