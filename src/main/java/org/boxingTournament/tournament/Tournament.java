package org.boxingTournament.tournament;

import org.boxingTournament.conference.Conference;
import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.judges.Judge;
import org.boxingTournament.match.Match;

import java.util.Set;
import java.util.jar.JarEntry;

public class Tournament {
    private Conference aSide;
    private Conference bSide;
    private Set<Judge> judges;

    /**
     * @param aSide - needs a 'a' side conference in order to start a tournament
     * @param bSide - needs a 'b' side conference in order to start a tournament
     */
    public Tournament(Conference aSide, Conference bSide, Set<Judge> judges) {
        this.aSide = aSide;
        this.bSide = bSide;
        this.judges = judges;
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
     * @return single fighter who won the tournament
     */
    public Fighter runTournament() {
        Match match = new Match(aSide.getFighters().get(0), bSide.getFighters().get(0), judges);
        match.runMatchSimuation();
        return new Fighter("Test", 0, "00");
    }

    @Override
    public String toString() {
        return "Tournament{" + "aSide=" + aSide + ", bSide=" + bSide + '}';
    }
}
