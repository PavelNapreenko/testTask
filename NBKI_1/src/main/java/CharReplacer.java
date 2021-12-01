public class CharReplacer {

    private CharReplacer() {
    }

    public static String replaceCharInString(String string, char target, char newChar) {
        StringBuilder sb = new StringBuilder();
        if (string.isEmpty())
            throw new EmptyStringException();

        if (!string.contains(String.valueOf(target)))
            throw new MissingCharacterInAString();

        for (char ch : string.toCharArray()) {
            if (ch == target)
                ch = newChar;
            sb.append(ch);
        }
        return sb.toString();
    }

    public static class EmptyStringException extends RuntimeException {
        public EmptyStringException() {
            super("Пустая строка.");
        }
    }

    public static class MissingCharacterInAString extends RuntimeException {
        public MissingCharacterInAString() {
            super("Строка не содержит искомый символ.");
        }
    }
}
