package bg.softuni.javaadvanced;

public class Ex03FactorialRecursive {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(factBackward(num));
    }

    // 5! = 5 * 4 * 3 * 2 * 1
    private static long factBackward(int num) {
        if (num == 1){
            return num;
        }
        return num * factBackward(num - 1);
    }
}
