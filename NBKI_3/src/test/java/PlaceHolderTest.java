import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class PlaceHolderTest {

    String firstWord;
    String secondWord;
    String thirdWord;
    int firstNum;
    int secondNum;
    int from;
    int to;

    public PlaceHolderTest() {
    }

    @Before
    public void setUp() {
        firstWord = "Hello";
        secondWord = "World";
        thirdWord = "TheEnd";
        firstNum = 2;
        secondNum = 5;
        from = 1;
        to = 10;
    }

    @Test
    @DisplayName("PlaceHolderTest")
    public void testPlaceHolder() {
        String resultString = "1\n" + "Hello\n" + "3\n" + "Hello\n" + "World\n" + "Hello\n" + "7\n" + "Hello\n" + "9\n" + "TheEnd\n";
        assertEquals(resultString, PlaceHolder.replace(firstWord, secondWord, thirdWord, firstNum, secondNum, from, to));
    }

    @Test
    @DisplayName("Неверные условия цикла")
    public void testFirstCycleCondition() {
        int from = 20;
        PlaceHolder.CycleConditionsException thrown = Assertions.assertThrows(PlaceHolder.CycleConditionsException.class,
                () -> PlaceHolder.replace(firstWord, secondWord, thirdWord, firstNum, secondNum, from, to));
        Assertions.assertEquals("The cycle conditions are incorrect: (from >= to).", thrown.getMessage());
    }
}
