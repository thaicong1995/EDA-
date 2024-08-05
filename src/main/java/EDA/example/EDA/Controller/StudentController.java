package EDA.example.EDA.Controller;

import EDA.example.EDA.Service.IStudentService;
import EDA.example.EDA.Service.ISubjectService;
import EDA.example.EDA.ViewModel.StudentViewModel;
import EDA.example.EDA.ViewModel.SubjectViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    @Autowired
    private IStudentService service;

    @GetMapping("/{id}")
    public ResponseEntity<Object> findbyId(@PathVariable int id) {
        var stu = service.findById(id);
        return ResponseEntity.ok(stu);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Object>> findAll() {
        var stu = service.findAll();
        return ResponseEntity.ok(stu);
    }

    @PostMapping("/")
    public ResponseEntity<Object> DoInsert(@RequestBody StudentViewModel student) {
        var stu = service.insert(student);
        return ResponseEntity.ok(stu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> DoUpdate(@PathVariable int id, @RequestBody StudentViewModel student) {
        var stu = service.update(id,student);
        return ResponseEntity.ok(stu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> DoDelete(@PathVariable int id) {
        var stu = service.delete(id);
        return ResponseEntity.ok(stu);
    }


}
