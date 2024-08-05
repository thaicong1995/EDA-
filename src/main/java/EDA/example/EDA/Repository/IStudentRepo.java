package EDA.example.EDA.Repository;

import EDA.example.EDA.Model.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepo extends CrudRepository<Student, Integer> {
}
