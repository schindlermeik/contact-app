package de.meida.themes.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory EMF =
            Persistence.createEntityManagerFactory("demoJPA");

    private JPAUtil(){}

    public static EntityManager em() { return EMF.createEntityManager(); }
    public static void close() { EMF.close(); }

    public static void main(String[] args) {
        EntityManager entityManager = em();
        entityManager.close();
        close();
    }
}


