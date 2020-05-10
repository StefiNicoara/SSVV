package MaxPointsParticipantsMV;

import MaxPointsParticipantsMV.Domain.Nota;
import MaxPointsParticipantsMV.Domain.Student;
import MaxPointsParticipantsMV.Domain.Teme;
import MaxPointsParticipantsMV.Repository.NoteRepo;
import MaxPointsParticipantsMV.Repository.StudentRepo;
import MaxPointsParticipantsMV.Repository.TemeRepo;
import MaxPointsParticipantsMV.Validator.NotaValidator;
import MaxPointsParticipantsMV.Validator.StudentValidator;
import MaxPointsParticipantsMV.Validator.TemeValidator;
import MaxPointsParticipantsMV.Validator.ValidationException;
import org.junit.Test;
import java.util.Map;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /*
    TESTS FOR AddStudent
     */
    @Test
    public void testAddStudentSuccess() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("6","Morea Razvan", 935, "mrie2365@scs.ubbcluj.ro", "Nicoara Stefania");
        assertNull(studentRepo.save(student));
        studentRepo.delete("6");
    }

    @Test(expected = ValidationException.class)
    public void testAddStudentNullId() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student(null,"Morea Razvan", 935, "mrie2365@scs.ubbcluj.ro", "Nicoara Stefania");
        studentRepo.save(student);
    }

    @Test(expected = ValidationException.class)
    public void testAddStudentEmptyStringId() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("","Morea Razvan", 935, "mrie2365@scs.ubbcluj.ro", "Nicoara Stefania");
        studentRepo.save(student);
    }

    @Test(expected = ValidationException.class)
    public void testAddStudentStringId() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("id","Morea Razvan", 935, "mrie2365@scs.ubbcluj.ro", "Nicoara Stefania");
        studentRepo.save(student);
    }

    @Test(expected = ValidationException.class)
    public void testAddStudentNullName() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("6",null, 935, "mrie2365@scs.ubbcluj.ro", "Nicoara Stefania");
        studentRepo.save(student);
    }

    @Test(expected = ValidationException.class)
    public void testAddStudentEmptyStringName() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("6","", 935, "mrie2365@scs.ubbcluj.ro", "Nicoara Stefania");
        studentRepo.save(student);
    }

    @Test(expected = ValidationException.class)
    public void testAddStudentWrongStringName() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("6","Morea%  #Razvan", 935, "mrie2365@scs.ubbcluj.ro", "Nicoara Stefania");
        studentRepo.save(student);
    }

    @Test
    public void testAddStudentFailure() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("1","Roman Ionut", 222, "riir3478@scs.ubbcluj.ro", "Plesu Andrei");
        assertEquals(student.getID(), studentRepo.save(student).getID());
        assertEquals(student.getNume(), studentRepo.save(student).getNume());
        assertEquals(student.getGrupa(), studentRepo.save(student).getGrupa());
        assertEquals(student.getMail(), studentRepo.save(student).getMail());
        assertEquals(student.getProfesor(), studentRepo.save(student).getProfesor());
    }

    @Test(expected = ValidationException.class)
    public void testAddStudentProfessorWrongFormat() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("6","Morea Razvan", 935, "mrie2375@scs.ubbcluj.ro", "Ioan4 #Badarinza");
        studentRepo.save(student);
    }

    @Test(expected = ValidationException.class)
    public void testAddStudentProfessorEmpty() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("6","Morea Razvan", 935, "mrie2375@scs.ubbcluj.ro", "");
        studentRepo.save(student);
    }

    @Test(expected = ValidationException.class)
    public void testAddStudentProfessorNull() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("6","Morea Razvan", 935, "mrie2375@scs.ubbcluj.ro", null);
        studentRepo.save(student);
    }

    @Test(expected = ValidationException.class)
    public void testAddStudentEmailWrongFormat() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("6","Morea Razvan", 935, "mrie2375", "Ioan Badarinza");
        studentRepo.save(student);
    }

    @Test(expected = ValidationException.class)
    public void testAddStudentEmailEmpty() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("6","Morea Razvan", 935, "", "Ioan Badarinza");
        studentRepo.save(student);
    }

    @Test(expected = ValidationException.class)
    public void testAddStudentEmailNull() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("6","Morea Razvan", 935, null, "Ioan Badarinza");
        studentRepo.save(student);
    }

    @Test(expected = ValidationException.class)
    public void testAddStudentGroupLastDigit() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("6","Morea Razvan", 938, "mrie2375@scs.ubbcluj.ro", "Ioan Badarinza");
        studentRepo.save(student);
    }

    @Test(expected = ValidationException.class)
    public void testAddStudentGroupMiddleDigit() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("6","Morea Razvan", 947, "mrie2375@scs.ubbcluj.ro", "Ioan Badarinza");
        studentRepo.save(student);
    }

    @Test(expected = ValidationException.class)
    public void testAddStudentGroupTooBig() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("6","Morea Razvan", 938, "mrie2375@scs.ubbcluj.ro", "Ioan Badarinza");
        studentRepo.save(student);
    }

    @Test(expected = ValidationException.class)
    public void testAddStudentGroupTooLittle() {
        StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\studenti.xml");
        Student student = new Student("6","Morea Razvan", 110, "mrie2375@scs.ubbcluj.ro", "Ioan Badarinza");
        studentRepo.save(student);
    }

    /*
    TESTS FOR AddAssignment
    */
    @Test(expected = ValidationException.class)
    public void testAddAssignmentNullId() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(null,"SSVV testing", 2, 4);
        temeRepo.save(tema);
    }

    @Test(expected = ValidationException.class)
    public void testAddAssignmentIdTooLittle() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(0,"SSVV testing", 2, 4);
        temeRepo.save(tema);
    }

    @Test(expected = ValidationException.class)
    public void testAddAssignmentNullDesc() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(6,null, 2, 4);
        temeRepo.save(tema);
    }

    @Test(expected = ValidationException.class)
    public void testAddAssignmentEmptyDesc() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(6,"", 2, 4);
        temeRepo.save(tema);
    }

    @Test(expected = ValidationException.class)
    public void testAddAssignmentNullDeadline() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(6,"SSVV testing", 2, null);
        temeRepo.save(tema);
    }

    @Test(expected = ValidationException.class)
    public void testAddAssignmentDeadlineTooLittle() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(6,"SSVV testing", 2, 0);
        temeRepo.save(tema);
    }

    @Test(expected = ValidationException.class)
    public void testAddAssignmentDeadlineTooBig() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(6,"SSVV testing", 2, 15);
        temeRepo.save(tema);
    }

    @Test(expected = ValidationException.class)
    public void testAddAssignmentNullSaptPrimire() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(6,"SSVV testing", null, 4);
        temeRepo.save(tema);
    }

    @Test(expected = ValidationException.class)
    public void testAddAssignmentSaptPrimireTooLittle() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(6,"SSVV testing", 0, 4);
        temeRepo.save(tema);
    }

    @Test(expected = ValidationException.class)
    public void testAddAssignmentSaptPrimireTooBig() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(6,"SSVV testing", 2, 15);
        temeRepo.save(tema);
    }

    @Test(expected = ValidationException.class)
    public void testAddAssignmentSaptPrimireLessThanDeadline() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(6,"SSVV testing", 5, 4);
        temeRepo.save(tema);
    }

    @Test
    public void testAddAssignmentSuccessful() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(6,"SSVV testing", 2, 4);
        assertNull(temeRepo.save(tema));
        temeRepo.delete(6);
    }

    @Test
    public void testAddAssignmentFailure() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(1,"Bubblesort", 4, 7);
        temeRepo.save(tema);
        assertNotEquals(tema.getDescriere(), temeRepo.findOne(tema.getID()).getDescriere());
        assertNotEquals(tema.getDeadline(), temeRepo.findOne(tema.getID()).getDeadline());
        assertNotEquals(tema.getSapt_primire(), temeRepo.findOne(tema.getID()).getSapt_primire());
    }

    @Test
    public void testAddAssignmentNotUniqueId() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(1,"Suma a+b", 10, 10);
        assertNotNull(temeRepo.save(tema));
    }

    @Test
    public void testAddAssignmentSameIdNotOverwrited() {
        TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"C:\\Users\\Diana\\Facultate\\Year3\\SSVV\\Lab2\\Maven project\\SSVV\\src\\main\\java\\MaxPointsParticipantsMV\\teme.xml");
        Teme tema = new Teme(1,"Bubblesort", 4, 7);
        temeRepo.save(tema);
        assertNotEquals(tema.getDescriere(), temeRepo.findOne(tema.getID()).getDescriere());
        assertNotEquals(tema.getDeadline(), temeRepo.findOne(tema.getID()).getDeadline());
        assertNotEquals(tema.getSapt_primire(), temeRepo.findOne(tema.getID()).getSapt_primire());
    }

    /*
    TESTS FOR Grade
    */

    @Test
    public void testAddGrade() {
        NoteRepo noteRepo = new NoteRepo(new NotaValidator());

        Student student = new Student("6","Morea Razvan", 935, "mrie2365@scs.ubbcluj.ro", "Nicoara Stefania");
        Teme tema = new Teme(1,"Suma a+b", 10, 10);
        Nota nota = new Nota(Map.entry("2", 1),student, tema, 10, 4);

        assertNull(noteRepo.save(nota));
    }

    /*
    INTEGRATION TESTS
    */

    @Test
    public void integrationTesting() {
        testAddStudentSuccess();
        testAddAssignmentNotUniqueId();
        testAddGrade();
    }

    @Test
    public void integrationTestingAddStudent() {
        testAddStudentSuccess();
    }

    @Test
    public void integrationTestingAddAssignment() {
        integrationTestingAddStudent();
        testAddAssignmentSuccessful();
    }

    @Test
    public void integrationTestingAddGrade() {
        integrationTestingAddAssignment();
        testAddGrade();
    }
}
