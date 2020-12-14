package bg.softuni.javafundamentals;

public class A02DecimalToBinary {
    public static void main(String[] args) {
        int num = 71;
        // 71 / 2 = 35 (1) last digit
        // 35 / 2 = 17 (1)
        // 17 / 2 = 8  (1)
        //  8 / 2 = 4  (0)
        //  4 / 2 = 2  (0)
        //  2 / 2 = 1  (0)
        //  1 / 2 = 0  (1) first digit

        // 1 0 0 0 1 1 1
        String result = "";
        // divide to the base (2) until 0 is reached
        while (num > 0){
            int lastDigit = num % 2;
            result += lastDigit + result; // last digit goes first + previous result
            num = num /2;
        }
        System.out.println(result + " ");
    }
}
