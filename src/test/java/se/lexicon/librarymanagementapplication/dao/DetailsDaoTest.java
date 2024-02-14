package se.lexicon.librarymanagementapplication.dao;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import se.lexicon.librarymanagementapplication.entity.Details;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
public class DetailsDaoTest {

    @Autowired
    DetailsDAO detailsDAO;

    @Test
    public void test_PersistDetails(){
        Details details = new Details("test.t@se.com", "test", LocalDate.parse("1990-07-11"));
        Details details1 = detailsDAO.create(details);
        assertNotNull(details1);
    }

    @Test
    public void test_FindAll() {
        Details details = new Details("test.t@se.com", "test", LocalDate.parse("1990-07-11"));
        detailsDAO.create(details);
        Details details1 = new Details("test.t1@se.com", "test1", LocalDate.parse("1992-02-23"));
        detailsDAO.create(details1);
        List<Details> detailsList = detailsDAO.findAll();
        assertEquals(detailsList.size(), 2);
    }

    @Test
    public void test_FindById() {
        Details details = new Details("test.t@se.com", "test", LocalDate.parse("1990-07-11"));
        detailsDAO.create(details);
        List<Details> detailsList = detailsDAO.findAll();
        Details details1 = detailsDAO.findById(detailsList.get(0).getDetailsId());
        assertNotNull(details1);
    }

    @Test
    public void test_updateDetails() {
        Details details = new Details("test.t@se.com", "test", LocalDate.parse("1990-07-11"));
        detailsDAO.create(details);
        details.setEmail("testupdate.t@se.com");
        Details details1 = detailsDAO.update(details);
        assertNotNull(details1);
        assertEquals("testupdate.t@se.com", details1.getEmail());
    }

    @Test
    public void test_deleteDetails() {
        Details details = new Details("test.t@se.com", "test", LocalDate.parse("1990-07-11"));
        Details details1 = detailsDAO.create(details);
        detailsDAO.delete(details);
        System.out.println(details1.getDetailsId());
        Details details2 = detailsDAO.findById(details1.getDetailsId());
        assertNull(details2);
    }

}
