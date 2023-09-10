package org.boxingTournament.fighter;

import org.boxingTournament.enums.TournamentLevel;
import org.boxingTournament.enums.TournamentStatus;

import java.util.UUID;

public class Fighter {
    private final UUID id;
    private final String fullName;
    private final String birthPlace;
    private final int lbs;
    private final String height;
    private final FightersRecord fightersRecord;
    public String tournamentLevel;
    public String tournamentStatus;

    public Fighter(
            String fullName,
            int lbs,
            String height,
            String birthPlace
    ) {
        this.id = UUID.randomUUID();
        this.fullName = fullName;
        this.lbs = lbs;
        this.height = height;
        this.fightersRecord = new FightersRecord();
        this.tournamentLevel = TournamentLevel.ROUND_OF_16.toString();
        this.tournamentStatus = TournamentStatus.ACTIVE.toString();
        this.birthPlace = birthPlace;
    }

    public String getFullName() {
        return fullName;
    }

    public FightersRecord getFightersRecord() {
        return fightersRecord;
    }

    public String getTournamentLevel() {
        return tournamentLevel;
    }

    public void setTournamentLevel(String tournamentLevel) {
        this.tournamentLevel = tournamentLevel;
    }

    public String getTournamentStatus() {
        return tournamentStatus;
    }

    public void setTournamentStatus(String tournamentStatus) {
        this.tournamentStatus = tournamentStatus;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public int getLbs() {
        return lbs;
    }

    public String getHeight() {
        return height;
    }

    public void addWin() {
        fightersRecord.addWin();
    }

    public void addLoss() {
        fightersRecord.addLoss();
    }

    public void addDraw() {
        fightersRecord.addDraw();
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", lbs=" + lbs +
                ", height='" + height + '\'' +
                ", fightersRecord=" + fightersRecord +
                ", tournamentLevel=" + tournamentLevel +
                ", tournamentStatus=" + tournamentStatus +
                '}';
    }
}
