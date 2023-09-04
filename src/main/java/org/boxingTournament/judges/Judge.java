package org.boxingTournament.judges;

import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.interfaces.JudgeInterface;
import org.boxingTournament.match.StatisticsAndOutcomes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Judge implements JudgeInterface {
    private final static int ROUNDS_PER_BOUT = 12;
    private String fullName;
    private String winningfighter;
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

    public String getWinningfighter() {
        return winningfighter;
    }

    @Override
    public void judgeRound(StatisticsAndOutcomes statisticsAndOutcomes) {
        byte randomByte = statisticsAndOutcomes.generateRandomByte((byte) 127);
        if (randomByte > 63) winnerOfRounds.add(fighterA.getFullName());
        else winnerOfRounds.add(fighterB.getFullName());
    }

    @Override
    public UUID determineWinner() {
        return null;
    }

    @Override
    public void clear() {

    }
}
