package com.fantasy.football.domain;

public enum TeamEnum {

    Arsenal(1), Aston_Villa(2), Bournemouth(3), Brentford(4), Brighton(5), Burnley(6),
    Chelsea(7), Crystal_Palace(8), Everton(9), Fulham(10), Liverpool(11), Luton(12),
    Man_City(13), Man_Utd(14), Newcastle(15), Nottingham_Forest(16), Sheffield_Utd(17),
    Spurs(18), West_Ham(19), Wolves(20);

    int teamNum = 0;

    TeamEnum(int ord) {
        this.teamNum = ord;
    }

    public static TeamEnum[] TEAMS_INDEXED = new TeamEnum[]{null, Arsenal, Aston_Villa, Bournemouth, Brentford,
            Brighton, Burnley, Chelsea, Crystal_Palace, Everton, Fulham, Liverpool, Luton, Man_City, Man_Utd, Newcastle,
            Nottingham_Forest, Sheffield_Utd, Spurs, West_Ham, Wolves};
}
