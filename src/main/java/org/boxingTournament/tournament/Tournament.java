package org.boxingTournament.tournament;

import org.boxingTournament.conference.Conference;
import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.judges.Judge;
import org.boxingTournament.match.Match;
import org.boxingTournament.match.StatisticsAndOutcomes;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Tournament {
    private Conference westConference;
    private Conference eastConference;
    private final List<Judge> judges;
    private final StatisticsAndOutcomes statisticsAndOutcomes;

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

    public void runTournament() throws Exception {
        Fighter winner = runConference(eastConference.getFighters());
        System.out.println(winner);
    }

    public Fighter runConference(List<Fighter> fighters) throws Exception {
        List<Fighter> nextRounder = new LinkedList<>();

        int low = 0;
        int high = fighters.size() - 1;

        while (low < high) {
            Fighter lowFighter = fighters.get(low);
            Fighter highFighter = fighters.get(high);

            Fighter winner = new Match(highFighter, lowFighter, this.judges, this.statisticsAndOutcomes).runMatch();
            nextRounder.add(winner);

            low += 1;
            high -= 1;
        }

        if (nextRounder.size() != 1) {
            Collections.shuffle(nextRounder); //shuffle order for more randomness
            return runConference(nextRounder);
        } else {
            return nextRounder.get(0);
        }
    }

    @Override
    public String toString() {
        return "Tournament{" + "aSide=" + westConference + ", bSide=" + eastConference + '}';
    }
}
