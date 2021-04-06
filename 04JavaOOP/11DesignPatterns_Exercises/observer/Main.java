package observer;

public class Main {
    /** Observer Behavioral Design Pattern

     https://en.wikipedia.org/wiki/Observer_pattern

     The observer pattern is a software design pattern in which an object, named the subject,
     maintains a list of its dependents, called observers,
     and notifies them automatically of any state changes,
     usually by calling one of their methods. */

    public static void main(String[] args) {

        ISubject site = new Subject();

        IObserver pepi = new Observer();
        IObserver lili = new Observer();

        site.registerObserver(pepi);
        site.registerObserver(lili);

        site.changeState("NEW STATE");

        site.removeObserver(lili);
    }
}
