package com.fantasy.football.scheduler;

import com.fantasy.football.service.FantasySavingScheduledService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FantasySavingServiceScheduler {

    @Autowired
    private FantasySavingScheduledService fantasySavingScheduledService;

    @Scheduled(fixedDelayString = "${fantasy.service.schedule.interval.saveAllPlayers:600000}", initialDelay = 3000)
    public void scheduleSaveAllPlayers() {
        log.info("saveAllPlayers scheduled, now being run");
        fantasySavingScheduledService.saveAllPlayers();
    }

}
