package pixel.academy.crud.app.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixel.academy.crud.app.entity.Student;

import java.util.List;

@Repository
public class StudentsDaoImplementation implements StudentDao {

    // Camp pentru EntityManager (va fi utilizat pentru interactiunea cu baza de date)
    private EntityManager entityManager;



    // Injectarea EntityManager prin constructor (practica recomandata pentru testabilitate si modularitate)
    @Autowired
    public StudentsDaoImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Implementarea metodei save pentru salvarea unui obiect Student in baza de date
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // Return query results
        return theQuery.getResultList();
    }



}
