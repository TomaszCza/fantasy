package com.fantasy.football.repository;

import com.fantasy.football.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, Integer> {
}
