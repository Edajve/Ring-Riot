package org.boxingTournament;

import org.boxingTournament.conference.Conference;
import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.judges.Judge;
import org.boxingTournament.logging.ExportToTxt;
import org.boxingTournament.match.StatisticsAndOutcomes;
import org.boxingTournament.tournament.Tournament;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        //west fighters
        List<Fighter> westFighters = new ArrayList<>(
                List.of(
                        new Fighter("The Primegan", 158, "5'9\"", "Chicago, Il"),
                        new Fighter("Kenny Wilson", 158, "5'9\"", "Chicago, Il"),
                        new Fighter("Coi Leray", 158, "5'10\"", "Chicago, Il"),
                        new Fighter("Morgan Freeman", 158, "5'5\"", "Chicago, Il")
                )
        );

        //east fighters
        List<Fighter> eastFighters = new ArrayList<>(
                List.of(
                        new Fighter("Gervonta Davis", 135, "5'5\"", "Baltimore, MD"),
                        new Fighter("Shakur Stevenson", 135, "5'8\"", "Newark, NJ"),
                        new Fighter("Devin Haney", 115, "5'9\"", "San Francisco, CA"),
                        new Fighter("Vasily Lomachenko", 135, "5'7\"", "Bihorod-Dnistrovs\'Kyi, Ukraine"),
                        new Fighter("Isac Cruz", 135, "5'5\"", "Mexico City, Mexico"),
                        new Fighter("Ryan Garcia", 135, "5'11\"", "Los Alamitos, CA"),
                        new Fighter("Gustavo Daniel Lemos", 135, "5'5\"", "Tres Arroyos, Arentina"),
                        new Fighter("George Kambosos Jr", 135, "5'9\"", "Sydney, Australia")
                )
        );

        //east and west conferences
        Conference westConference = new Conference("West", westFighters);
        Conference eastConference = new Conference("East", eastFighters);

        //judges
        List<Judge> judges = new ArrayList<>(
                List.of(
                        new Judge("Judge 1"),
                        new Judge("Judge 2"),
                        new Judge("Judge 3")
                )
        );
        //tournament structure
        new Tournament(westConference, eastConference, judges, new StatisticsAndOutcomes()).runTournament();
    }
}