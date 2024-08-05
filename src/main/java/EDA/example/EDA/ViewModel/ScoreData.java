package EDA.example.EDA.ViewModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreData {
    private int id;
    private int score1;
    private int score2;

    private String studentName;
    private String subjectName;
    private int credit;
}
