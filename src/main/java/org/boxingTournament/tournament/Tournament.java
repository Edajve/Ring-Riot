package org.boxingTournament.tournament;

import org.boxingTournament.conference.Conference;
import org.boxingTournament.fighter.Fighter;

public class Tournament {
    private Conference aSide;
    private Conference bSide;

    /**
     * @param aSide - needs a 'a' side conference in order to start a tournament
     * @param bSide - needs a 'b' side conference in order to start a tournament
     */
    public Tournament(Conference aSide, Conference bSide) {
        this.aSide = aSide;
        this.bSide = bSide;
    }

    public Conference getaSide() {
        return aSide;
    }

    public void setaSide(Conference aSide) {
        this.aSide = aSide;
    }

    public Conference getbSide() {
        return bSide;
    }

    public void setbSide(Conference bSide) {
        this.bSide = bSide;
    }

    /**
     * TODO finish the method
     * create method that run tournament simulator on a single conference and returns a single fighter that won
     *
     * @param conference
     * @return single fighter who won the tournament
     */
    public Fighter runTournamentOnConference(Conference conference) {
        return new Fighter("Test", 0, "00");
    }

    @Override
    public String toString() {
        return "Tournament{" + "aSide=" + aSide + ", bSide=" + bSide + '}';
    }
}
