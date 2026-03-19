package pixel.academy.crud.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud.app.dao.StudentDao;
import pixel.academy.crud.app.entity.Student;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
            //createStudent(studentDao);
            //createMultipleStudents(studentDao);

            readStudent(studentDao);
            queryForStudents(studentDao);
            queryForStudentsByLastName(studentDao);
            updateStudent(studentDao);
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

    private void readStudent(StudentDao studentDao) {
        System.out.println("Reading student ...");

        // Create a object Student
        System.out.println("Creating student objects ...");
        Student newStudent = new Student("Maria", "Magdalena", "maria@gmail.com");

        // Save the object Student in Data Base
        System.out.println("Saving the student ..");
        studentDao.save(newStudent);

        // Show student's id
        int theId = newStudent.getId();
        System.out.println("Saveed student. Generated id: " + theId);

        //Recover student in base of ID
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDao.findById(theId);

        //Show students details
        System.out.println("Found the student: " + myStudent);
    }

    private void queryForStudents(StudentDao studentDao) {
        // Obtain list of students
        List<Student> theStudents = studentDao.findAll();

        // show list of students
        for (Student newStudent : theStudents) {
            System.out.println(newStudent);
        }
    }


    private void queryForStudentsByLastName(StudentDao studentDao) {

        List<Student> theStudent = studentDao.findByLastName("Vasilachi");

        for (Student newStudent : theStudent) {
            System.out.println(newStudent);
        }
    }

    private void updateStudent(StudentDao studentDao) {

        // find the student in DB with ID
        int studentID = 1;
        System.out.println("Getting student with id: " + studentID);
        Student newStudent = studentDao.findById(studentID);

        // modify student secondname "Ion"
        System.out.println("Updating student ...");
        newStudent.setFirstName("Ion");

        // save modification in DB
        studentDao.update(newStudent);

        // show details about students
        System.out.println("Updated student: " + newStudent);
    }

}
