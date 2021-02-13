package BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book first, Book second) {
ic int compare(Book f, Book s) {
        int result = f.getTitle().compareTo(s.getTitle());
        return result != 0
                ? result
                : Integer.compare(s.getYear(), f.getYear());
    }
}
