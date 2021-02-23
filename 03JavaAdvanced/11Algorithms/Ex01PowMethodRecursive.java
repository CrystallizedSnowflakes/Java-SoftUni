package bg.softuni.javaadvanced;

public class Ex01PowMethodRecursive {
    public static void main(String[] args) {
        long num = 10;
        for (int i = 1; i < 4; i++) {
            num *= 10;
        }
        // 10 * 10 * 10 * 10 = 10000

        System.out.println(num);
        System.out.println(Math.pow(10, 4));
        System.out.println(pow(10, 4));
    }

    // recursion
    public static long pow(long num, int power){
        if (power == 1){
            return num; // first power 1 is the num 10
        }
        return  num * pow(num, power - 1); // num * previous power
        // 10^4 = 10 * 10^3 (1000) = 10000
        // 10^3 = 10 * 10^2 (100)  = 1000
        // 10^2 = 10 * 10^1 (10)   = 100
    }
}
