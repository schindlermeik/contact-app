package de.meida;


public class Main {
    public static void main(String[] args) {
        System.out.println("INFO: --- Anwendung gestartet ---");

        ContactManager contactManager = new ContactManager();

        System.out.println("INFO: --- Zwei neue Kontakte erstellen ---");
        contactManager.createContact(new Contact("Max Mustermann", "max@example.com", "123-456-789"));
        contactManager.createContact(new Contact("Erika Musterfrau", "erika@example.com", "987-654-321"));

        System.out.println("INFO: Suche nach Kontakten");
        System.out.println(contactManager.findById(1L));
        System.out.println(contactManager.findById(3L));

        System.out.println("INFO: --- Anwendung beendet ---");

    }
}