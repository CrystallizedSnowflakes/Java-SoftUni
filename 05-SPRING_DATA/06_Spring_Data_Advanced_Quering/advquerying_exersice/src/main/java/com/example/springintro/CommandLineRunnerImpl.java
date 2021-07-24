package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

/*        printAllBooksAfterYear(2000);
        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        printAllAuthorsAndNumberOfTheirBooks();
        printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");*/

        System.out.println("Please enter exercise: ");
        int exNum = Integer.parseInt(bufferedReader.readLine());
        switch (exNum){
            case 1 -> booksTitlesByAgeRestrictions();
            case 2 -> goldenBooks();
            case 3 -> booksByPrice();
            case 4 -> notReleasedBooks();
            case 5 -> booksReleasedBeforeDate();
            case 6 -> authorsSearch();
            case 7 -> booksSearch();
            case 8 -> bookTitlesSearch();
            case 9 -> countBooks();
            case 10 -> totalBookCopies();
            case 11 -> reducedBook();
            case 12 -> increaseBookCopies();
            case 13 -> removeBooks();
            case 14 -> findTotalBooksByAuthor();
        }
    }

    private void findTotalBooksByAuthor() throws IOException {
        System.out.println("Please Enter Author FirstName and SecondName:");
        String[] names = bufferedReader.readLine().split("\\s+");
        String firstName = names[0];
        String lastName = names[1];
        System.out.printf("%s %s has written %d books%n",
                firstName,
                lastName,
                bookService.findTotalAmountOfBooksByAuthor(firstName, lastName));
    }

    private void removeBooks() throws IOException {
        System.out.println("Please Enter number of copies");
        int copies = Integer.parseInt(bufferedReader.readLine());
        System.out.printf("%d books were deleted%n", bookService
                .removeBooksWithLowerCopiesThan(copies));
    }

    private void increaseBookCopies() throws IOException {
        System.out.println("Please Enter Date in format dd MMM yyyy");
        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd MMM yyyy"));
        System.out.println("Please enter number of copies");
        int copies = Integer.parseInt(bufferedReader.readLine());
        System.out.println(bookService
                .increaseCopiesByDate(copies, localDate));
    }
    
    private void reducedBook() throws IOException {
        System.out.println("Please Enter Book Title:");
        String bookTitle = bufferedReader.readLine();
        bookService.findBookInfoByTitle(bookTitle)
                    .forEach(System.out::println);
    }

    private void totalBookCopies() {
        authorService
                .findAllAuthorsAndTheirTotalCopies()
                .forEach(System.out::println);
    }

    private void countBooks() throws IOException {
        System.out.println("Please Enter Title Symbols:");
        int symbols = Integer.parseInt(bufferedReader.readLine());

        System.out.println(bookService
                .findCountOfBooksWithTitleLengthLongerThan(symbols));
    }

    private void bookTitlesSearch() throws IOException {
        System.out.println("Please Enter start string");
        String startingWithStr = bufferedReader.readLine();
        bookService
                .findAllByAuthorsLastNameStartingWithStr(startingWithStr)
                .forEach(System.out::println);
    }

    private void booksSearch() throws IOException {
        System.out.println("Please Enter containing string");
        String containingStr = bufferedReader.readLine();
        bookService
                .findAllByTitleContainingString(containingStr)
                .forEach(System.out::println);
    }

    private void authorsSearch() throws IOException {
        System.out.println("Please Enter end string");
        String endStr = bufferedReader.readLine();
        authorService
                .findAllByFirstNameEndsWithStr(endStr)
                .forEach(System.out::println);
    }

    private void booksReleasedBeforeDate() throws IOException {
        System.out.println("Please Enter a Date in the format dd-MM-yyyy:");
        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        bookService.findAllBooksBeforeLocalDate(localDate)
                .forEach(System.out::println);
    }

    private void notReleasedBooks() throws IOException {
        System.out.println("Please enter a year:");
        int year = Integer.parseInt(bufferedReader.readLine());
        bookService.findAllBookTitlesNotReleasedInYear(year)
                .forEach(System.out::println);
    }

    private void booksByPrice() {
        bookService.findAllBookTitlesWithPriceLessThan5OrMoreThan40()
                .forEach(System.out::println);
    }

    private void goldenBooks() {
        bookService.findAllGoldenBookTitlesWithCopiesLessThan5000()
                    .forEach(System.out::println);
    }

    private void booksTitlesByAgeRestrictions() throws IOException {
        System.out.println("Please Enter Age Restriction");
        AgeRestriction ageRestriction = AgeRestriction.valueOf(bufferedReader.readLine().toUpperCase());
        bookService
                .findAllBooksAuthorsWithAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
