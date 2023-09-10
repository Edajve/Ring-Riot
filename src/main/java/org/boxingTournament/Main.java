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

        /**
         * TODO start filling out real boxers with their real data
         */
        //east fighters
        List<Fighter> eastFighters = new ArrayList<>(
                List.of(
                        new Fighter("Mike Bibby", 158, "5'9\"", "Chicago, Il"),
                        new Fighter("Kerry Alis", 158, "5'9\"", "Chicago, Il"),
                        new Fighter("Lonzo Ball", 158, "5'8\"", "Chicago, Il"),
                        new Fighter("Kamala Harris", 158, "5'6\"", "Chicago, Il"),

                        new Fighter("The Primegan", 158, "5'9\"", "Chicago, Il"),
                        new Fighter("Kenny Wilson", 158, "5'9\"", "Chicago, Il"),
                        new Fighter("Coi Leray", 158, "5'10\"", "Chicago, Il"),
                        new Fighter("Morgan Freeman", 158, "5'5\"", "Chicago, Il")
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