package se.lexicon.librarymanagementapplication.dao;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import se.lexicon.librarymanagementapplication.entity.Author;
import se.lexicon.librarymanagementapplication.entity.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@Rollback
public class BookDaoTest {

    @Autowired
    AuthorDAO authorDAO;

    @Autowired
    BookDAO bookDAO;

    @Test
    public void test_AddAuthor(){
        Book book = new Book("ABC", "Rhymes Book", 15);
        Author author = new Author("Maik", "Bahko");
        book.addAuthor(author);
        bookDAO.create(book);
        assertEquals(1, book.getAuthors().size());
        assertTrue(author.getWrittenBooks().contains(book));
    }


}
