package org.boxingTournament.fighter;

public class FightersRecord {
    private int wins = 0;
    private int losses = 0;
    private int draws = 0;

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public void addWin(){
        this.wins++;
    }

    public void addLoss(){
        this.losses++;
    }

    public void addDraw(){
        this.draws++;
    }

    @Override
    public String toString() {
        return "BoxingRecord{" +
                "wins=" + wins +
                ", losses=" + losses +
                ", draws=" + draws +
                '}';
    }
}
