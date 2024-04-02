package ee.tlu.kodutoo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "numbers") // vabatahtlik - nime vahetuseks
@Entity // andmebaasi panekuks
@NoArgsConstructor // andmebaasi panekuks
public class NumberEntity {

    // Getterid ja setterid
    @Id
    String name;
    String description;
    int number;
}