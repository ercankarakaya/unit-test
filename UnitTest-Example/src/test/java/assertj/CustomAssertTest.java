package assertj;

import assertj.employee.EmployeeAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import student.MailService;


public class CustomAssertTest {

    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;
    private MailService mailService;


    public static final String USERNAME="ercan";
    public static final String EMAIL="ercan@gmail.com";


    @Before
    public void setUp() throws Exception {
        employeeService = new EmployeeService();
        employeeRepository = Mockito.mock(EmployeeRepository.class);
        mailService = Mockito.mock(MailService.class);

        employeeService.setEmployeeRepository(employeeRepository);
        employeeService.setMailService(mailService);
    }

    @Test
    public void testCustomAssertJUnit() throws Exception{
        Employee employee = employeeService.addEmployee(USERNAME,EMAIL);

        Mockito.verify(employeeRepository).save(Mockito.any(Employee.class));
        Mockito.verify(mailService).sendMailToEmployee(EMAIL);
        Assert.assertNotNull(employee.getCarList());
        Assert.assertEquals(2,employee.getCarList().size());
        Assert.assertEquals("tesla",employee.getCarList().get(0).getName());
    }

    @Test
    public void testCustomAssert()throws Exception{
        Employee employee = employeeService.addEmployee(USERNAME,EMAIL);

        assertThatEmployee(employee)
                .isSaved()
                .hasReceivedMail()
                .hasCars(2)
                .hasCarWithName("tesla")
                .hasCarWithName("auidi");

    }

    private EmployeeAssert assertThatEmployee(Employee employee){
        return new EmployeeAssert(employee,EmployeeAssert.class,employeeRepository,mailService);
    }

}
