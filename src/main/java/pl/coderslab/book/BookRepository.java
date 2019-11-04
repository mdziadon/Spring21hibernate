package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByPropositionTrue();

    List<Book> findByPropositionFalse();

    List<Book> findByRating(int rating);

    List<Book> findByTitle(String title);

    List<Book> findByCategoryId(Long categoryId);

    List<Book> findByAuthorsId(Long authorId);

    List<Book> findByPublisherId(Long publisherId);

    Book findFirstByCategoryIdOrderByTitle(Long categoryId);
}