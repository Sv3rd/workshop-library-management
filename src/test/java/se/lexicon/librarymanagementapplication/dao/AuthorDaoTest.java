package se.lexicon.librarymanagementapplication.dao;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import se.lexicon.librarymanagementapplication.entity.AppUser;
import se.lexicon.librarymanagementapplication.entity.Author;
import se.lexicon.librarymanagementapplication.entity.Book;
import se.lexicon.librarymanagementapplication.entity.Details;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
public class AuthorDaoTest {
    @Autowired
    AuthorDAO authorDAO;

    @Test
    public void test_PersistAuthor() {
        Author author = new Author("Maik", "Bahko");
        authorDAO.create(author);
        assertNotNull(author);
    }

    @Test
    public void test_FindAll() {
        Author author = new Author("Maik", "Bahko");
        authorDAO.create(author);
        Author author1 = new Author("Sathya", "S");
        authorDAO.create(author1);
        assertEquals(2, authorDAO.findAll().size());
    }

    @Test
    public void test_FindById() {
        Author author = new Author("Maik", "Bahko");
        authorDAO.create(author);
        Author author1 = authorDAO.findById(author.getAuthorId());
        assertNotNull(author1);
    }

    @Test
    public void test_updateAuthor() {
        Author author = new Author("Maik", "Bahko");
        authorDAO.create(author);
        author.setLastName("B");
        assertNotNull(author);
        assertEquals("B", author.getLastName());
    }

    @Test
    public void test_deleteAuthor() {
        Author author = new Author("Maik", "Bahko");
        authorDAO.create(author);
        authorDAO.delete(author);
        Author author1 = authorDAO.findById(author.getAuthorId());
        assertNull(author1);
    }

}
