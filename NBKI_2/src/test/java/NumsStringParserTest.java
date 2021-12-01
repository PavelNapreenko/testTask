import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class NumsStringParserTest {

    private String intNum;
    private String doubleNum;
    private String doubleNumWithComma;


    public NumsStringParserTest() {
    }

    @Before
    public void setUp() {
        intNum = "12345";
        doubleNum = "12345.52";
        doubleNumWithComma = "12345,52";
    }

    @Test
    @DisplayName("Тест строки с целым числом.")
    public void testIntParse() {
        int i = 12345;
        assertEquals(i, NumsStringParser.getInt(intNum));
    }

    @Test
    @DisplayName("Тест строки с числом с плавающей запятой(число записано через . )")
    public void testDoubleParse_1() {
        double d = 12345.52;
        assertEquals(d, NumsStringParser.getDouble(doubleNum),0.00);
    }

    @Test
    @DisplayName("Тест строки с числом с плавающей запятой(число записано через , )")
    public void testDoubleParse_2() {
        double d = 12345.52;
        assertEquals(d, NumsStringParser.getDouble(doubleNumWithComma),0.00);
    }
}
