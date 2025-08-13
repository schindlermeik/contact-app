package de.meida.app;

import java.util.List;

public interface ContactRepository {

    void create(Contact contact);

    Contact findById(Long id);

    List<Contact> findAll();

    Contact update(Contact updatedContact);

    void delete(Long id);

}
