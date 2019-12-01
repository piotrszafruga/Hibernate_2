package pl.coderslab.dzien2.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.dzien2.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public void savePublisher(Publisher entity) {
        entityManager.merge(entity);
    }

    public void editPublisher(Publisher entity) {
        if (entityManager.contains(entity)) {
            entityManager.merge(entity);
        }
    }

    public Publisher findById(long id) {
        //
        return entityManager.find(Publisher.class, id);
    }

    public List<Publisher> findAll() {
        //
        Query query = entityManager.createQuery("select p from Publisher p");
        return query.getResultList();
    }

    public void deletePublisher(Publisher entity) {
        //
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }
}
