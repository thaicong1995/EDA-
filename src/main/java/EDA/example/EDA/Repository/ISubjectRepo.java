package EDA.example.EDA.Repository;

import EDA.example.EDA.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectRepo extends JpaRepository<Subject, Integer> {

}
