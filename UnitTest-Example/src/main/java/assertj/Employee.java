package assertj;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Employee {

    private String username;

    private String email;

    private List<Car> carList = new ArrayList<Car>();

    public void addCar(Car car) {
        carList.add(car);
    }

    public Employee(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
