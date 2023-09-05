package com.fantasy.football.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Players")
public class Player {

    int team;

    @Id
    int id;

    String first_name;
    String second_name;
    int goals_scored;
    int total_points;
    String photo;
    String team_name;
}
