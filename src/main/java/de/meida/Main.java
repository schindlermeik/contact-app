package de.meida;


import de.meida.app.*;

public class Main {
    public static void main(String[] args) {

        Repository<Contact, Long> repository = new RepositoryImpl<>();
        ContactService contactService = new ContactService(repository);
        ContactClient contactClient = new ContactClient(contactService);

        contactClient.run();
    }
}