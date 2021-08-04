package com.matthew.sports.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.sports.models.Player;
import com.matthew.sports.repositories.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	private PlayerRepository pRepo;
	
	public Player createPlayer(Player player) {
		return this.pRepo.save(player);
	}
}
