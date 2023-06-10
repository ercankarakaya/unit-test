package student;

public class StudentService {

    private StudentRepository studentRepository;
    private MailService mailService;


    public StudentService(StudentRepository studentRepository, MailService mailService) {
        this.studentRepository = studentRepository;
        this.mailService = mailService;
    }

    public void save(Student student){
        studentRepository.save(student);
        mailService.sendMailToStudent(student);
    }

    public void delete(long studentId){
        studentRepository.delete(studentId);
    }

}
