package mock;

import mock.user.User;
import mock.user.UserService;
import mock.user.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import student.MailService;
import student.Student;
import student.StudentRepository;
import student.StudentService;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class AnnotationTest {

    @InjectMocks
    private StudentService studentService;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private MailService mailService;


//    @Spy
//    private UserServiceImpl userService;


    @Test
    public void testAnnotation() throws Exception{

        Student student = new Student(1,"Ercan","Karakaya",123,"ercan@gmail.com");

        studentService.save(student);

    }
}
