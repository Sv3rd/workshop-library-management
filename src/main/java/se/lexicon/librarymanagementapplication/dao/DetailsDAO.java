package se.lexicon.librarymanagementapplication.dao;

import se.lexicon.librarymanagementapplication.entity.Details;

import java.util.List;

public interface DetailsDAO {

    Details create(Details details);
    Details findById(int id);

    List<Details> findAll();

    Details update(Details details);

    void delete(Details details);

}
