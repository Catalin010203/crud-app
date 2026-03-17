package pixel.academy.crud.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud.app.dao.StudentDao;
import pixel.academy.crud.app.entity.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
            createStudent(studentDao);
            createMultipleStudents(studentDao);
        };
    }


    private void createStudent(StudentDao studentDao) {

        // cream un obiect object Student
        System.out.println("Creating new student object ...");
        Student newStudent = new Student("John", "Doe", "joh@mail.com");

        // salvam obiectul Studentul in baza de date folosind DAO
        System.out.println("Saving the student .. ");
        studentDao.save(newStudent);

        // afisam id-ul studentului salvat
        System.out.println("Saved student. Generated id: " + newStudent.getId());
    }

    private void createMultipleStudents(StudentDao studentDao) {

        // cream mai multi studenti
        System.out.println("Creating 3 student objects ...");
        Student newStudent1 = new Student("Ion", "Vasilachi", "vasilachi@GMAIL.COM");
        Student newStudent2 = new Student("Maria", "Ionescu", "maria@GMAIL.COM");
        Student newStudent3 = new Student("Andrei", "Vatrici", "andrei@GMAIL.COM");

        // salvam obiectele studen in baza de date
        System.out.println("Saving the student ..");
        studentDao.save(newStudent1);
        studentDao.save(newStudent2);
        studentDao.save(newStudent3);
    }


}
