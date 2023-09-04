package com.fantasy.football.service;

import com.fantasy.football.domain.Player;
import com.fantasy.football.domain.TeamEnum;
import com.fantasy.football.repository.PlayerRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FantasySavingScheduledService {
    @Autowired
    private FantasyClient fantasyClient;

    @Autowired
    private PlayerRepository playerRepository;


    @GetMapping("/saveAllPlayers")
    public String saveAllPlayers() {
        Gson gson = new Gson();

        JSONObject allInfo = new JSONObject(fantasyClient.getAll());
        JSONArray allPlayers = allInfo.getJSONArray("elements");

        for (int i = 0; i < allPlayers.length(); i++) {
            String currentPlayerString = allPlayers.getJSONObject(i).toString();
            Player currentPlayer = gson.fromJson(currentPlayerString, Player.class);

            // Convert photo to an url with png
            String photoId = currentPlayer.getPhoto();
            photoId = photoId.substring(0, photoId.length() - 3) + "png";
            String photo = "https://resources.premierleague.com/premierleague/photos/players/250x250/p" + photoId;
            currentPlayer.setPhoto(photo);

            // Convert team id to team name
            int teamCode = currentPlayer.getTeam();
            currentPlayer.setTeam_name(TeamEnum.TEAMS_INDEXED[teamCode].toString().replace("_"," "));

            playerRepository.save(currentPlayer);
        }
        return "Saved all players :)";
    }
}
