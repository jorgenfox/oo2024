package ee.tlu.kodutoo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
public class NumberComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    NumberEntity number;

    //@ManyToMany
    //List<NumberEntity> numbers;
    int kogus;

    // {id: 5, toiduaine: {nimetus: "Vorst"}, kogus: 100}
    // 5   |   "Vorst  |    100
}
