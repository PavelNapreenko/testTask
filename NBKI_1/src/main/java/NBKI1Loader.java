public class NBKI1Loader {

    public static void main(String[] args) {
        String input = "calculator";
        char targetChar = 'l';
        char newChar = 'L';
        print(input, targetChar, newChar);
    }


    private static void print(String input, char targetChar, char newChar) {

        System.out.println("Строка до изменения: " + input);

        System.out.println("Строка после изменения: " + CharReplacer.replaceCharInString(input, targetChar, newChar));
    }
}
