package org.boxingTournament.interfaces;

import org.boxingTournament.match.StatisticsAndOutcomes;

import java.util.UUID;

public interface JudgeInterface {
    void judgeRound(StatisticsAndOutcomes statisticsAndOutcomes); //will populate a private member variable
    UUID determineWinner();
    void clear();

}
