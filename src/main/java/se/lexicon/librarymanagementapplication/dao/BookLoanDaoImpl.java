package se.lexicon.librarymanagementapplication.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import se.lexicon.librarymanagementapplication.entity.Book;
import se.lexicon.librarymanagementapplication.entity.BookLoan;

import java.util.Collection;

@Repository
public class BookLoanDaoImpl implements BookLoanDAO {
    @PersistenceContext
    EntityManager entityManager;

    public BookLoan create(BookLoan bookLoan){
        entityManager.persist(bookLoan);
        return bookLoan;
    }

    public BookLoan findById(int id){
        return entityManager.find(BookLoan.class, id);
    }

    public Collection<BookLoan> findAll(){
        return entityManager.createQuery("select loan from BookLoan loan", BookLoan.class)
                .getResultList();
    }

    public BookLoan update(BookLoan bookLoan){
        return entityManager.merge(bookLoan);
    }

    public void delete(BookLoan bookLoan){
        entityManager.remove(bookLoan);
    }
}
