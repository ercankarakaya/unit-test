package student;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import student.stub.StudentRepositoryStub;
import static org.junit.Assert.*;

public class StudentServiceTest {

    private StudentService studentService;
    private MailService mailService;

    //private StudentRepository studentRepository;
    /** With Stub */
    private StudentRepositoryStub studentRepository = new StudentRepositoryStub();

    @Before
    public void setUp() throws Exception {
        /*
        studentRepository = new StudentRepository();
        mailService = new MailService();
        */

        /** With Mockito */
        mailService = Mockito.mock(MailService.class);
        //studentRepository = Mockito.mock(StudentRepository.class);

        studentService = new StudentService(studentRepository,mailService);
    }

    @Test
    public void testStudentSave(){

        Student student = new Student(1,"Ercan","Karakaya",123,"ercank@gmail.com");

        studentService.save(student);

        //assertTrue(studentRepository.getStudentList().contains(student));
        //assertNotNull(studentRepository.findById(student.getId()));
        assertEquals(student,studentRepository.findById(student.getId()));

        //student = new Student(1,"Ercan","Karakaya",789,"ercank@gmail.com"); // studentNumber is different!

        //Mockito.verify(studentRepository).save(student);
        Mockito.verify(mailService).sendMailToStudent(student);

    }

    @Test
    public void testStudentDelete(){

        studentService.save(new Student(1,"Ercan","Karakaya",123,"ercank@gmail.com"));

        long studentId = 1;
        assertNotNull(studentRepository.findById(studentId));

        studentService.delete(studentId);

        assertNull(studentRepository.findById(studentId));

        //assertTrue(studentRepository.findById(studentId).isEmpty()); // for Optinal<Student> findById

    }

}
