package com.matthew.sports.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.sports.models.Rate;
import com.matthew.sports.repositories.RateRepository;

@Service
public class RateService {
	@Autowired
	private RateRepository rRepo;
	
	public Rate createRating(Rate rate) {
		return this.rRepo.save(rate);
	}
	
	
}
