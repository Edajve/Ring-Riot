package org.boxingTournament.judges;

import org.boxingTournament.constants.Constants;
import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.interfaces.JudgeInterface;
import org.boxingTournament.match.StatisticsAndOutcomes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Judge implements JudgeInterface {
    private final String fullName;
    private final List<String> winnerOfRounds;
    private Fighter fighterA;
    private Fighter fighterB;

    public Judge(String fullName) {
        this.fullName = fullName;
        this.winnerOfRounds = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public List<String> getWinnerOfRounds() {
        return winnerOfRounds;
    }

    public void setFighterA(Fighter fighterA) {
        this.fighterA = fighterA;
    }

    public void setFighterB(Fighter fighterB) {
        this.fighterB = fighterB;
    }

    @Override
    public void judgeRound(StatisticsAndOutcomes statisticsAndOutcomes) {
        boolean randomOutcome =
                statisticsAndOutcomes
                        .generateOne()
                        .generateTwo()
                        .getTransistor();

        if (randomOutcome)
            winnerOfRounds.add(fighterB.getFullName());
        else winnerOfRounds.add(fighterA.getFullName());
    }

    @Override
    public Optional<Fighter> whoWonPerJudgeOpinion() {
        long roundsWonByFighterA = this.getWinnerOfRounds().stream()
                .filter(winner -> winner.equals(this.fighterA.getFullName()))
                .count();

        long roundsWonByFighterB = Constants.ROUNDS_PER_BOUT - roundsWonByFighterA;

        if (roundsWonByFighterA == roundsWonByFighterB)
            return Optional.empty(); // Draw
        else if (roundsWonByFighterA < roundsWonByFighterB)
            return Optional.of(fighterB);
        else return Optional.of(fighterA);
    }
}
