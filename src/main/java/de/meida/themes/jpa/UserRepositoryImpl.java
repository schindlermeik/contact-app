package de.meida.themes.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class UserRepositoryImpl {

    public UserEntity save(UserEntity user) {
        EntityManager em = JPAUtil.em();
        em.getTransaction().begin();
        try  {
            if (user.getId() == null) {
                // Ein neues Objekt einfügen
                em.persist(user);
            } else {
                // Ein bestehendes Objekt aktualisieren (merge)
                user = em.merge(user);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
        return user;
    }

    public void delete(Long id) {
        EntityManager em = JPAUtil.em();
        em.getTransaction().begin();
        try {
            UserEntity user = em.find(UserEntity.class, id);
            if (user != null) {
                em.remove(user);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public UserEntity findById(Long id) {
        try (EntityManager em = JPAUtil.em()) {
            return em.find(UserEntity.class, id);
        }
    }

    public List<UserEntity>  findByName(String name) {
        try (EntityManager em = JPAUtil.em()) {
            return em.createNamedQuery("User.findByName", UserEntity.class)
                    .setParameter("name", name)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public UserEntity findByEmail(String email) {
        try (EntityManager em = JPAUtil.em()) {
            // 1. Erstelle einen CriteriaBuilder
            CriteriaBuilder cb = em.getCriteriaBuilder();

            // 2. Erstelle eine CriteriaQuery für den Rückgabetyp
            CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);

            // 3. Definiere die Wurzel der Abfrage (FROM-Teil)
            Root<UserEntity> userRoot = cq.from(UserEntity.class);

            // 4. Füge die WHERE-Klausel hinzu
            cq.select(userRoot).where(cb.equal(userRoot.get("email"), email));

            // 5. Erstelle die Query und führe sie aus
            return em.createQuery(cq).getSingleResult();

        } catch (NoResultException e) {
            // Falls kein Ergebnis gefunden wird, gib null zurück
            return null;
        }
    }

    public List<UserEntity> findAll() {
        try (EntityManager em = JPAUtil.em()) {
            return em.createQuery("SELECT u FROM UserEntity u", UserEntity.class)
                    .getResultList();
        }
    }
}
