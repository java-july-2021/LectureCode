package com.matthew.sports.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.sports.models.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long>{
	List<Team> findAll(); // SELECT * FROM teams;
}
