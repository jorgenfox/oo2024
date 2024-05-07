package ee.tlu.kontrolltoo2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity // andmebaasipanekuks
@NoArgsConstructor // andmebaasipanekuks
public class Lake {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double pollutionPercentage;
}
