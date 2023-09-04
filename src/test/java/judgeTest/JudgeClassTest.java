package judgeTest;

import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.judges.Judge;
import org.boxingTournament.match.StatisticsAndOutcomes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JudgeClassTest {

    @Test
    void judgeRound_winnerOfRoundsArrayIncreases(){
        //Given
        Judge underTest = new Judge("Billy Joe");
        underTest.setFighterA(new Fighter("Test", 134, "5-10"));
        underTest.setFighterB(new Fighter("Test2", 134, "5-10"));

        StatisticsAndOutcomes statisticsAndOutcomes = new StatisticsAndOutcomes();
        underTest.judgeRound(statisticsAndOutcomes);

        //Then
        int expectedLength = 1;
        Assertions.assertEquals(expectedLength, underTest.getWinnerOfRounds().size());
    }

    @Test
    void judgeRound_winnerOfRoundsArrayIncreasesAsJudgesKeepScoringRounds(){
        //Given
        Judge underTest = new Judge("Billy Joe");
        underTest.setFighterA(new Fighter("Test", 134, "5-10"));
        underTest.setFighterB(new Fighter("Test2", 134, "5-10"));

        StatisticsAndOutcomes statisticsAndOutcomes = new StatisticsAndOutcomes();
        underTest.judgeRound(statisticsAndOutcomes);
        underTest.judgeRound(statisticsAndOutcomes);
        underTest.judgeRound(statisticsAndOutcomes);

        //Then
        int expectedLength = 3;
        Assertions.assertEquals(expectedLength, underTest.getWinnerOfRounds().size());
    }
}
