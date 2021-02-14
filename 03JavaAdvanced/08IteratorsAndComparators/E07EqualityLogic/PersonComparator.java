package E07EqualityLogic;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int result = p1.getName().length() - p2.getName().length();
        //int result = Integer.compare(p1.getName().length(), p2.getName().length());

        if (result == 0){
            char p1FirstLetter = p1.getName().toLowerCase().charAt(0);
            char p2FirstLetter = p2.getName().toLowerCase().charAt(0);
            result = p1FirstLetter - p2FirstLetter;
        }
        return result;
    }
}
