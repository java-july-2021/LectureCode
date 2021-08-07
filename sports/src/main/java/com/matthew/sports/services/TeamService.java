package com.matthew.sports.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matthew.sports.models.Team;
import com.matthew.sports.models.User;
import com.matthew.sports.repositories.TeamRepository;

@Service
public class TeamService {
	
	private TeamRepository tRepo;
	public TeamService(TeamRepository repo) {
		this.tRepo = repo;
	}
	
	public List<Team> getAll() {
		return this.tRepo.findAll();
	}
	// create a team
	public Team create(Team team) {
		return this.tRepo.save(team);
	}
	// delete a team
	public void deleteById(Long id) {
		this.tRepo.deleteById(id);
	}
	// update a team
	public Team update(Team team) {
		return this.tRepo.save(team);
	}
	// get one team (by id)
	public Team getOne(Long id) {
		// if no teams are found with provided id, return null
		return this.tRepo.findById(id).orElse(null);
	}
	
	public void likeTeam(Team team, User user) {
		List<User> usersWhoLiked = team.getLikers();
		usersWhoLiked.add(user);
		this.tRepo.save(team);
	}
	
	public void unlikeTeam(Team team, User user) {
		List<User> usersWhoLiked = team.getLikers();
		usersWhoLiked.remove(user);
		this.tRepo.save(team);
	}
}
