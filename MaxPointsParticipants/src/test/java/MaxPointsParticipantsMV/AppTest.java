package MaxPointsParticipantsMV;

import MaxPointsParticipantsMV.Domain.Student;
import MaxPointsParticipantsMV.Repository.StudentRepo;
import MaxPointsParticipantsMV.RepositoryTests.StudentRepositoryTests.AddStudentTest;
import MaxPointsParticipantsMV.Validator.StudentValidator;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testAddStudentSuccess() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\MaxPointsParticipants\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("6","Morea Razvan", 935, "mrie2365@scs.ubbcluj.ro", "Nicoara Stefania");
        assertNull(studentRepo.save(student));
        studentRepo.delete("6");
    }

    @Test
    public void testAddStudentFailure() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\MaxPointsParticipants\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("5","Munteanu Diana", 935, "maie2367@scs.ubbcluj.ro", "Nicoara Stefania");
        assertEquals(student.getID(), studentRepo.save(student).getID());
        assertEquals(student.getNume(), studentRepo.save(student).getNume());
        assertEquals(student.getGrupa(), studentRepo.save(student).getGrupa());
        assertEquals(student.getMail(), studentRepo.save(student).getMail());
        assertEquals(student.getProfesor(), studentRepo.save(student).getProfesor());
    }
}
