package com.fantasy.football.repository;

import com.fantasy.football.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends MongoRepository<Player, Integer> {
    List<Player> findByTeam_name(String team_name);
    List<Player> findByTeam(Integer Team);
}
