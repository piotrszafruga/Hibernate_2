package pl.coderslab.dzien2.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.dzien2.dao.AuthorDao;
import pl.coderslab.dzien2.model.Author;

@Component
public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String s) {
        return authorDao.findById(Long.parseLong(s));
    }

}
