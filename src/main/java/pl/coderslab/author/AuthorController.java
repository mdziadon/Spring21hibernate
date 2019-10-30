package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/list")
    public String getAuthors(Model model) {
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        return "authorList";
    }

    @GetMapping("/add")
    public String addAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "author";
    }

    @PostMapping("/add")
    public String addAuthor(@Valid @ModelAttribute Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author";
        }
        authorService.save(author);
        return "redirect:list";
    }

    @GetMapping("/update/{id}")
    public String updateAuthor(@PathVariable Long id, Model model) {
        Author author = authorService.findOne(id);
        model.addAttribute("author", author);
        return "author";
    }

    @PostMapping("/update/{id}")
    public String updateAuthor(@Valid @ModelAttribute Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author";
        }
        authorService.update(author);
        return "redirect:../list";
    }


    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
        return "redirect:../list";
    }
}
