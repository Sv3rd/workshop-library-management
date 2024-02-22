package se.lexicon.librarymanagementapplication.dao;

import se.lexicon.librarymanagementapplication.entity.Book;
import se.lexicon.librarymanagementapplication.entity.BookLoan;

import java.util.Collection;

public interface BookLoanDAO {
    BookLoan create(BookLoan bookLoan);
    BookLoan findById(int id);
    Collection<BookLoan> findAll();
    BookLoan update(BookLoan bookLoan);
    void delete(BookLoan bookLoan);
}
