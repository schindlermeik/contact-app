package de.meida.app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {

    private final List<Contact> contacts;
    public static Long nextId = 1L;

    public ContactRepositoryImpl() {
        contacts = new ArrayList<>();
    }

    @Override
    public void create(Contact contact) {
        if(contact.getId() != null) {
            throw new ConstraintViolationException("Id existiert in der Datenbank " + contact.getId());
        }
        createAndAdd(contact);
        saveToFile(); //
    }

    @Override
    public Contact findById(Long id) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> findAll() {
        return List.of();
    }

    @Override
    public Contact update(Contact updatedContact) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    private void createAndAdd(Contact contact) {
        contact.setId(nextId++);
        contacts.add(contact);
    }


    private void saveToFile() {

        try (FileWriter writer = new FileWriter("contacts.csv")) {
            writer.write("ID,NAME,EMAIL,PHONE\n");
            for (Contact contact : contacts) {
                writer.write(String.format("%s,%s,%s,%s%n", contact.getId(), contact.getName(), contact.getEmail(), contact.getPhone()));
            }

        } catch (IOException e) {
            throw new ContactNotSaveException("Contact, konnte nicht gespeichert werden", e);
        }
    }
}
