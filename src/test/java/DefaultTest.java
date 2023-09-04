import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class DefaultTest {
    Calculator underTest = new Calculator();

    @Test
    void itShouldAddNumbers(){
        // given
        int one  = 20;
        int two = 50;

        // when
        int actual = underTest.addNum(one, two);

        //then
        int expected = 70;
        Assertions.assertEquals(actual, expected);
    }

    class Calculator {
        int addNum(int a , int b){
            return a + b;
        }
    }
}
