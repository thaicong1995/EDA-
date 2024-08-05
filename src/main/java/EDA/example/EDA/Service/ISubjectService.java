package EDA.example.EDA.Service;

import EDA.example.EDA.ViewModel.SubjectViewModel;

import java.util.List;

public interface ISubjectService<T> {
    T findById(int id);
    List<T> findAll();
    T insert(SubjectViewModel subject);
    T update(int id, SubjectViewModel subject);
    T delete(int id);
}
