package org.boxingTournament;

import org.boxingTournament.enums.TournamentLevel;
import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.fighter.FightersRecord;
import org.boxingTournament.match.Match;
import org.boxingTournament.match.StatisticsAndOutcomes;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Fighter fighter = new Fighter("Dajve Echols", 158, "5'9");
        Fighter fighter2 = new Fighter("Hihe Echooihils", 158, "5'9");
        StatisticsAndOutcomes s = new StatisticsAndOutcomes();
        Match match = new Match(fighter, fighter2, s);

    }
}