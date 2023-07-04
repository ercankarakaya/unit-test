package student;

import student.exception.MailServerUnavailableException;

public class MailService {

    public void sendMailToStudent(Student student){
        System.out.println("An e-mail has been sent to "+student.getEmail());
    }

    public void monthlySendMail(){
        throw new MailServerUnavailableException("Mail server unavailable.");
    }

    public void sendMailToEmployee(String email){
        System.out.println("An e-mail has been sent to "+email);
    }
}
