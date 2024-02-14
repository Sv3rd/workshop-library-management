package se.lexicon.librarymanagementapplication.dao;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import se.lexicon.librarymanagementapplication.entity.AppUser;
import se.lexicon.librarymanagementapplication.entity.Details;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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


}
