package pl.coderslab.dzien2.model;

import pl.coderslab.dzien2.validator.ValidatorGroupOne;
import pl.coderslab.dzien2.validator.ValidatorGroupTwo;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 5, groups = ValidatorGroupOne.class)
    @Size(min = 5, groups = ValidatorGroupTwo.class)
    private String title;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Author> authorList = new ArrayList<>();

    @Min(value = 1, groups = ValidatorGroupTwo.class)
    @Max(value = 10, groups = ValidatorGroupTwo.class)
    private int rating;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    private Publisher publisher;

    @Size(max = 600, groups = ValidatorGroupTwo.class)
    private String description;

    @Min(value = 2, groups = ValidatorGroupTwo.class)
    private int pages;

    private boolean proposition;





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }
}
