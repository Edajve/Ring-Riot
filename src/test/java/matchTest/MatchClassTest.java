package matchTest;

import org.boxingTournament.fighter.Fighter;
import org.boxingTournament.judges.Judge;
import org.boxingTournament.match.Match;
import org.boxingTournament.match.StatisticsAndOutcomes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MatchClassTest {

    Fighter fighterOne = new Fighter("FighterOne", 136, "5'\"8");
    Fighter fighterTwo = new Fighter("FighterTwo", 135, "5'\"9");
    StatisticsAndOutcomes outcomes = new StatisticsAndOutcomes();
    List<Judge> judges = new ArrayList<>(
            List.of(
                    new Judge("Judge 1"),
                    new Judge("Judge 2"),
                    new Judge("Judge 3")
            )
    );

    Match underTest = new Match(fighterOne, fighterTwo, judges, outcomes);

    /**
     * Don't neet do test simulateRounds() because its is a private methods, but its being called
     * withing returnFightResults() so we will be indirectly testing this method via another.
     * It was manually validated, and it looks good, all the rounds seem random and not clear
     * pattern. LGTM
     */
    @Test
    void resultOfMatchBetweenJudges_IfPlayerOneIsUnanimous_ReturnPlayerOne() {
        // Given
        ArrayList<Optional<Fighter>> list = new ArrayList<>();
        list.add(Optional.of(fighterOne));
        list.add(Optional.of(fighterOne));
        list.add(Optional.empty()); // Indicates a draw

        // When
        Optional<Fighter> actual = underTest.resultOfMatchBetweenJudges(list);

        // Then
        Optional<Fighter> expected = Optional.of(fighterOne);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void resultOfMatchBetweenJudges_IfPlayerBIsUnanimous_ReturnPlayerB() {
        // Given
        ArrayList<Optional<Fighter>> list = new ArrayList<>();
        list.add(Optional.of(fighterTwo));
        list.add(Optional.of(fighterTwo));
        list.add(Optional.empty()); // Indicates a draw

        // When
        Optional<Fighter> actual = underTest.resultOfMatchBetweenJudges(list);

        // Then
        Optional<Fighter> expected = Optional.of(fighterTwo);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void resultOfMatchBetweenJudges_IfMatchEndsInDraw_ReturnEmptyOptional() {
        // Given
        ArrayList<Optional<Fighter>> list = new ArrayList<>();
        list.add(Optional.of(fighterOne));
        list.add(Optional.of(fighterTwo));
        list.add(Optional.empty()); // Indicates a draw

        // When
        Optional<Fighter> actual = underTest.resultOfMatchBetweenJudges(list);

        // Then
        Optional<Fighter> expected = Optional.empty(); // Draw
        Assertions.assertEquals(expected, actual);
    }
}
