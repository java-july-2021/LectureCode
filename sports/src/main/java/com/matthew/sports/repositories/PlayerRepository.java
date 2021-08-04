package com.matthew.sports.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.sports.models.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long>{

}
