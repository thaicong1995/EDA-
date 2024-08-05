package EDA.example.EDA.Controller;

import EDA.example.EDA.Service.ISubjectService;
import EDA.example.EDA.ViewModel.SubjectViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subject")
@RequiredArgsConstructor
public class SubjectController {
    @Autowired
    private ISubjectService service;

    @GetMapping("/{id}")
    public ResponseEntity<Object> findbyId(@PathVariable int id) {
        var sub = service.findById(id);
        return ResponseEntity.ok(sub);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Object>> findAll() {
        var sub = service.findAll();
        return ResponseEntity.ok(sub);
    }

    @PostMapping("/")
    public ResponseEntity<Object> DoInsert(@RequestBody SubjectViewModel subject) {
        var sub = service.insert(subject);
        return ResponseEntity.ok(sub);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> DoUpdate(@PathVariable int id, @RequestBody SubjectViewModel subject) {
        var sub = service.update(id,subject);
        return ResponseEntity.ok(sub);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> DoDelete(@PathVariable int id) {
        var sub = service.delete(id);
        return ResponseEntity.ok(sub);
    }


}
