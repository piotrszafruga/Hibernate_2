package pl.coderslab.dzien2.controller;

import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dzien2.model.Person;
import pl.coderslab.dzien2.model.Student;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {


    @GetMapping("/student")
    public String prepareStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student";
    }


    @PostMapping("/student")
    public String processForm(@ModelAttribute Student student, Model model) {
        System.out.println(student.toString());
        model.addAttribute("student", student);
        model.addAttribute("string", student.toString());
        return "studentReturn";
    }


    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("skills")
    public List<String> skills() {
        return Arrays.asList("C/C++/C#", "Java", "Magic", "Php", "Python", "Ruby");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Board games", "Bridge", "Gliding", "Hiking", "Rugby", "Running", "Swimming");
    }

}
