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
        UserRepository repo = new UserRepository();
        UserEntity user = new UserEntity("Susi Sorglos", "susi@sorglos.com");
        UserEntity user1 = new UserEntity("Hans Sorglos", "hans@sorglos.com");
        user = repo.save(user);
        user1 = repo.save(user1);
        System.out.println(repo.findByName("Susi Sorglos"));
        System.out.println(repo.findAll());

        close();
    }


}


