package matchTest;

import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.judges.Judge;
import org.boxingTournament.match.Match;
import org.boxingTournament.match.StatisticsAndOutcomes;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MatchClassTest {

    private Fighter fighterA;
    private Fighter fighterB;
    private Match underTest;

    @BeforeEach
    void setUp() {
        fighterA = new Fighter("FighterOne", 136, "5'8\"");
        fighterB = new Fighter("FighterTwo", 135, "5'9\"");
        StatisticsAndOutcomes outcomes = new StatisticsAndOutcomes();
        List<Judge> judges = new ArrayList<>(
                List.of(
                        new Judge("Judge 1"),
                        new Judge("Judge 2"),
                        new Judge("Judge 3")
                )
        );
        underTest = new Match(fighterA, fighterB, judges, outcomes);
    }

    @Test
    void resultOfMatchBetweenJudges_IfPlayerOneIsUnanimous_ReturnPlayerOne() {
        // Given
        ArrayList<Optional<Fighter>> list = new ArrayList<>();
        list.add(Optional.of(fighterA));
        list.add(Optional.of(fighterA));
        list.add(Optional.empty()); // Indicates a draw

        // When
        Optional<Fighter> actual = underTest.resultOfMatchBetweenJudges(list);

        // Then
        Optional<Fighter> expected = Optional.of(fighterA);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void resultOfMatchBetweenJudges_IfPlayerBIsUnanimous_ReturnPlayerB() {
        // Given
        ArrayList<Optional<Fighter>> list = new ArrayList<>();
        list.add(Optional.of(fighterB));
        list.add(Optional.of(fighterB));
        list.add(Optional.empty()); // Indicates a draw

        // When
        Optional<Fighter> actual = underTest.resultOfMatchBetweenJudges(list);

        // Then
        Optional<Fighter> expected = Optional.of(fighterB);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void resultOfMatchBetweenJudges_IfMatchEndsInDraw_ReturnEmptyOptional() {
        // Given
        ArrayList<Optional<Fighter>> list = new ArrayList<>();
        list.add(Optional.of(fighterA));
        list.add(Optional.of(fighterB));
        list.add(Optional.empty()); // Indicates a draw

        // When
        Optional<Fighter> actual = underTest.resultOfMatchBetweenJudges(list);

        // Then
        Optional<Fighter> expected = Optional.empty(); // Draw
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void updateRecords_IfDraw_BothFightersGetsDraw() throws Exception {
        //given
        Optional<Fighter> winner = Optional.empty();
        //when
        underTest.updateRecords(winner);
        //then
        int fighterAExpected = 1;
        int fighterBExpected = 1;

        int fighterAActual = fighterA.getFightersRecord().getDraws();
        int fighterBActual = fighterB.getFightersRecord().getDraws();

        Assertions.assertEquals(fighterAExpected, fighterAActual);
        Assertions.assertEquals(fighterBExpected, fighterBActual);
    }

    @Test
    public void updateRecords_IfAWins_AGetsWinBGetsLoss() throws Exception {
        //given
        Optional<Fighter> winner = Optional.of(fighterA);
        //when
        underTest.updateRecords(winner);
        //then
        int fighterAExpected = 1;
        int fighterAActual = fighterA.getFightersRecord().getWins();

        Assertions.assertEquals(fighterAExpected, fighterAActual);
    }

    @Test
    public void updateRecords_IfBWins_BGetsWinAGetsLoss() throws Exception {
        //given
        Optional<Fighter> winner = Optional.of(fighterB);
        //when
        underTest.updateRecords(winner);
        //then
        int fighterBExpected = 1;
        int fighterBActual = fighterB.getFightersRecord().getWins();

        Assertions.assertEquals(fighterBExpected, fighterBActual);
    }


    @Test
    public void nextEnum_FighterWinds_GoToNextLevelInTournament() throws Exception {
        //given
        Optional<Fighter> winner = Optional.of(fighterB);
        //when
        underTest.updateRecords(winner);
        //then
        String expected = "QUARTER_FINALS";
        String actual = fighterB.getTournamentLevel().toString();

        Assertions.assertEquals(expected, actual);
    }
}


