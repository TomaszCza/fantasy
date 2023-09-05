package com.fantasy.football.service;

import com.fantasy.football.domain.Player;
import com.fantasy.football.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FantasyPlayerService {

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

    @GetMapping("/team/{team_name}/players")
    public List<Player> getAllPlayersForTeam(@PathVariable String team_name) {
        return playerRepository.findByTeam_name(team_name);
    }

    @GetMapping("/team/{Team}/players")
    public List<Player> getAllPlayersForTeamID(@PathVariable Integer Team) {
        return playerRepository.findByTeam(Team);
    }
}
