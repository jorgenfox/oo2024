package ee.tlu.salat.entity;

// Mis koosneb toiduainest ja temaga seotud kogusest toidu sees
// Klassikomplekt -> Kartul+omadused ja mitu grammi

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
public class Toidukomponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne // kui kustutatakse Toiduaine, siis kustuvad ka temaga
    // seotud toidukomponendid
    ToiduaineEntity toiduaine;

    //@ManyToMany
    //List<ToiduaineEntity> toiduained;
    int kogus;


    // {id: 5, toiduaine: {nimetus: "Vorst"}, kogus: 100}
    // 5   |   "Vorst  |    100
}