package student;

public class MailService {

    public void sendMailToStudent(Student student){
        System.out.println("An e-mail has been sent to "+student.getEmail());
    }
}
