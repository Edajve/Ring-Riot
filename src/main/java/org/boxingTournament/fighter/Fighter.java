package org.boxingTournament.fighter;

import org.boxingTournament.enums.TournamentLevel;
import org.boxingTournament.enums.TournamentStatus;

import java.util.UUID;

public class Fighter {
    private final UUID id;
    private final String fullName;
    private final int lbs;
    private final String height;
    private final FightersRecord fightersRecord;
    public static TournamentLevel tournamentLevel;
    public static TournamentStatus tournamentStatus;

    public Fighter(
            String fullName,
            int lbs,
            String height
    ) {
        this.id = UUID.randomUUID();
        this.fullName = fullName;
        this.lbs = lbs;
        this.height = height;
        this.fightersRecord = new FightersRecord();
        tournamentLevel = TournamentLevel.ROUND_OF_16;
        tournamentStatus = TournamentStatus.ACTIVE;
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getLbs() {
        return lbs;
    }

    public String getHeight() {
        return height;
    }

    public FightersRecord getFightersRecord() {
        return fightersRecord;
    }

    public TournamentLevel getTournamentLevel() {
        return tournamentLevel;
    }

    public void setTournamentLevel(TournamentLevel tournamentLevel) {
        Fighter.tournamentLevel = tournamentLevel;
    }

    public TournamentStatus getTournamentStatus() {
        return tournamentStatus;
    }

    public void setTournamentStatus(TournamentStatus tournamentStatus) {
        Fighter.tournamentStatus = tournamentStatus;
    }

    public void addWinToFighter() {
        fightersRecord.addWin();
    }

    public void addLossToFighter() {
        fightersRecord.addLoss();
    }

    public void addDrawToFighter() {
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
