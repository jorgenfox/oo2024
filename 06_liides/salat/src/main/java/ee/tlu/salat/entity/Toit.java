package ee.tlu.salat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Toit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1,2,3,4,5...
    private Long id;

    private String nimetus;

    @ManyToMany
    List<Toidukomponent> toidukomponendid;
    // [{"nimi": vorst, kogus: 100g}, {"nimi": hapukoor, kogus: 200g}]
}

// GenerationType.IDENTITY --> 1,2,3,4,5...
// GenerationType.SEQUENCE --> saan alustada mingist kindlast numbrist
// ja liikuda mingite kindlate numbrite võrra edasi
// GenerationType.UUID --> acde070d-8c4c-4f0d-9d8a-162843c10333
// GenerationType.AUTO --> automaatselt Postgres enda seadistus
// GenerationType.TABLE --> guugelda