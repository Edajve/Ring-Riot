package org.boxingTournament.match;

import org.boxingTournament.enums.MatchStatus;
import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.judges.Judge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Match {
    private static final int ROUNDS_PER_BOUT = 12;
    private Map<Integer, int[][]> roundsAndScoreCards = new HashMap<>();
    private Fighter fighterA; //may not need
    private Fighter fighterB; //may not need
    private MatchStatus matchStatus; //may not need
    private List<Judge> judges;
    private StatisticsAndOutcomes outcomes;

    public Match(Fighter fighterA, Fighter fighterB, List<Judge> judges, StatisticsAndOutcomes outcomes) {
        this.fighterA = fighterA;
        this.fighterB = fighterB;
        this.judges = judges;
        this.outcomes = outcomes;
    }

    /**
     * In order to run a match, you have to enroll
     * both the fighters to each of the judges so
     * they can keep track of score-cards
     */
    public String runMatchSimulationAndReturnWinner() {
        for (Judge judge : judges) {
            judge.setFighterA(fighterA);
            judge.setFighterB(fighterB);

            judge.judgeRound(this.outcomes);
            judge.judgeRound(this.outcomes);

            System.out.printf(judge.getWinnerOfRounds().toString());
        }

//        System.out.printf(judges.get(0).getFighterA().getFullName());
//        System.out.printf("---------------------");
//        System.out.printf(judges.get(0).getFighterB().getFullName());

//            scoreCards = new int[3][2];
//
//
//            //for only the first judge
//            scoreCards[0][0] = statisticsAndOutcomes.generateRandomByte((byte) 127) >= 63 ? 10 : 9;
//            scoreCards[0][1] = scoreCards[0][0] == 10 ? 9 : 10;
//
//            //for only the second judge
//            scoreCards[1][0] = statisticsAndOutcomes.generateRandomByte((byte) 127) >= 63 ? 10 : 9;
//            scoreCards[1][1] = scoreCards[1][0] == 10 ? 9 : 10;
//
//            //for only the third judge
//            scoreCards[2][0] = statisticsAndOutcomes.generateRandomByte((byte) 127) >= 63 ? 10 : 9;
//            scoreCards[2][1] = scoreCards[2][0] == 10 ? 9 : 10;
//
//            roundsAndScoreCards.put(round, scoreCards);
        return "Hello";
    }
}

