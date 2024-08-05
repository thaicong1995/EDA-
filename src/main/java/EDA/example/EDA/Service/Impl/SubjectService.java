package EDA.example.EDA.Service.Impl;

import EDA.example.EDA.Model.Subject;
import EDA.example.EDA.Repository.ISubjectRepo;
import EDA.example.EDA.Service.ISubjectService;
import EDA.example.EDA.ViewModel.SubjectViewModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static EDA.example.EDA.Helpper.MapDto.toModel;
import static EDA.example.EDA.Helpper.MapDto.toModels;

@RequiredArgsConstructor
@Service
@Transactional
public class SubjectService implements ISubjectService {
    @Autowired
    private ISubjectRepo repo;

    @Override
    public Object findById(int id) {
        var subject = repo.findById(id);
        return toModel(subject.get(), SubjectViewModel.class);
    }

    @Override
    public List findAll() {
        var subjects = repo.findAll();
        return toModels(subjects, SubjectViewModel.class);
    }

    @Override
    public Object insert(SubjectViewModel subject) {
        var sub = toModel(subject, Subject.class);
        var saved = repo.save(sub);
        return toModel(saved, SubjectViewModel.class);
    }

    @Override
    public Object update(int id, SubjectViewModel subject) {
        Optional<Subject> exist= repo.findById(id);
        if (exist.isEmpty()) {
            throw new RuntimeException("Subject not found for ID: " + id);
        }
        var c = exist.get();
        c.setName(subject.getName());
        c.setCredit(subject.getCredit());
        var updated = repo.save(c);
        return toModel(updated, SubjectViewModel.class);
    }

    @Override
    public Object delete(int id) {
        Optional<Subject> exist = repo.findById(id);
        if (exist.isEmpty()) {
            throw new RuntimeException("Category not found for ID: " + id);
        }
        repo.deleteById(id);
        return null;
    }
}
