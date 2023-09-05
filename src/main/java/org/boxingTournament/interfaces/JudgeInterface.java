package org.boxingTournament.interfaces;

import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.match.StatisticsAndOutcomes;

import java.util.Optional;

public interface JudgeInterface {
    void judgeRound(StatisticsAndOutcomes statisticsAndOutcomes);

    Optional<Fighter> whoWonPerJudgeOpinion();

    void clear();
}
