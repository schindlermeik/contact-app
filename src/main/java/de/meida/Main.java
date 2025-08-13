package de.meida;


import de.meida.app.ContactClient;
import de.meida.app.ContactRepository;
import de.meida.app.ContactRepositoryImpl;
import de.meida.app.ContactService;

public class Main {
    public static void main(String[] args) {

        ContactRepository contactRepository = new ContactRepositoryImpl();
        ContactService contactService = new ContactService(contactRepository);
        ContactClient contactClient = new ContactClient(contactService);

        contactClient.run();
    }
}