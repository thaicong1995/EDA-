package EDA.example.EDA.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int score1;
    private int score2;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnore
    private Student students;

    @ManyToOne
    @JoinColumn(name = "suject_id", nullable = false)
    @JsonIgnore
    private Subject subjects;

}
