package dao;

import entity.Book;
import jakarta.persistence.*;
import java.util.List;

public class BookDAO {
    private EntityManager entityManager;

    public BookDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    public void delete(Long id) {
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, id);
        if (book != null) {
            entityManager.remove(book);
        }
        entityManager.getTransaction().commit();
    }
}
