public class Loader {
    public static void main(String[] args) {
        String intNum = "-125456456 1221";
        String doubleNum = "125456.523";
        if(NumsStringParser.getInt(intNum) == 0) {
            System.out.println("Значение цифры в строке неверно.");
        } else {
            System.out.println(NumsStringParser.getInt(intNum));
        }
        if(NumsStringParser.getDouble(doubleNum) == 0) {
            System.out.println("Значение цифры в строке неверно.");
        } else {
            System.out.printf("%.2f",NumsStringParser.getDouble(doubleNum));
        }
    }
}
