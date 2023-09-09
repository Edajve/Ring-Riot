package org.boxingTournament.tournament;

import org.boxingTournament.conference.Conference;
import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.judges.Judge;
import org.boxingTournament.logging.ExportToTxt;
import org.boxingTournament.match.Match;
import org.boxingTournament.match.StatisticsAndOutcomes;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Tournament {
    private final Conference westConference;
    private final Conference eastConference;
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

    public void runTournament() throws Exception {
        ExportToTxt.logIntro();
        Fighter easternConferenceWinner = runConference(this.eastConference);
        Fighter westernConferenceWinner = runConference(this.westConference);
        Fighter ultimateChampion = new Match(
                easternConferenceWinner,
                westernConferenceWinner,
                this.judges,
                this.statisticsAndOutcomes).runMatch();

        System.out.println(ultimateChampion);
    }

    /**
     * This is the first overloaded method.
     * @param conference takes type Conference
     */
    public Fighter runConference(Conference conference) throws Exception {
        ExportToTxt.log("Run tournament in " + conference.toString());
        List<Fighter> startingFighters = conference.getConferenceFighters();
        List<Fighter> nextRounder = new LinkedList<>();

        int low = 0;
        int high = startingFighters.size() - 1;

        while (low < high) {
            Fighter lowFighter = startingFighters.get(low);
            Fighter highFighter = startingFighters.get(high);

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

    /**
     * This is the second overloaded method.
     * @param fighters takes type List<Fighter>
     */
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
