package EDA.example.EDA.Service;

import EDA.example.EDA.ViewModel.StudentViewModel;
import EDA.example.EDA.ViewModel.SubjectViewModel;

import java.util.List;

public interface IStudentService<T>{
    T findById(int id);
    List<T> findAll();
    T insert(StudentViewModel category);
    T update(int id, StudentViewModel category);
    T delete(int id);
}
