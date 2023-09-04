package fightersTest;

import org.boxingTournament.fighter.Fighter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FightersTest {
    private final Fighter underTest = new Fighter("Billy Joe", 135, "5'8\"");

    @Test
    void addWinThroughFighter_ExpectedRecordWinShouldIncreaseByOne() {
        //when
        underTest.addWinToFighter();
        //then
        String expected = "{wins=1, losses=0, draws=0}";
        String actual = underTest.getFightersRecord().toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addLossThroughFighter_ExpectedRecordLossShouldIncreaseByOne() {
        //when
        underTest.addLossToFighter();
        //then
        String expected = "{wins=0, losses=1, draws=0}";
        String actual = underTest.getFightersRecord().toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addDrawThroughFighter_ExpectedRecordDrawShouldIncreaseByOne() {
        //when
        underTest.addDrawToFighter();
        //then
        String expected = "{wins=0, losses=0, draws=1}";
        String actual = underTest.getFightersRecord().toString();
        Assertions.assertEquals(expected, actual);
    }
}
