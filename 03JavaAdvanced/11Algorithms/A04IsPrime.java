package bg.softuni.javaadvanced;

public class A04IsPrime {
    public static void main(String[] args) {
        int[] numbers = new int[]{0,1,2,3,5,9,13,17,19,21,33,69,100};

        for (int number : numbers) {
            if (isPrime(number)) {
                System.out.println(number + " is Prime");
            } else {
                System.out.println(number + " is NOT prime");
            }
        }
    }

    private static boolean isPrime(int number) { // 20=2*10, 4*5 ... 5*4, 10*2 => Math.sqrt(number)
        boolean primeCheck = true;
        if (number == 0 || number == 1) {
            primeCheck = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    primeCheck = false;
                }
            }
        }
        return primeCheck;
    }
}
