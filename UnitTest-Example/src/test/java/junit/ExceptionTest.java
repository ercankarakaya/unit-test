package junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import student.MailService;
import student.exception.MailServerUnavailableException;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.junit.Assert.*;


public class ExceptionTest {

    private MailService mailService = new MailService();


    /* TryCatch Exception method */
    @Test
    public void testTryCatchException(){
        try {
            mailService.monthlySendMail();
        }catch (Exception ex){
            //System.out.println(ex.fillInStackTrace());
            assertTrue(ex instanceof MailServerUnavailableException);
            assertEquals("Mail server unavailable.",ex.getMessage());
        }
    }

    /* Expected Exception method */
    @Test(expected = MailServerUnavailableException.class)
    public void testExpectedException(){
       mailService.monthlySendMail();
    }

    /* Rule Exception method */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testRuleException(){
        thrown.expect(MailServerUnavailableException.class);
        thrown.expectMessage("Mail server unavailable.");
        mailService.monthlySendMail();
    }

    /* Catch Exception */
    @Test
    public void testCatchException(){
        catchException(mailService).monthlySendMail();

        assertTrue(caughtException() instanceof MailServerUnavailableException);
        assertEquals("Mail server unavailable.",caughtException().getMessage());
    }

}
