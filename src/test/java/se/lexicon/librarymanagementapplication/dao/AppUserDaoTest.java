package se.lexicon.librarymanagementapplication.dao;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import se.lexicon.librarymanagementapplication.entity.AppUser;
import se.lexicon.librarymanagementapplication.entity.BookLoan;
import se.lexicon.librarymanagementapplication.entity.Details;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
public class AppUserDaoTest {

    @Autowired
    AppUserDAO appUserDAO;


    @Test
    public void test_PersistAppUser() {
        Details details = new Details("test.t@se.com", "test", LocalDate.parse("1990-07-11"));
        AppUser appUser = new AppUser("test123","test@123", LocalDate.now(), details);
        AppUser appUser1 = appUserDAO.create(appUser);
        assertNotNull(appUser1);
    }

    @Test
    public void test_FindAll() {
        Details details = new Details("test.t@se.com", "test", LocalDate.parse("1990-07-11"));
        AppUser appUser = new AppUser("test123","test@123", LocalDate.now(), details);
        appUserDAO.create(appUser);
        List<AppUser> detailsList = appUserDAO.findAll();
        assertEquals(1, detailsList.size());
    }

    @Test
    public void test_FindById() {
        Details details = new Details("test.t@se.com", "test", LocalDate.parse("1990-07-11"));
        AppUser appUser = new AppUser("test123","test@123", LocalDate.now(), details);
        appUserDAO.create(appUser);
        List<AppUser> appUserList = appUserDAO.findAll();
        AppUser appUser2 = appUserDAO.findById(appUserList.get(0).getAppUserId());
        assertNotNull(appUser2);
    }

    @Test
    public void test_updateAppUser() {
        Details details = new Details("test.t@se.com", "test", LocalDate.parse("1990-07-11"));
        AppUser appUser = new AppUser("test123","test@123", LocalDate.now(), details);
        appUserDAO.create(appUser);
        details.setEmail("testupdate.t@se.com");
        AppUser appUser1 = appUserDAO.update(appUser);
        assertNotNull(appUser1);
        assertEquals("testupdate.t@se.com", appUser1.getDetails().getEmail());
    }

    @Test
    public void test_deleteAppUser() {
        Details details = new Details("test.t@se.com", "test", LocalDate.parse("1990-07-11"));
        AppUser appUser = new AppUser("test123","test@123", LocalDate.now(), details);
        appUserDAO.create(appUser);
        appUserDAO.delete(appUser);
        System.out.println(appUser.getAppUserId());
        AppUser appUser1 = appUserDAO.findById(appUser.getAppUserId());
        assertNull(appUser1);
    }

    @Test
    public void testAddBookLoan(){
        Details details = new Details("test.t@se.com", "test", LocalDate.parse("1990-07-11"));
        AppUser appUser = new AppUser("test123","test@123", LocalDate.now(), details);
        appUserDAO.create(appUser);
        BookLoan loan = new BookLoan(LocalDate.now(), LocalDate.parse("2024-02-27"), false);
        appUser.addBookLoan(loan);
        assertEquals(1,appUser.getLoans().size());
    }



}
