package se.lexicon.librarymanagementapplication.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.lexicon.librarymanagementapplication.entity.AppUser;

import java.util.List;

@Repository
public class AppUserDaoImpl implements AppUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public AppUser create(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    public AppUser findById(int id) {
        return entityManager.find(AppUser.class, id);
    }

    @Override
    public List<AppUser> findAll() {
        return entityManager.createQuery("select user from AppUser user", AppUser.class)
                .getResultList();
    }

    @Override
    @Transactional
    public AppUser update(AppUser appUser) {
        return entityManager.merge(appUser);
    }

    @Override
    @Transactional
    public void delete(AppUser appUser) {
        entityManager.remove(appUser);
    }
}
