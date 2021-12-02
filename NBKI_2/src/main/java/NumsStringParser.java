import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumsStringParser {
    private final static Pattern patternInt = Pattern.compile("[-+]?[0-9]*");
    private final static Pattern patternDouble = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?");
    private final static Pattern patternDoubleWithComma = Pattern.compile("[-+]?[0-9]*,?[0-9]+([eE][-+]?[0-9]+)?");

    public static int getInt(String text) {
        int num = 0;
        Matcher matcherInt = patternInt.matcher(text);
        if (matcherInt.find()) {
            num = Integer.parseInt(matcherInt.group());
        }
        return num;
    }

    public static double getDouble(String text) {
        double number = 0;
        Matcher matcherDouble = patternDouble.matcher(text);
        Matcher matcherDoubleWithComma = patternDoubleWithComma.matcher(text);
        if (matcherDoubleWithComma.matches()) {
            text = matcherDoubleWithComma.group().replace(',', '.');
            number = Double.parseDouble(text);
        }
        if (matcherDouble.matches()) {
            number = Double.parseDouble(matcherDouble.group());
        }
        return number;
    }

    public static int getInt_1(String text) {
        return StringToNum(text);
    }

    public static double getDouble_1(String text) {
        double number = 0;
        Matcher matcherDouble = patternDouble.matcher(text);
        Matcher matcherDoubleWithComma = patternDoubleWithComma.matcher(text);
        if (matcherDouble.matches()) {
            String[] stringNum = matcherDouble.group().split("\\.");
            number = getDoubleFromStringArray(stringNum);
        }
        if (matcherDoubleWithComma.matches()) {
            String[] stringNum = matcherDoubleWithComma.group().split(",");
            number = getDoubleFromStringArray(stringNum);
        }
        return number;
    }

    private static int StringToNum(String text) {
        int num = 0;
        int i = 0;

        while (i < text.length()) {
            if (Character.isAlphabetic(text.charAt(i))) {
                num = 0;
                break;
            } else if (Character.isDigit(text.charAt(i))) {
                num = num * 10 + text.charAt(i) - '0';
            } else {
                num = 0;
            }
            i++;
        }
        if (text.charAt(0) == '-') {
            num = num * -1;
        }
        return num;
    }

    private static double getDoubleFromStringArray(String[] textAr) {
        String wholePart = textAr[0];
        String fractionalPart = textAr[1];
        double f = (double) StringToNum(fractionalPart) / 100;
        return StringToNum(wholePart) + f;
    }
}
