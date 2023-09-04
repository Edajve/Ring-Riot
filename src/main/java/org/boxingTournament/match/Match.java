package org.boxingTournament.match;

import org.boxingTournament.enums.MatchStatus;
import org.boxingTournament.fighter.Fighter;

import java.util.*;

public class Match {
    private final Map<Integer, int[][]> roundsAndScoreCards = new HashMap<>();
    private final Fighter fighterA;
    private final Fighter fighterB;
    private MatchStatus matchStatus;
    private final StatisticsAndOutcomes statisticsAndOutcomes;

    public Match(Fighter fighterA, Fighter fighterB, StatisticsAndOutcomes statisticsAndOutcomes) {
        this.fighterA = fighterA;
        this.fighterB = fighterB;
        this.statisticsAndOutcomes = statisticsAndOutcomes;
    }

    /**
     * TODO finish this method, you did the simulateRounds methods with populates the map
     * TODO now you just have to do the math and see who won the fight
     * @param fighterA
     * @param fighterB
     * @return- the id of the fighter who won
     */
    public UUID returnFightResults(Fighter fighterA, Fighter fighterB) {
        simulateRounds(); //this populates the maps values with all judges score-cards of rounds

        for (Map.Entry<Integer, int[][]> entry : roundsAndScoreCards.entrySet()) {
            //add up the judges score-card to get the winner
            System.out.println(entry.getKey());
            System.out.println(Arrays.deepToString(entry.getValue()));
        }

        //return winner's id of the fight
        return fighterB.getId();
    }

    private void simulateRounds() {
        int[][] scoreCards;

        for (int i = 1; i <= 12; i++) {
            scoreCards = new int[3][2];

            //for only the first judge
            scoreCards[0][0] = statisticsAndOutcomes.generateRandomInt(1001) >= 500 ? 10 : 9;
            scoreCards[0][1] = scoreCards[0][0] == 10 ? 9 : 10;

            //for only the second judge
            scoreCards[1][0] = statisticsAndOutcomes.generateRandomInt(1001) >= 500 ? 10 : 9;
            scoreCards[1][1] = scoreCards[1][0] == 10 ? 9 : 10;

            //for only the third judge
            scoreCards[2][0] = statisticsAndOutcomes.generateRandomInt(1001) >= 500 ? 10 : 9;
            scoreCards[2][1] = scoreCards[2][0] == 10 ? 9 : 10;

            this.roundsAndScoreCards.put(i, scoreCards);
        }
    }
}
