package assertj.employee;

import assertj.CustomAssertTest;
import assertj.Employee;
import assertj.EmployeeRepository;
import org.assertj.core.api.AbstractAssert;
import org.mockito.Mockito;
import student.MailService;
import static org.assertj.core.api.Assertions.assertThat;


public class EmployeeAssert extends AbstractAssert<EmployeeAssert, Employee>{

    private EmployeeRepository employeeRepository;
    private MailService mailService;


    public EmployeeAssert(Employee actual, Class<?> selfType, EmployeeRepository employeeRepository, MailService mailService) {
        super(actual, selfType);
        this.employeeRepository = employeeRepository;
        this.mailService = mailService;
    }

    public EmployeeAssert hasCars(int sizeOfCars) {

        assertThat(actual.getCarList())
                .isNotEmpty()
                .hasSize(sizeOfCars);

        return this;
    }

    public EmployeeAssert hasCarWithName(String carName) {

        assertThat(actual.getCarList())
                .isNotEmpty()
                .extracting("name")
                .contains(carName);

        return this;
    }

    public EmployeeAssert isSaved() {

        Mockito.verify(employeeRepository).save(Mockito.any(Employee.class));

        return this;
    }

    public EmployeeAssert hasReceivedMail() {

        Mockito.verify(mailService).sendMailToEmployee(CustomAssertTest.EMAIL);

        return this;
    }

}
