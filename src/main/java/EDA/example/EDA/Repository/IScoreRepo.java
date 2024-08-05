package EDA.example.EDA.Repository;

import EDA.example.EDA.Model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IScoreRepo extends JpaRepository<Score, Integer> {
}
