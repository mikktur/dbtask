package dao;

import entity.Author;
import entity.Biography;

import jakarta.persistence.EntityManager;



public class BiographyDAO {

    private EntityManager entityManager;

    public BiographyDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Biography biography) {
        entityManager.getTransaction().begin();
        entityManager.persist(biography);
        entityManager.getTransaction().commit();

    }


}
