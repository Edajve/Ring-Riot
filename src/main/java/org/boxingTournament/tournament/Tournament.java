package org.boxingTournament.tournament;

import org.boxingTournament.conference.Conference;
import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.judges.Judge;
import org.boxingTournament.match.Match;
import org.boxingTournament.match.StatisticsAndOutcomes;

import java.util.List;

public class Tournament {
    private Conference westConference;
    private Conference eastConference;
    private List<Judge> judges;
    private StatisticsAndOutcomes statisticsAndOutcomes;

    public Tournament(
            Conference westConference,
            Conference eastConference,
            List<Judge> judges,
            StatisticsAndOutcomes statisticsAndOutcomes
    ) {
        this.westConference = westConference;
        this.eastConference = eastConference;
        this.judges = judges;
        this.statisticsAndOutcomes = statisticsAndOutcomes;
    }

    public Conference getWestConference() {
        return westConference;
    }

    public void setWestConference(Conference westConference) {
        this.westConference = westConference;
    }

    public Conference getEastConference() {
        return eastConference;
    }

    public void setEastConference(Conference eastConference) {
        this.eastConference = eastConference;
    }

    public Fighter runTournament() {
        new Match(westConference.getFighters().get(0), eastConference.getFighters().get(0), judges, statisticsAndOutcomes).runMatchSimulationAndReturnWinner();
        return new Fighter("Test", 0, "00");
    }

    @Override
    public String toString() {
        return "Tournament{" + "aSide=" + westConference + ", bSide=" + eastConference + '}';
    }
}
