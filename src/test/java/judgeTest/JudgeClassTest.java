package judgeTest;

import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.judges.Judge;
import org.boxingTournament.match.StatisticsAndOutcomes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JudgeClassTest {
    Judge underTest;

    @Test
    void judgeRound_winnerOfRoundsArrayIncreases() {
        //Given
        underTest = new Judge("Billy Joe");
        underTest.setFighterA(new Fighter("Test", 134, "5-10"));
        underTest.setFighterB(new Fighter("Test2", 134, "5-10"));

        StatisticsAndOutcomes statisticsAndOutcomes = new StatisticsAndOutcomes();
        underTest.judgeRound(statisticsAndOutcomes);

        //Then
        int expectedLength = 1;
        assertEquals(expectedLength, underTest.getWinnerOfRounds().size());
    }

    @Test
    void judgeRound_winnerOfRoundsArrayIncreasesAsJudgesKeepScoringRounds() {
        //Given
        underTest = new Judge("Billy Joe");
        underTest.setFighterA(new Fighter("Test", 134, "5-10"));
        underTest.setFighterB(new Fighter("Test2", 134, "5-10"));

        StatisticsAndOutcomes statisticsAndOutcomes = new StatisticsAndOutcomes();
        underTest.judgeRound(statisticsAndOutcomes);
        underTest.judgeRound(statisticsAndOutcomes);
        underTest.judgeRound(statisticsAndOutcomes);

        //Then
        int expectedLength = 3;
        assertEquals(expectedLength, underTest.getWinnerOfRounds().size());
    }

    private Fighter fighterA;
    private Fighter fighterB;

    @Test
    public void testDetermineWinner_Draw() {
        //given
        underTest = new Judge("JudgeName");
        fighterA = new Fighter("FighterA", 158, "5'9");
        fighterB = new Fighter("FighterB", 158, "5'9");
        underTest.setFighterA(fighterA);
        underTest.setFighterB(fighterB);
        // Simulate a draw by adding 6 rounds for each fighter
        for (int i = 0; i < 6; i++) {
            underTest.getWinnerOfRounds().add(fighterA.getFullName());
            underTest.getWinnerOfRounds().add(fighterB.getFullName());
        }
        assertEquals("draw", underTest.whoWonPerJudgeOpinion());
    }

    @Test
    public void testDetermineWinner_FighterA_Wins() {
        //given
        underTest = new Judge("JudgeName");
        fighterA = new Fighter("FighterA", 158, "5'9");
        fighterB = new Fighter("FighterB", 158, "5'9");
        underTest.setFighterA(fighterA);
        underTest.setFighterB(fighterB);
        // Simulate Fighter A winning 7 rounds
        for (int i = 0; i < 7; i++) {
            underTest.getWinnerOfRounds().add(fighterA.getFullName());
        }
        assertEquals(fighterA.getFullName(), underTest.whoWonPerJudgeOpinion());
    }

    @Test
    public void testDetermineWinner_FighterB_Wins() {
        //given
        underTest = new Judge("JudgeName");
        fighterA = new Fighter("FighterA", 158, "5'9");
        fighterB = new Fighter("FighterB", 158, "5'9");
        underTest.setFighterA(fighterA);
        underTest.setFighterB(fighterB);
        // Simulate Fighter B winning 7 rounds
        for (int i = 0; i < 7; i++) {
            underTest.getWinnerOfRounds().add(fighterB.getFullName());
        }
        assertEquals(fighterB.getFullName(), underTest.whoWonPerJudgeOpinion());
    }
}
