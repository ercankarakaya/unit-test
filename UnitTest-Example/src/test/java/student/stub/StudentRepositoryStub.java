package student.stub;

import lombok.Getter;
import student.Student;
import student.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepositoryStub extends StudentRepository {

    @Getter
    private List<Student> studentList = new ArrayList<>();

    @Override
    public void save(Student student) {
        studentList.add(student);
    }

    @Override
    public void delete(long id) {
        if (studentList != null && !studentList.isEmpty()) {
            studentList.removeIf(s -> s.getId() == id);
        }
    }

    @Override
    public Student findById(long id) {
        return studentList
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst().orElse(null);
    }
}
