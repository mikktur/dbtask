package dao;

import entity.Author;
import entity.Biography;
import jakarta.persistence.EntityManager;

public class AuthorDAO {

    private EntityManager entityManager;

    public AuthorDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Author a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();

    }
}
