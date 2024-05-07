package ee.tlu.kontrolltoo2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity // andmebaasipanekuks
@NoArgsConstructor // andmebaasipanekuks
public class RiverEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nimetus;
    private double lahtmeX;
    private double lahtmeY;
    private double suudmeX;
    private double suudmeY;
    private int kiirus;
    @ManyToOne
    private Lake lake;
}