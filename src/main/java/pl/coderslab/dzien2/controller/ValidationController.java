package pl.coderslab.dzien2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dzien2.model.Author;
import pl.coderslab.dzien2.model.Book;
import pl.coderslab.dzien2.validator.ValidatorGroupOne;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class ValidationController {

    private final Logger log = LoggerFactory.getLogger(ValidationController.class);

    @Autowired
    private Validator validator;

    @GetMapping("/validator")
    @ResponseBody
    public String validateBook() {
        Book b = new Book();
        Set<ConstraintViolation<Book>> result = validator.validate(b);
        return result.stream()
                .map(this::buildMessage)
                .collect(Collectors.joining("<br/>"));
    }

    private String buildMessageBook(ConstraintViolation<Book> constraintViolation) {
        return constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage();
    }
    private String buildMessage(ConstraintViolation constraintViolation) {
        return constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage();
    }


    @GetMapping("/validatorView")
    public String validateBookView(Model model) {
        Book book = new Book();
        book.setTitle("erwder");
        book.setProposition(false);
        Set<ConstraintViolation<Book>> result = validator.validate(book, ValidatorGroupOne.class);
        model.addAttribute("validations", result.stream()
                .map(this::buildMessage)
                .map(m -> m + "<br/>")
                .collect(Collectors.toList()));
        return "/validator";
    }


    //AUTHOR:
    @GetMapping("/validator/author")
    @ResponseBody
    public String validateAuthor() {
        Author author = new Author();
        author.setYearOfBirth(2010);
        author.setPesel("2wefd23");
        author.setEmail("dfs4few");
        Set<ConstraintViolation<Author>> result = validator.validate(author);
        result.stream()
                .map(this::buildMessage)
                .forEach(log::info);

        return result.stream()
                .map(this::buildMessage)
                .collect(Collectors.joining("<br/>"));

    }








}
