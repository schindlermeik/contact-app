package de.meida.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ContactService {

    private static final Logger logger = LoggerFactory.getLogger(ContactService.class);

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
        logger.info("Contact Service wurde initialisiert");
    }


    public void createContact(Contact contact) {

        if (contact == null || contact.getName() == null || contact.getName().trim().isEmpty()) {
            throw new InvalidContactException("Name darf nicht leer sein");
        }
        String email = contact.getEmail();
        if (email != null && (!email.contains("@") || !email.contains("."))) {
            throw new IllegalArgumentException("Email ist ungültig " + email);
        }
        contactRepository.create(contact);
        logger.info("INFO: Neuer Kontakt hinzugefügt {} {}", contact.getName(), contact.getEmail());
    }


    public Contact getById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id darf nicht null sein");
        }
        logger.info(" Suche nach kontakt mit ID: {}", id);
        if (contactRepository.findById(id) != null) {
            return contactRepository.findById(id);
        }
        logger.warn("Contact mit Id: {} wurde nicht gefunden", id);
        throw new ContactNotFoundException(String.format("Contact mit Id: %s wurde nicht gefunden", id)); //ContactNotFound
    }

}
