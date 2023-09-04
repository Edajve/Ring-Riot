package org.boxingTournament;

import org.boxingTournament.enums.TournamentLevel;
import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.fighter.FightersRecord;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Fighter fighter = new Fighter("Dajve Echols", 158, "5'9");
        System.out.println(fighter.getTournamentLevel());
    }
}