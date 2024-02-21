package se.lexicon.librarymanagementapplication.dao;

import se.lexicon.librarymanagementapplication.entity.Author;

import java.util.Collection;

public interface AuthorDAO {
    Author create(Author author);
    Author findById(int id);
    Collection<Author> findAll();
    Author update(Author author);
    void delete(Author author);
}
