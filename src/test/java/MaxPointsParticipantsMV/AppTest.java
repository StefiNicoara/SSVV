package MaxPointsParticipantsMV;

import MaxPointsParticipantsMV.Domain.Student;
import MaxPointsParticipantsMV.Domain.Teme;
import MaxPointsParticipantsMV.Repository.StudentRepo;
import MaxPointsParticipantsMV.Repository.TemeRepo;
import MaxPointsParticipantsMV.Validator.StudentValidator;
import MaxPointsParticipantsMV.Validator.TemeValidator;
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
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("6","Morea Razvan", 935, "mrie2365@scs.ubbcluj.ro", "Nicoara Stefania");
        assertNull(studentRepo.save(student));
        studentRepo.delete("6");
    }

    @Test
    public void testAddStudentFailure() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("5","Munteanu Diana", 935, "maie2367@scs.ubbcluj.ro", "Nicoara Stefania");
        assertEquals(student.getID(), studentRepo.save(student).getID());
        assertEquals(student.getNume(), studentRepo.save(student).getNume());
        assertEquals(student.getGrupa(), studentRepo.save(student).getGrupa());
        assertEquals(student.getMail(), studentRepo.save(student).getMail());
        assertEquals(student.getProfesor(), studentRepo.save(student).getProfesor());
    }


    @Test
    public void testAddAssignmentNotUniqueId() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(1,"Munteanu Diana", 7, 4);
        assertNotNull(temeRepo.save(tema));
    }

    @Test
    public void testAddAssignmentSameIdNotOverwrited() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(1,"Munteanu Diana", 7, 4);
        temeRepo.save(tema);
        assertNotEquals(tema.getID(), temeRepo.findOne(tema.getID()).getID());
        assertNotEquals(tema.getDescriere(), temeRepo.findOne(tema.getID()).getDescriere());
        assertNotEquals(tema.getDeadline(), temeRepo.findOne(tema.getID()).getDeadline());
        assertNotEquals(tema.getSapt_primire(), temeRepo.findOne(tema.getID()).getSapt_primire());
    }
}
