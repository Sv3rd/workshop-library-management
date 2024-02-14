package se.lexicon.librarymanagementapplication.dao;

import se.lexicon.librarymanagementapplication.entity.AppUser;
import se.lexicon.librarymanagementapplication.entity.Details;

import java.util.List;

public interface AppUserDAO {
    AppUser create(AppUser appUser);
    AppUser findById(int id);
    List<AppUser> findAll();
    AppUser update(AppUser appUser);
    void delete(AppUser appUser);
}
