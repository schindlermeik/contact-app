package de.meida.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContactClient {

    private static final Logger logger = LoggerFactory.getLogger(ContactClient.class);

    private final ContactService contactService;

    public ContactClient(ContactService contactService) {
        this.contactService = contactService;
    }

    public void run() {
        logger.info(" --- Anwendung gestartet ---");


        try {
            logger.info(" --- Zwei neue Kontakte erstellen ---");
            contactService.createContact(new Contact("Max Mustermann", "max@example.com", "123-456-789"));
            contactService.createContact(new Contact("Erika Musterfrau", "erika@example.com", "987-654-321"));

            logger.info("Suche nach Kontakten");
            logger.info("Kontakt: {}", contactService.getById(1L));
            logger.info("Kontakt: {}", contactService.getById(3L));
        } catch (ContactNotSaveException | ContactNotFoundException e) {
            logger.error(" es ist was schief gelaufen", e);
        } catch (Exception e) {
            logger.error(" irgendwas ist aufgetreten", e);
        }
        logger.info(" --- Anwendung beendet ---");

    }
}