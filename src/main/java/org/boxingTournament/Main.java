package org.boxingTournament;

import org.boxingTournament.conference.Conference;
import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.judges.Judge;
import org.boxingTournament.match.StatisticsAndOutcomes;
import org.boxingTournament.tournament.Tournament;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        //west fighters
        List<Fighter> westFighters = new ArrayList<>(
                List.of(
                        new Fighter("The Primegan", 158, "5'9"),
                        new Fighter("Kenny Wilson", 158, "5'9"),
                        new Fighter("Coi Leray", 158, "5'10"),
                        new Fighter("Morgan Freeman", 158, "5'5")
                )
        );

        /**
         * TODO start filling out real boxers with their real data
         */
        //east fighters
        List<Fighter> eastFighters = new ArrayList<>(
                List.of(
                        new Fighter("Mike Bibby", 158, "5'9"),
                        new Fighter("Kerry Alis", 158, "5'9"),
                        new Fighter("Lonzo Ball", 158, "5'8"),
                        new Fighter("Kamala Harris", 158, "5'6"),

                        new Fighter("The Primegan", 158, "5'9"),
                        new Fighter("Kenny Wilson", 158, "5'9"),
                        new Fighter("Coi Leray", 158, "5'10"),
                        new Fighter("Morgan Freeman", 158, "5'5")
                )
        );

        /**
         * TODO start filling out real boxers with their real data
         */
        //east and west conferences
        Conference westConference = new Conference(westFighters);
        Conference eastConference = new Conference(eastFighters);

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