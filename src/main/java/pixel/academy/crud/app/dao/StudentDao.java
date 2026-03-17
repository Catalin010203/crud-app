package pixel.academy.crud.app.dao;

import jakarta.transaction.Transactional;
import pixel.academy.crud.app.entity.Student;

public interface StudentDao {

    @Transactional
    void save(Student theStudent);
    Student findById(int theID);
}
