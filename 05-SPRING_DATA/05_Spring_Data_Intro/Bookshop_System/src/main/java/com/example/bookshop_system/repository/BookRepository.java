package com.example.bookshop_system.repository;

import com.example.bookshop_system.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    /*
    SELECT b FROM Book b
    WHERE b.author.first_name = '...' AND b.author.last_name = '...'
    ORDER BY b.release_date DESC, b.title;
    */
    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);
}
