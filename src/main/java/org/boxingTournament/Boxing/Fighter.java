package org.boxingTournament.Boxing;

import org.boxingTournament.enums.TournamentLevel;
import org.boxingTournament.enums.TournamentStatus;

public class Fighter {
    private final int id;
    private final String fullName;
    private final int lbs;
    private final String height;
    private BoxingRecord record;
    private TournamentLevel tournamentLevel;
    private TournamentStatus tournamentStatus;

    public Fighter(
            int id, String fullName,
            int lbs, String height,
            BoxingRecord record
    ) {
        this.id = id;
        this.fullName = fullName;
        this.lbs = lbs;
        this.height = height;
        this.record = record;
        this.tournamentLevel = TournamentLevel.ROUND_OF_16;
        this.tournamentStatus = TournamentStatus.ACTIVE;
    }

    public int getId() {
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

    public BoxingRecord getRecord() {
        return record;
    }

    public void setRecord(BoxingRecord record) {
        this.record = record;
    }

    public TournamentLevel getTournamentLevel() {
        return tournamentLevel;
    }

    public void setTournamentLevel(TournamentLevel tournamentLevel) {
        this.tournamentLevel = tournamentLevel;
    }

    public TournamentStatus getTournamentStatus() {
        return tournamentStatus;
    }

    public void setTournamentStatus(TournamentStatus tournamentStatus) {
        this.tournamentStatus = tournamentStatus;
    }
}
