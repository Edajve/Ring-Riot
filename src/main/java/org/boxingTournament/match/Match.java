package org.boxingTournament.match;

import org.boxingTournament.constants.Constants;
import org.boxingTournament.enums.TournamentLevel;
import org.boxingTournament.enums.TournamentStatus;
import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.judges.Judge;

import java.util.*;

public class Match {
    private final Fighter fighterA;
    private final Fighter fighterB;
    private final List<Judge> judges;
    private final StatisticsAndOutcomes outcomes;

    public Match(Fighter fighterA, Fighter fighterB, List<Judge> judges, StatisticsAndOutcomes outcomes) {
        this.fighterA = fighterA;
        this.fighterB = fighterB;
        this.judges = judges;
        this.outcomes = outcomes;
    }

    public Fighter runMatch() throws Exception {
        Fighter winner = null;

        while (winner == null) {
            // Enroll fighters under all judges
            for (Judge judge : this.judges) {
                judge.setFighterA(fighterA);
                judge.setFighterB(fighterB);
            }

            for (int round = 0; round < Constants.ROUNDS_PER_BOUT; round++) {
                for (Judge judge : this.judges) judge.judgeRound(this.outcomes);
            }

            ArrayList<Optional<Fighter>> listOfTheWinnerPerEachJudge = new ArrayList<>();
            judges.forEach(j -> listOfTheWinnerPerEachJudge.add(j.whoWonPerJudgeOpinion()));

            Optional<Fighter> resultOfBout = resultOfMatchBetweenJudges(listOfTheWinnerPerEachJudge);
            updateRecords(resultOfBout);
            if (resultOfBout.isPresent()) winner = resultOfBout.get();
        }

        return winner;
    }

    public Optional<Fighter> resultOfMatchBetweenJudges(ArrayList<Optional<Fighter>> listOfTheWinnerPerEachJudge) {
        Map<Fighter, Integer> occurrenceOfWins = new HashMap<>();

        for (Optional<Fighter> winnerOfAJudge : listOfTheWinnerPerEachJudge) {
            if (winnerOfAJudge.isPresent()) {
                Fighter fighter = winnerOfAJudge.get();
                if (occurrenceOfWins.containsKey(fighter)) {
                    occurrenceOfWins.put(fighter, occurrenceOfWins.get(fighter) + 1);
                } else {
                    occurrenceOfWins.put(fighter, 1);
                }
            }
        }

        if (occurrenceOfWins.size() == 1) { //all three judges chose one person
            return Optional.of(occurrenceOfWins.keySet().iterator().next());
        }

        if (occurrenceOfWins.size() == 2) { //who won 2/3 times
            for (Map.Entry<Fighter, Integer> entry : occurrenceOfWins.entrySet()) {
                if (entry.getValue() == 2) {
                    return Optional.of(entry.getKey());
                }
            }
        }
        // return null (draw)
        return Optional.empty();
    }

    public void updateRecords(Optional<Fighter> winner) throws Exception {
        if (winner.isEmpty()) {
            fighterA.addDraw();
            fighterB.addDraw();
        } else {
            Fighter winningFighter = winner.get();
            Fighter losingFighter = (winningFighter == fighterA) ? fighterB : fighterA;

            winningFighter.addWin();
            nextEnum(winningFighter.getTournamentLevel().toString(), winningFighter);
            losingFighter.addLoss();
            losingFighter.setTournamentStatus(TournamentStatus.ELIMINATED);
        }
    }

    public void nextEnum(String enumState, Fighter fighter) throws Exception {
        switch (enumState) {
            case "ROUND_OF_16" -> fighter.setTournamentLevel(TournamentLevel.QUARTER_FINALS);
            case "QUARTER_FINALS" -> fighter.setTournamentLevel(TournamentLevel.SEMI_FINALS);
            case "SEMI_FINALS" -> fighter.setTournamentLevel(TournamentLevel.FINALS);
            case "FINALS" -> fighter.setTournamentLevel(TournamentLevel.CHAMPION);
            default -> throw new Exception("Parameter is not in switch case");
        }
    }
}

