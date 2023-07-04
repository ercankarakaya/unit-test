package assertj;

import org.junit.Test;
import student.exception.MailServerUnavailableException;

import java.io.File;
import static org.assertj.core.api.Assertions.*;


public class CustomFileTest {


    @Test
    public void testFiles() throws Exception{

        File file = new File("test.txt");

        assertThat(file)
                .exists()
                .canRead()
                .canWrite()
                .hasExtension("txt")
                .hasName("test.txt");

        assertThat(contentOf(file))
                .startsWith("This");

    }

    @Test
    public void testException()throws Exception{

        Exception exception = new MailServerUnavailableException("This is a test");

        assertThat(exception)
                .hasMessage("This is a test")
                .isInstanceOf(MailServerUnavailableException.class)
                .hasMessageContaining("is a");
    }

}
