package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByPropositionTrue();

    List<Book> findByPropositionFalse();

    List<Book> findByRating(int rating);

    @Query("select b from Book b where b.rating between ?1 and ?2")
    List<Book> findByRatingBetweenQuery(int ratingFrom, int ratingTo);

    List<Book> findByTitle(String title);

    @Query("select b from Book b where b.title = ?1")
    List<Book> findByTitleQuery(String title);

    List<Book> findByCategoryId(Long categoryId);

    @Query("select b from Book b where b.category.id = :categoryId")
    List<Book> findByCategoryIdQuery(@Param("categoryId") Long categoryId);

    List<Book> findByAuthorsId(Long authorId);

    List<Book> findByPublisherId(Long publisherId);

    @Query("select b from Book b where b.publisher.id = ?1")
    List<Book> findByPublisherIdQuery(Long publisherId);

    Book findFirstByCategoryIdOrderByTitle(Long categoryId);

    @Query(value = "select * from books where category_id = ?1 order by title limit 1", nativeQuery = true)
    Book findFirstByCategoryIdOrderByTitleQuery(Long categoryId);



}
