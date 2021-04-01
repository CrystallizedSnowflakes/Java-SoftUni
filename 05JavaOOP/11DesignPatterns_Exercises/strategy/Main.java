package strategy;

public class Main {
    /** Strategy Behavioral Design Pattern

     https://en.wikipedia.org/wiki/Strategy_pattern

     Strategy is a behavioral design pattern that lets you define a family of algorithms,
     put each of them into a separate class, and make their objects interchangeable. */

     public static void main(String[] args) {

        Context context = new Context(new StrategyAdd());
        System.out.println(context.executeStrategy(5, 4));

        context = new Context(new StrategySubtract());
        System.out.println(context.executeStrategy(5, 4));

        context = new Context(new StrategyMultiply());
        System.out.println(context.executeStrategy(5, 4));
    }
}
