package pixel.academy.crud.app.dao;

import jakarta.transaction.Transactional;
import pixel.academy.crud.app.entity.Student;

import java.util.List;

public interface StudentDao {

    @Transactional
    void save(Student theStudent);
    Student findById(Integer theID);
    List<Student> findAll();
    List<Student> findByLastName(String theLastName);
    void update(Student theStudent);
    void delete(Integer ID);
    int deleteAll();
}
