package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBooksAuthorsWithAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllGoldenBookTitlesWithCopiesLessThan5000();

    List<String> findAllBookTitlesWithPriceLessThan5OrMoreThan40();

    List<String> findAllBookTitlesNotReleasedInYear(int year);

    List<String> findAllBooksBeforeLocalDate(LocalDate localDate);

    List<String> findAllByTitleContainingString(String containingStr);

    List<String> findAllByAuthorsLastNameStartingWithStr(String startingWithStr);

    int findCountOfBooksWithTitleLengthLongerThan(int symbols);

    List<String> findBookInfoByTitle(String bookTitle);

    int increaseCopiesByDate(int copies, LocalDate localDate);

    int removeBooksWithLowerCopiesThan(int copies);

    int findTotalAmountOfBooksByAuthor(String firstName, String lastName);
}
