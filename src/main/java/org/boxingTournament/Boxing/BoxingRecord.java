package org.boxingTournament.Boxing;

public class BoxingRecord {
    private int wins;
    private int losses;
    private int draws;

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
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
