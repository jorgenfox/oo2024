package ee.tlu.salat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "toiduaine") // vabatahtlik - nime vahetuseks
@Entity // andmebaasi panekuks
@NoArgsConstructor // andmebaasi panekuks
public class ToiduaineEntity {
    @Id // alati unikaalne - kustutamiseks, votmiseks, muutmiseks jne
    String nimetus;
    int valk;
    int rasv;
    int sysivesik;

//    public ToiduaineEntity(String nimetus, int valk, int rasv, int sysivesik) {
//        this.nimetus = nimetus;
//        this.valk = valk;
//        this.rasv = rasv;
//        this.sysivesik = sysivesik;
//    }
}
