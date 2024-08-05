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
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
    private String address;

    @OneToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private List<Score> scores;

}
