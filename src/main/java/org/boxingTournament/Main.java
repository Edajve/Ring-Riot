package org.boxingTournament;

import org.boxingTournament.conference.Conference;
import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.judges.Judge;
import org.boxingTournament.match.Match;
import org.boxingTournament.match.StatisticsAndOutcomes;
import org.boxingTournament.tournament.Tournament;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //outcomes orchestrator
        StatisticsAndOutcomes outcomes = new StatisticsAndOutcomes();

        //west fighters
        List<Fighter> westFighters = new ArrayList<>();
        Fighter westFighterOne = new Fighter("D78oyi 8o7y", 158, "5'9");
        Fighter westFighterTwo = new Fighter("Hihe Echooihils", 158, "5'9");
        westFighters.add(westFighterOne);
        westFighters.add(westFighterTwo);

        //east fighters
        List<Fighter> eastFighters = new ArrayList<>();
        Fighter eastFighterOne = new Fighter("oijpoij", 158, "5'9");
        Fighter eastFighterTwo = new Fighter("Hpojojoojs", 158, "5'9");
        eastFighters.add(eastFighterOne);
        eastFighters.add(eastFighterTwo);

        //east and west conferences
        Conference westConference = new Conference(westFighters);
        Conference eastConference = new Conference(eastFighters);

        //judges
        Set<Judge> judges = new HashSet<>();
        judges.add(new Judge("Judge 1"));
        judges.add(new Judge("Judge 2"));
        judges.add(new Judge("Judge 3"));

        //tournament structure
        new Tournament(westConference, eastConference, judges).runTournament();
    }
}