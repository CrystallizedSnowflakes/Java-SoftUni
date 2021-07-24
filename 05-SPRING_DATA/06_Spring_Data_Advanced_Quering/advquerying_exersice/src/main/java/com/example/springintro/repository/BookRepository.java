package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lessThan, BigDecimal greaterThan);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findAllByTitleContaining(String containingString);

    List<Book> findAllByAuthor_LastNameStartsWith(String startingString);

    @Query("SELECT COUNT(b) FROM Book b WHERE length(b.title) > :symbols")
    int countOfBooksWithTitleLengthMoreThan(@Param(value = "symbols") int symbols);

    List<Book> findBookByTitle(String title);

    @Modifying
    @Query("UPDATE Book b SET b.copies = b.copies + :copies WHERE b.releaseDate > :givenDate")
    int updateCopiesByReleasedAfterGivenDate(@Param(value = "copies") int copies,
                                             @Param(value = "givenDate") LocalDate givenDate);

    int removeAllByCopiesLessThan(Integer copies);

    @Query(value = "CALL get_books_count_by_author_firstName_and_lastName(:firstName, :lastName)", nativeQuery = true)
    int getTotalAmountOfBooksByAuthorFirstNameAndLastName(@Param("firstName") String firstName,
                                                          @Param("lastName") String lastName);
}
