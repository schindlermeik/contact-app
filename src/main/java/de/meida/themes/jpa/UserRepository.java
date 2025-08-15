package de.meida.themes.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public class UserRepository {

    public UserEntity save(UserEntity user) {
        EntityManager em = JPAUtil.em();
        em.getTransaction().begin();
        ;
        try {
            if (user.getId() == null) {
                em.persist(user);
            } else {
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

    public List<UserEntity> findAll() {
        try (EntityManager em = JPAUtil.em()) {
            return em.createQuery("select u from UserEntity u", UserEntity.class)
                    .getResultList();
        }
    }

    public List<UserEntity> findByName(String name) {
        try (EntityManager em = JPAUtil.em()) {
            return em.createNamedQuery("User.findByName", UserEntity.class)
                    .setParameter("name", name)
                    .getResultList();
        }
    }

    // Criteria Api
    public Optional<UserEntity> findByEmail(String email) {
        try (EntityManager em = JPAUtil.em()) {
            // 1 Criteria Builder
            CriteriaBuilder cb = em.getCriteriaBuilder();
            // 2 RückgabeWert
            CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
            Root<UserEntity> root = cq.from(UserEntity.class);
            cq.select(root).where(cb.equal(root.get("email"), email));

            return Optional.of(em.createQuery(cq).getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }


}
