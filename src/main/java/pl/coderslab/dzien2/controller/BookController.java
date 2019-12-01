package pl.coderslab.dzien2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dzien2.dao.AuthorDao;
import pl.coderslab.dzien2.dao.BookDao;
import pl.coderslab.dzien2.dao.PublisherDao;
import pl.coderslab.dzien2.model.Author;
import pl.coderslab.dzien2.model.Book;
import pl.coderslab.dzien2.model.Container;
import pl.coderslab.dzien2.model.Publisher;
import pl.coderslab.dzien2.validator.ValidatorGroupOne;
import pl.coderslab.dzien2.validator.ValidatorGroupTwo;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private PublisherDao publisherDao;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private Validator validator;

    @ModelAttribute("publishers")
    public List<Publisher> getAllPublishers() {
        return publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> getAllAuthors() {
        return authorDao.findAll();
    }

    @GetMapping("/add")
    public String prepareBook(Model model) {
        model.addAttribute("book", new Book());
        return "/book/add";
    }

    @PostMapping("/add")
    public String persist(@ModelAttribute Book book, BindingResult bindingResult) {
        Set<ConstraintViolation<Book>> result;

        if (book.isProposition()) {
            result = validator.validate(book, ValidatorGroupOne.class);
        } else {
            result = validator.validate(book, ValidatorGroupTwo.class);
        }

        if (!result.isEmpty()) {
            return "/book/add";
        }

//        if (bindingResult.hasErrors()) {
//            return "/book/add";
//        }

        book.getAuthorList()
            .forEach(a -> a.getBookList().add(book));
        bookDao.saveBook(book);
        return "redirect:/book/all";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("allBooks", bookDao.findAll());
        model.addAttribute("container", new Container());
        return "/book/all";
    }

    @PostMapping("/all")
    public String deleteBook(@ModelAttribute Container container) {
        bookDao.deleteBook(bookDao.findById(container.getId()));
        return "redirect:/book/all";
    }

    @GetMapping("/book/edit/{id}")
    public String prepareEditBook(Model model, @PathVariable String id) {
        model.addAttribute("book", new Book());
        return "/book/edit";
    }


}
