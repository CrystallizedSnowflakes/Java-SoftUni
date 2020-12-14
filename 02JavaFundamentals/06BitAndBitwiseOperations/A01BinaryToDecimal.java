package bg.softuni.javafundamentals;

public class A01BinaryToDecimal {
    public static void main(String[] args) {

        String num = "1000111"; // 71
        // 1*2^6 + 0*2^5 + 0*2^4 + 0*2^3 + 1*2^2 + 1*2^1 + 1*2^0
        // 1*64  + 0*32  + 0*16  + 0*8   + 1*4   + 1*2   + 1*1
        // 64    + 0     + 0     + 0     + 4     + 2     + 1
        // 71

        int sum = 0;
        int magnitude = 1;

        for (int i = num.length() - 1; i >= 0 ; i--) {
            int digit = Integer.parseInt(String.valueOf(num.charAt(i)));
            sum = sum + digit * magnitude;
            magnitude = magnitude * 2;
        }
        System.out.println(sum);
    }
}
