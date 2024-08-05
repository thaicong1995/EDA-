package EDA.example.EDA.Service.Impl;

import EDA.example.EDA.Model.Student;
import EDA.example.EDA.Model.Subject;
import EDA.example.EDA.Repository.IStudentRepo;
import EDA.example.EDA.Repository.ISubjectRepo;
import EDA.example.EDA.Service.IStudentService;
import EDA.example.EDA.ViewModel.StudentViewModel;
import EDA.example.EDA.ViewModel.SubjectViewModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static EDA.example.EDA.Helpper.MapDto.toModel;
import static EDA.example.EDA.Helpper.MapDto.toModels;

@RequiredArgsConstructor
@Service
@Transactional

public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepo repo;

    @Override
    public Object findById(int id) {
        var student = repo.findById(id);
        return toModel(student.get(), StudentViewModel.class);
    }

    public List findAll() {
        Iterable<Student> studentsIterable = repo.findAll();
        List<Student> studentsList = StreamSupport.stream(studentsIterable.spliterator(), false)
                .collect(Collectors.toList());
        return toModels(studentsList, StudentViewModel.class);
    }

    @Override
    public Object insert(StudentViewModel student) {
        var stu = toModel(student, Student.class);
        var saved = repo.save(stu);
        return toModel(saved, StudentViewModel.class);
    }

    @Override
    public Object update(int id, StudentViewModel student) {
        Optional<Student> exist= repo.findById(id);
        if (exist.isEmpty()) {
            throw new RuntimeException("Category not found for ID: " + id);
        }
        var s = exist.get();
        s.setName(student.getName());
        s.setCode(student.getCode());
        s.setAddress(student.getAddress());
        var updated = repo.save(s);
        return toModel(updated, StudentViewModel.class);
    }

    @Override
    public Object delete(int id) {
        Optional<Student> exist = repo.findById(id);
        if (exist.isEmpty()) {
            throw new RuntimeException("Student not found for ID: " + id);
        }
        repo.deleteById(id);
        return null;
    }
}
