package EDA.example.EDA.Repository;

import EDA.example.EDA.Model.Score;
import EDA.example.EDA.ViewModel.ScoreData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IScoreRepo extends JpaRepository<Score, Integer> {

    @Query("SELECT new EDA.example.EDA.ViewModel.ScoreData(s.id, s.score1, s.score2, st.name, sub.name, sub.credit) " +
            "FROM Score s " +
            "JOIN s.students st " +
            "JOIN s.subjects sub")
    List<ScoreData> findAllScoreData();
}
