package EDA.example.EDA.Controller;

import EDA.example.EDA.Service.IScoreService;
import EDA.example.EDA.Service.IStudentService;
import EDA.example.EDA.ViewModel.ScoreViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class ScoreController {
    @Autowired
    private IScoreService service;

    @GetMapping("score/all")
    public ResponseEntity<List<Object>> findAll() {
        var sc = service.findAll();
        return ResponseEntity.ok(sc);
    }

    @PostMapping("score/{stu_id}/{sub_id}")
    public ResponseEntity<Object> DoInsert(@PathVariable int stu_id, @PathVariable int sub_id, @RequestBody ScoreViewModel score) {
        var sc = service.insert(stu_id,sub_id,score);
        return ResponseEntity.ok(sc);
    }


}
