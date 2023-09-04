package org.boxingTournament.judges;

import org.boxingTournament.interfaces.JudgeInterface;

import java.util.UUID;

public class Judge implements JudgeInterface {
    private String fullName;
    private String winningfighter;

    public Judge(String fullName) {
        this.fullName = fullName;
    }

    public String getWinningfighter() {
        return winningfighter;
    }

    @Override
    public void judgeRound() {

    }

    @Override
    public UUID determineWinner() {
        return null;
    }

    @Override
    public void clear() {

    }
}
