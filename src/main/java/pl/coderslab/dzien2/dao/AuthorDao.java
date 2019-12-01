package pl.coderslab.dzien2.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.dzien2.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveAuthor(Author entity) {
        entityManager.merge(entity);
    }

    public void editAuthor(Author entity) {
        if (entityManager.contains(entity)) {
            entityManager.merge(entity);
        }
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public List<Author> findAll() {
        Query query = entityManager.createQuery("select p from Author p");
        return query.getResultList();
    }

    public void deleteAuthor(long id) {
        entityManager.remove(findById(id));
    }
}
