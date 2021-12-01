import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumsStringParser {

    public static int getInt(String text) {
        Pattern patternInt = Pattern.compile("[-+]?[0-9]*");
        Matcher matcherInt = patternInt.matcher(text);

        if (matcherInt.matches()) {
            return Integer.parseInt(text);
        }
        return 0;
    }
    public static double getDouble(String text) {
        Pattern patternDouble = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?");
        Pattern patternDoubleWithComma = Pattern.compile("[-+]?[0-9]*,?[0-9]+([eE][-+]?[0-9]+)?");
        Matcher matcherDouble = patternDouble.matcher(text);
        Matcher matcherDoubleWithComma = patternDoubleWithComma.matcher(text);
        if (matcherDoubleWithComma.matches()){
            text = text.replace(',', '.');
            return Double.parseDouble(text);
        }

        if (matcherDouble.matches()) {
            return Double.parseDouble(text);
        }
        return 0;
    }
}
