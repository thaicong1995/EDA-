package EDA.example.EDA.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int credit;

    @OneToMany(mappedBy = "subjects", cascade = CascadeType.ALL)
    private List<Score> scores;
}
