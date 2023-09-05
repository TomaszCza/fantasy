package com.fantasy.football.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Fixtures")
public class Fixture {

    @Id
    int clubId;

    String club;
    List<Integer> fixtures;
}
