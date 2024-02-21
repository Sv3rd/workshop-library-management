package se.lexicon.librarymanagementapplication.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import se.lexicon.librarymanagementapplication.entity.Author;

import java.util.Collection;

@Repository
public class AuthorDaoImpl implements AuthorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Author create(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Override
    public Author findById(int id) {
        return entityManager.find(Author.class, id);
    }
    @Override
    public Collection<Author> findAll() {
        return entityManager.createQuery("select author from Author author", Author.class)
            .getResultList();
    }

    @Override
    public Author update(Author author){
        return entityManager.merge(author);
    }

    @Override
    public void delete(Author author){
        entityManager.remove(author);
    }
}
