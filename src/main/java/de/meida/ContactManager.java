package de.meida;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
  // int -> Integer

    private List<Contact> contacts;
    private static Long nextId = 1L;

    public ContactManager() {
        this.contacts = new ArrayList<>();
        System.out.println("INFO: Contact Manager wurde initialisiert");
    }

    public void createContact(Contact contact) {
        // name == null oder "" => InalidContactException
        // email.com, emael@test, = IllgalArgumentException
        createAndAdd(contact);
        saveToFile(); // KontextAktion ALT+Enter
        System.out.println("INFO: Neuer Kontakt hinzugefügt " + contact.getName());
    }

    public Contact findById(Long id){
        //IllegalArgumentException
        System.out.println("INFO: Suche nach kontakt mit ID: " + id);
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                return contact;
            }
        }
        System.out.println("WARN: Kontakt mit ID: " + id + " nicht gefunden");
        return null; //ContactNotFound
    }

    private void createAndAdd(Contact contact) {
        contact.setId(nextId++);
        contacts.add(contact);
    }


    private void saveToFile() {

        try {
            FileWriter writer = new FileWriter("contacts.csv");
        } catch (IOException e) {
            throw new ContactNotSaveException("Contact, konnte nicht gespeichert werden", e);
        }
    }

}
