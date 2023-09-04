package FightersTest;

import org.boxingTournament.fighter.FightersRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FightersRecordTest {
    private final FightersRecord underTest = new FightersRecord();

    @Test
    void addWin_addWinToRecord_ExpectedWinRecordToIncrementByOne() {
        //when
        underTest.addWin();
        //then
        int expected = 1;
        int actual = underTest.getWins();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addLoss_addLossToRecord_ExpectedLossRecordToIncrementByOne() {
        //when
        underTest.addLoss();
        //then
        int expected = 1;
        int actual = underTest.getLosses();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addDraw_addDrawToRecord_ExpectedDrawRecordToIncrementByOne() {
        //when
        underTest.addDraw();
        //then
        int expected = 1;
        int actual = underTest.getDraws();
        Assertions.assertEquals(expected, actual);
    }
}
