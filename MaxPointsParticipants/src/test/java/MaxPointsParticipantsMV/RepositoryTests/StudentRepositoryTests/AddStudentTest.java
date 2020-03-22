package MaxPointsParticipantsMV.RepositoryTests.StudentRepositoryTests;

import MaxPointsParticipantsMV.Domain.Student;
import MaxPointsParticipantsMV.Repository.StudentRepo;
import MaxPointsParticipantsMV.Validator.StudentValidator;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AddStudentTest {
    StudentRepo studentRepo;
    Student student;
    @BeforeClass
    public void initializeData() {
        this.studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\MaxPointsParticipants\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        this.student = new Student("5","Munteanu Diana", 935, "maie2367@scs.ubbcluj.ro", "Nicoara Stefania");
    }
    /**
     * Due to the use of putIfAbsent( method from the map interface ) in case of success the method will return true.
     */
    @Test
    public void testAddStudentSuccess() {
        assertNull(studentRepo.save(student));
    }

    @Test
    public void testAddStudentFailure() {
        assertEquals(student, studentRepo.save(student));
    }

    @After
    public void cleanup() {
        studentRepo.delete("5");
    }
}
