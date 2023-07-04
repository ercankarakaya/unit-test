package assertj;

import lombok.Setter;
import student.MailService;

@Setter
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    private MailService mailService;

    public Employee addEmployee(String employeeName, String email) {

        Employee employee = new Employee(employeeName, email);

        setCar(employee);
        employeeRepository.save(employee);
        mailService.sendMailToEmployee(email);

        return employee;
    }

    private void setCar(Employee employee) {
        employee.addCar(new Car("tesla"));
        employee.addCar(new Car("auidi"));
    }

}
