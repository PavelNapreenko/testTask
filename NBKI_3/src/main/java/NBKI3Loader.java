public class NBKI3Loader {
    public static void main(String[] args) {
        String fizz = "Fizz";
        String buzz = "Buzz";
        String fizzbuzz = "FizzBuzz";
        int firstNumberIsMultiple = 3;
        int secondNumberIsMultiple = 5;
        int from = 1;
        int to = 100;
        print(fizz, buzz, fizzbuzz, firstNumberIsMultiple, secondNumberIsMultiple, from, to);
    }

    //печатаем цифры от 1 до 100 включительно, с заменой цифр кратных 3, 5, 3 и 5.
    private static void print(String f, String s, String t, int frst, int scnd, int from, int to){
        System.out.println(PlaceHolder.replace(f, s, t, frst, scnd, from, to));
    }
}
