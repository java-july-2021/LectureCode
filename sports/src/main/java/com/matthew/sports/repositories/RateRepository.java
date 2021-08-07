package com.matthew.sports.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.sports.models.Rate;

@Repository
public interface RateRepository extends CrudRepository<Rate, Long> {

}
