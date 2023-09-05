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
    private List<String> winnerOfRounds;
    private Fighter fighterA;
    private Fighter fighterB;

    public Judge(String fullName) {
        this.fullName = fullName;
        this.winnerOfRounds = new ArrayList<>();
    }

    public List<String> getWinnerOfRounds() {
        return winnerOfRounds;
    }

    public Fighter getFighterA() {
        return fighterA;
    }

    public void setFighterA(Fighter fighterA) {
        this.fighterA = fighterA;
    }

    public Fighter getFighterB() {
        return fighterB;
    }

    public void setFighterB(Fighter fighterB) {
        this.fighterB = fighterB;
    }

    @Override
    public void judgeRound(StatisticsAndOutcomes statisticsAndOutcomes) {
        byte randomByte = statisticsAndOutcomes.generateRandomByte((byte) 127);
        if (randomByte > 63) winnerOfRounds.add(fighterA.getFullName());
        else winnerOfRounds.add(fighterB.getFullName());
    }

    @Override
    public Optional<Fighter> whoWonPerJudgeOpinion() {
        long roundsWonByFighterA = this.getWinnerOfRounds().stream()
                .filter(winner -> winner.equals(this.fighterA.getFullName()))
                .count();

        long roundsWonByFighterB = Constants.ROUNDS_PER_BOUT - roundsWonByFighterA; // Calculate rounds won by fighterB

        if (roundsWonByFighterA == roundsWonByFighterB) {
            // Draw
            return Optional.empty();
        } else if (roundsWonByFighterA < roundsWonByFighterB) {
            // FighterB won
            return Optional.of(fighterB);
        } else {
            // FighterA won
            return Optional.of(fighterA);
        }
    }


    @Override
    public void clear() {

    }
}
