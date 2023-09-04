package org.boxingTournament.match;

import org.boxingTournament.boxing.Fighter;
import org.boxingTournament.enums.MatchStatus;
import org.boxingTournament.enums.Round;

public class Match {
    private Round round;
    private int[][][] judgesScoreCards;
    private Fighter fighterA;
    private Fighter fighterB;
    private Fighter winner;
    private Fighter loser;
    private MatchStatus matchStatus;

    public Match(Fighter fighterA, Fighter fighterB) {
        this.fighterA = fighterA;
        this.fighterB = fighterB;
    }
}
