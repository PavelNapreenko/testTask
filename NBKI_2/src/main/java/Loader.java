public class Loader {
    public static void main(String[] args) {
        String intNum = "125456456";
        String doubleNum = "125456,52";

        print(NumsStringParser.getInt(intNum));
        print(NumsStringParser.getDouble(doubleNum));
        print(NumsStringParser.getInt_1(intNum));
        print(NumsStringParser.getDouble_1(doubleNum));
    }

    private static void print(int num) {
        if (num == 0) {
            System.out.println("Значение цифры в строке неверно.");
        } else {
            System.out.println(num);
        }
    }

    private static void print(double num) {
        if (num == 0) {
            System.out.println("Значение цифры в строке неверно.");
        } else {
            System.out.printf("%.2f", num);
            System.out.println("\n");
        }
    }
}
