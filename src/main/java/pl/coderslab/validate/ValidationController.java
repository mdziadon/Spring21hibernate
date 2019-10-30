package pl.coderslab.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.Author;
import pl.coderslab.book.Book;
import pl.coderslab.publisher.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/validation")
public class ValidationController {

    @Autowired
    private Validator validator;

    @GetMapping("/book")
    public String validateBook(Model model) {
        Book book = new Book();

        Set<ConstraintViolation<Book>> errors = validator.validate(book);
        List<FieldError> fieldErrors = new ArrayList<>();

        if (!errors.isEmpty()) {
            for (ConstraintViolation<Book> error : errors) {
                String path = error.getPropertyPath().toString();
                String message = error.getMessage();
                fieldErrors.add(new FieldError(path, message));
            }
        }
        model.addAttribute("errors", fieldErrors);
        return "errors";
    }

    @GetMapping("/author")
    public String validateAuthor(Model model) {
        Author author = new Author();
        author.setPesel("123");
        author.setEmail("asd@as");

        Set<ConstraintViolation<Author>> errors = validator.validate(author);
        List<FieldError> errorList = new ArrayList<>();

        if (!errors.isEmpty()) {
            for (ConstraintViolation<Author> error : errors) {
                String path = error.getPropertyPath().toString();
                String message = error.getMessage();
                errorList.add(new FieldError(path, message));
            }
        }

        model.addAttribute("errors", errorList);
        return "errors";
    }

    @GetMapping("/publisher")
    public String validatePublisher(Model model) {
        Publisher publisher = new Publisher();
        publisher.setNip("1234567890");

        Set<ConstraintViolation<Publisher>> errors = validator.validate(publisher);
        List<FieldError> errorList = new ArrayList<>();

        if (!errors.isEmpty()) {
            for (ConstraintViolation<Publisher> error : errors) {
                String path = error.getPropertyPath().toString();
                String message = error.getMessage();
                errorList.add(new FieldError(path, message));
            }
        }

        model.addAttribute("errors", errorList);
        return "errors";
    }
}
