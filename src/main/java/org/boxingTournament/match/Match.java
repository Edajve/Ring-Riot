package org.boxingTournament.match;

import org.boxingTournament.enums.MatchStatus;
import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.judges.Judge;

import java.util.*;

public class Match {
    private static final int ROUNDS_PER_BOUT = 12;
    private Map<Integer, int[][]> roundsAndScoreCards = new HashMap<>();
    private Fighter fighterA; //may not need
    private Fighter fighterB; //may not need
    private MatchStatus matchStatus; //may not need
    private Set<Judge> judges;

    public Match(Fighter fighterA, Fighter fighterB, Set<Judge> judges) {
        this.fighterA = fighterA;
        this.fighterB = fighterB;
        this.judges = judges;
    }

    /**
     * TODO finish this method, you did the simulateRounds methods with populates the map
     * TODO now you just have to do the math and see who won the fight
     *
     * @return- the id of the fighter who won
     */
    public void runMatchSimuation() {
        System.out.println("Run simulation");
        for (int round = 1; round <= ROUNDS_PER_BOUT; round++) {

            //judge fighters
            //judge.judgeRound(statisticsAndOutcomes);

            //clear fighters
        }
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
    }

}

