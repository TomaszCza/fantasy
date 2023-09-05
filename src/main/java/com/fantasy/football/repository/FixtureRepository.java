package com.fantasy.football.repository;

import com.fantasy.football.domain.Fixture;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FixtureRepository extends MongoRepository<Fixture, Integer> {

}
