package student;

public class StudentRepository {

   public void save(Student student){
       System.out.println("Student saved.");
   }

   public Student findById(long id){
       System.out.println("Student found.");
       return null;
   }

   public void delete(long id){
       System.out.println("Student deleted.");
   }
}
