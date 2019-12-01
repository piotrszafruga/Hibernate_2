package pl.coderslab.dzien2.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.dzien2.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Person entity) {
        entityManager.persist(entity);
    }




}
