package com.fantasy.football.controller;

import com.fantasy.football.domain.Player;
import com.fantasy.football.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class FantasyController {

    @Autowired
    private PlayerRepository playerRepository;

    @CrossOrigin
    @GetMapping("players")
    List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("player/{playerId}")
    Optional<Player> getPlayer(@PathVariable int playerId) {
        return playerRepository.findById(playerId);
    }

}
