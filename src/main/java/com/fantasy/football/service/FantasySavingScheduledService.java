package com.fantasy.football.service;

import com.fantasy.football.domain.Player;
import com.fantasy.football.domain.TeamEnum;
import com.fantasy.football.repository.PlayerRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Slf4j
@Service
@RestController
public class FantasySavingScheduledService {

    @Autowired
    private FantasyClient fantasyClient;

    @Autowired
    private PlayerRepository playerRepository;

    public void saveAllPlayers() {
        Gson gson = new Gson();

        JSONObject allInfo = new JSONObject(fantasyClient.getAllPlayers());
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
            currentPlayer.setTeam_name(TeamEnum.TEAMS_INDEXED[teamCode].toString().replace("_", " "));

            playerRepository.save(currentPlayer);
        }
        log.info("Saved all players :)");
    }


    @GetMapping("test")
    public ArrayList<ArrayList<Integer>> saveAllFixtures() {
        JSONArray allFixtures = new JSONArray(fantasyClient.getAllFixtures());
        ArrayList<ArrayList<Integer>> twoDimensionFixtureArray = new ArrayList<>();

        // Create initial 2d array and add 0 for each to make indexing easier
        for (int i = 0; i <= 20; i++) {
            twoDimensionFixtureArray.add(new ArrayList<>());
            twoDimensionFixtureArray.get(i).add(0);
        }

        for (int i = 0; i < allFixtures.length(); i++) {
            JSONObject currentFixture = allFixtures.getJSONObject(i);

            int awayTeam = (int) currentFixture.get("team_a");
            int homeTeam = (int) currentFixture.get("team_h");

            twoDimensionFixtureArray.get(awayTeam).add(homeTeam);
            twoDimensionFixtureArray.get(homeTeam).add(awayTeam);
        }

        return twoDimensionFixtureArray;
    }
}
