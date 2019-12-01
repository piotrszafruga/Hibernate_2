package pl.coderslab.dzien2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.dzien2.dao.PersonDao;
import pl.coderslab.dzien2.model.Person;

@Controller
public class PersonController {

    @Autowired
    private PersonDao personDto;

    @GetMapping("/person")
    public String preparePerson(Model model) {
        model.addAttribute("person", new Person());
        return "form";
    }

    @PostMapping(value = "/person")
    public String savePerson(@ModelAttribute Person person) {
        personDto.persist(person);
        return "hello";
    }


}
