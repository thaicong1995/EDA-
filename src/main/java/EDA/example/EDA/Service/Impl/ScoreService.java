package EDA.example.EDA.Service.Impl;

import EDA.example.EDA.Model.Score;
import EDA.example.EDA.Model.Student;
import EDA.example.EDA.Repository.IScoreRepo;
import EDA.example.EDA.Repository.IStudentRepo;
import EDA.example.EDA.Repository.ISubjectRepo;
import EDA.example.EDA.Service.IScoreService;
import EDA.example.EDA.ViewModel.ScoreData;
import EDA.example.EDA.ViewModel.ScoreViewModel;
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
public class ScoreService implements IScoreService {
    @Autowired
    private IScoreRepo repo;
    @Autowired
    private ISubjectRepo repo_sub;
    @Autowired
    private IStudentRepo repo_stu;
    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public List findAll() {
        return repo.findAllScoreData();
    }


    @Override
    public Object insert(int student_id, int subject_id,ScoreViewModel score) {
        var exitst_stu = repo_stu.findById(student_id);
        var exitst_sub = repo_sub.findById(subject_id);
        if (exitst_stu.isEmpty() || exitst_sub.isEmpty()) {

            throw new RuntimeException("Not found");
        }

        try{
            var sc = toModel(score, Score.class);

            sc.setStudents(exitst_stu.get());
            sc.setSubjects(exitst_sub.get());
            var saved = repo.save(sc);
            return toModel(saved, ScoreViewModel.class);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Object update(int id, ScoreViewModel core) {
        var exit_sc = repo.findById(id);
        if (exit_sc.isEmpty()) {
            throw new RuntimeException("Not found");
        }

        var pr = exit_sc.get();
        pr.setScore1(core.getScore1());
        pr.setScore2(core.getScore2());

        var saved = repo.save(pr);
        return toModel(saved, ScoreViewModel.class);
    }

    @Override
    public Object delete(int id) {
        Optional<Score> exist = repo.findById(id);
        if (exist.isEmpty()) {
            throw new RuntimeException("Student not found for ID: " + id);
        }
        repo.deleteById(id);
        return null;
    }
}
