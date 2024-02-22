package se.lexicon.librarymanagementapplication.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import se.lexicon.librarymanagementapplication.entity.Book;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDAO {

    @PersistenceContext
    EntityManager entityManager;

    public Book create(Book book) {
        entityManager.persist(book);
        return book;
    }

    public Book findById(int id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> findAll(){
        return entityManager.createQuery("select book from Book book", Book.class)
                .getResultList();
    }

    public Book update(Book book){
        return entityManager.merge(book);
    }

    public void delete(Book book){
        entityManager.remove(book);
    }

}
