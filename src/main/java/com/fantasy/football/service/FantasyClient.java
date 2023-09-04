package com.fantasy.football.service;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;


@HttpExchange
public interface FantasyClient {
    @GetExchange("/bootstrap-static/")
    String getAll();
}
