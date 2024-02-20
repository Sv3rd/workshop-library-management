package se.lexicon.librarymanagementapplication.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.librarymanagementapplication.entity.BookLoan;

@Repository
public interface BookLoanDAO extends CrudRepository<BookLoan, Integer> {
}
