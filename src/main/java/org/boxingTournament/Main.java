package org.boxingTournament;

import org.boxingTournament.conference.Conference;
import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.judges.Judge;
import org.boxingTournament.match.StatisticsAndOutcomes;
import org.boxingTournament.tournament.Tournament;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //west fighters
        List<Fighter> westFighters = new ArrayList<>(
                List.of(
                        new Fighter("The Primegan", 158, "5'9"),
                        new Fighter("Kenny Wilson", 158, "5'9")
                )
        );

        //east fighters
        List<Fighter> eastFighters = new ArrayList<>(
                List.of(
                        new Fighter("Mike Bibby", 158, "5'9"),
                        new Fighter("Kerry Alis", 158, "5'9")
                )
        );

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