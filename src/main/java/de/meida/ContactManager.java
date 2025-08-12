package de.meida;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ContactManager {

    private static final Logger logger = LoggerFactory.getLogger(ContactManager.class);

    private List<Contact> contacts;
    private static Long nextId = 1L;

    public ContactManager() {
        this.contacts = new ArrayList<>();
        logger.info("Contact Manager wurde initialisiert");
    }

    public void createContact(Contact contact) {

        if (contact == null || contact.getName() == null || contact.getName().trim().isEmpty()) {
            throw new InvalidContactException("Name darf nicht leer sein");
        }
        String email = contact.getEmail();
        if (email != null && (!email.contains("@") || email.contains("."))) {
            throw new IllegalArgumentException("Email ist ungültig " + email);
        }
        createAndAdd(contact);
        saveToFile(); // KontextAktion ALT+Enter
        logger.info("INFO: Neuer Kontakt hinzugefügt {} {}",  contact.getName(), contact.getEmail());
    }

    public Contact findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id darf nicht null sein");
        }
       logger.info(" Suche nach kontakt mit ID: {}", id);
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                return contact;
            }
        }
        logger.warn("Contact mit Id: {} wurde nicht gefunden", id);
        throw new ContactNotSaveException(String.format("Contact mit Id: %s wurde nicht gefunden", id)); //ContactNotFound
    }

    private void createAndAdd(Contact contact) {
        contact.setId(nextId++);
        contacts.add(contact);
    }


    private void saveToFile() {

        try (FileWriter writer = new FileWriter("contacts.csv")) {
            writer.write("ID,NAME,EMAIL,PHONE");
            for (Contact contact : contacts) {
                writer.write(String.format("%s,%s,%s,%s%n", contact.getId(), contact.getName(), contact.getEmail(), contact.getPhone()));
            }

        } catch (IOException e) {
            throw new ContactNotSaveException("Contact, konnte nicht gespeichert werden", e);
        }
    }
    
}
