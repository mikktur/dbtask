package dao;
import entity.Student;
import jakarta.persistence.*;
import java.util.List;

public class StudentDAO {
    private EntityManager entityManager;

    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public void delete(Long id) {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
        entityManager.getTransaction().commit();
    }
}
