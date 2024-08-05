package EDA.example.EDA.Service;

import EDA.example.EDA.ViewModel.ScoreViewModel;
import EDA.example.EDA.ViewModel.StudentViewModel;

import java.util.List;

public interface IScoreService <T> {
    T findById(int id);

    List<T> findAll();

    T insert(int student_id, int subject_id,ScoreViewModel score);

    T update(int id, ScoreViewModel core);

    T delete(int id);
}