package se.lexicon.librarymanagementapplication.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.lexicon.librarymanagementapplication.entity.Details;

import java.util.List;

@Repository
public class DetailsDaoImpl implements  DetailsDAO {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public Details create(Details details) {
        entityManager.persist(details);
        return  details;
    }

    @Override
    public Details findById(int id) {
        return entityManager.find(Details.class, id);
    }

    @Override
    public List<Details> findAll() {
        return entityManager.createQuery("select details from Details details", Details.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Details update(Details details) {
        return entityManager.merge(details);
    }

    @Override
    @Transactional
    public void delete(Details details) {
      entityManager.remove(details);
    }
}
