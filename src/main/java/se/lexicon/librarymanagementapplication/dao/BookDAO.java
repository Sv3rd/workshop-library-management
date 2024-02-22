package se.lexicon.librarymanagementapplication.dao;

import se.lexicon.librarymanagementapplication.entity.Author;
import se.lexicon.librarymanagementapplication.entity.Book;

import java.util.Collection;

public interface BookDAO {

    Book create(Book book);
    Book findById(int id);
    Collection<Book> findAll();
    Book update(Book book);
    void delete(Book book);
}
