package pl.coderslab.book;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void update(Book book) {
        bookRepository.save(book);
    }

    public Book findOne(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book findBookWithAuthors(Long id) {
        Book book = findOne(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findAllPropositions() {
        return bookRepository.findByPropositionTrue();
    }

    public List<Book> getRatingList(int rating) {
        return bookRepository.findByRating(rating);
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> getBooksByCategoryId(Long categoryId){
        return bookRepository.findByCategoryId(categoryId);
    }

    public List<Book> getBooksByAuthorId(Long authorId) {
        return bookRepository.findByAuthorsId(authorId);
    }

    public List<Book> getBooksByByPublisherId(Long publisherId) {
        return bookRepository.findByPublisherId(publisherId);
    }

    public Book getFirstBookByCategoryId(Long categoryId) {
        return bookRepository.findFirstByCategoryIdOrderByTitle(categoryId);
    }
}
