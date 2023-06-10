package student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private long id;
    private String firstName;
    private String lastName;
    private int studentNumber;
    private String email;
}
