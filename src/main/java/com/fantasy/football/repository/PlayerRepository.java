package com.fantasy.football.repository;

import com.fantasy.football.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PlayerRepository extends MongoRepository<Player, Integer> {
    Optional<Player> findByTeam_name(String team_name);
}
