import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class CharReplacerTest {

    private String string;

    public CharReplacerTest() {
    }

    @Before
    public void setUp() {
        string = "Hello World";
    }

    @Test
    @DisplayName("Текст = Hello World")
    public void testReplaceChar() {
        String resultString = "HeQQo WorQd";
        assertEquals(resultString, CharReplacer.replaceCharInString(string, 'l', 'Q'));
    }

    @Test
    @DisplayName("Тест пустой строки")
    public void testEmptyString() {
        string = "";
        CharReplacer.EmptyStringException thrown = Assertions.assertThrows(CharReplacer.EmptyStringException.class,
                () -> CharReplacer.replaceCharInString(string, 'l', 'Q'));
        Assertions.assertEquals("Пустая строка.", thrown.getMessage());
    }

    @Test
    @DisplayName("Тест отсутствия искомого символа")
    public void testMissingChar() {
        string = "Mama";
        CharReplacer.MissingCharacterInAString thrown = Assertions.assertThrows(CharReplacer.MissingCharacterInAString.class,
                () -> CharReplacer.replaceCharInString(string, 'l', 'Q'));
        Assertions.assertEquals("Строка не содержит искомый символ.", thrown.getMessage());
    }
}
