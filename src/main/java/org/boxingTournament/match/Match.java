package org.boxingTournament.match;

import org.boxingTournament.constants.Constants;
import org.boxingTournament.enums.MatchStatus;
import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.judges.Judge;

import java.util.*;

public class Match {
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

    public Fighter runMatchSimulationAndReturnWinner() {
        Fighter winner = null;

        // Loop until a winner is determined
        while (winner == null) {
            // Enroll fighters under all judges
            for (Judge judge : this.judges) {
                judge.setFighterA(fighterA);
                judge.setFighterB(fighterB);
            }

            // Each judge scores each round at each iteration
            for (int round = 0; round < Constants.ROUNDS_PER_BOUT; round++) {
                for (Judge judge : this.judges) judge.judgeRound(this.outcomes);
            }

            // Add all three judges personal winners to a list of Optionals
            ArrayList<Optional<Fighter>> listOfTheWinnerPerEachJudge = new ArrayList<>();
            judges.forEach(j -> listOfTheWinnerPerEachJudge.add(j.whoWonPerJudgeOpinion()));

            // Get the result of the match from the list of Optionals, handling empty (draw) gracefully
            Optional<Fighter> result = resultOfMatchBetweenJudges(listOfTheWinnerPerEachJudge);

            // If it's a draw, continue the loop to retry the match
            if (result.isPresent()) {
                winner = result.get();
            }
        }

        return winner;
    }

    public Optional<Fighter> resultOfMatchBetweenJudges(ArrayList<Optional<Fighter>> list) {
        Map<Fighter, Integer> fighterCountMap = new HashMap<>();

        // Count the number of times each fighter appears as a winner
        for (Optional<Fighter> winner : list) {
            winner.ifPresent(fighter -> {
                fighterCountMap.put(fighter, fighterCountMap.getOrDefault(fighter, 0) + 1);
            });
        }

        // If there's only one fighter with the most wins, return that fighter
        if (fighterCountMap.size() == 1) {
            return Optional.of(fighterCountMap.keySet().iterator().next());
        }

        // If there are two fighters with the same number of wins, return the fighter with 2 wins
        if (fighterCountMap.size() == 2) {
            for (Map.Entry<Fighter, Integer> entry : fighterCountMap.entrySet()) {
                if (entry.getValue() == 2) {
                    return Optional.of(entry.getKey());
                }
            }
        }

        // If there are three fighters with different wins, return null (draw)
        return Optional.empty();
    }
}

