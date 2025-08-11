package de.meida;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {
 

    private List<Contact> contacts;
    private static Long nextId = 1L;

    public ContactManager() {
        this.contacts = new ArrayList<>();
        System.out.println("INFO: Contact Manager wurde initialisiert");
    }
    
    public void createContact(Contact contact){
        createAndAdd(contact);
        saveToFile(); // KontextAktion ALT+Enter
        System.out.println("INFO: Neuer Kontakt hinzugefügt " + contact.getName());
    }

    public Contact findById(Long id){
        System.out.println("INFO: Suche nach kontakt mit ID: " + id);
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                return contact;
            }
        }
        System.out.println("WARN: Kontakt mit ID: " + id + " nicht gefunden");
        return null;
    }

    private void createAndAdd(Contact contact) {
        contact.setId(nextId++);
        contacts.add(contact);
    }



    private void saveToFile() {
        //TODO
    }


}
