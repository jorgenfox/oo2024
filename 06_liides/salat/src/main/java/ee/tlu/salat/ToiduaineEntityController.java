package ee.tlu.salat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // kontroller EHK front-end saab siit ligi
@RequestMapping("/api") // saan igale API otspunktile eesliidese panna
@CrossOrigin(origins = "http://localhost:3000") // see ütleb, mis rakendus mulle ligi pääseb
public class ToiduaineEntityController {
    // ["Kartul", "Vorst"];
    // [{nimi: "Kartul, valk: 0}, {nimi: "Vorst"}]

    //@Autowired
    ToiduaineRepository toiduaineRepository; // ühendan Repository, et saaks ligi andmebaasi päringutele
    //ToiduaineRepository toiduaineRepository = new ToiduaineRepository();

    // Dependency Injection
    public ToiduaineEntityController(ToiduaineRepository toiduaineRepository) {
        this.toiduaineRepository = toiduaineRepository;
    }

//    @Autowired
//    ToiduaineRepository toiduaineRepository;

    //List<ToiduaineEntity> toiduained = new ArrayList<>();

    // localhost:8080/api/toiduained
    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduained() {
        return toiduaineRepository.findAll();
    }

    //localhost:8080/api/toiduained/Vorst/15/5/1
    // ON järjekord tähtis
    // Ma võin kogemata sassi ajada, muutes järjekorda ja paneb valesti
    // Ma ei saa ühtegi vahele jätta

    //localhost:8080/api/toiduained/Vorst/15/5/1
    @PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesik}")
    public List<ToiduaineEntity> lisaToiduaine(
            @PathVariable String nimi,
            @PathVariable int valk,
            @PathVariable int rasv,
            @PathVariable int sysivesik
    ) {
        if (valk + rasv + sysivesik > 100) {
            return toiduaineRepository.findAll();
        }
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaine);
        return toiduaineRepository.findAll();
    }

    @PostMapping("toiduained")
    public List<ToiduaineEntity> lisaToiduaine(@RequestBody ToiduaineEntity toiduaineEntity) {
        if (toiduaineEntity.valk + toiduaineEntity.rasv + toiduaineEntity.sysivesik > 100) {
            return toiduaineRepository.findAll();
        }
        //ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaineEntity);
        return toiduaineRepository.findAll();
    }

    @DeleteMapping("toiduained/{nimi}")
    public List<ToiduaineEntity> kustutaToiduaine(@PathVariable String nimi) {
        toiduaineRepository.deleteById(nimi);
        return toiduaineRepository.findAll();
    }

    // localhost:8080/api/toiduained/Vorst/15/5/1 <-- PathVariable näide
    // localhost:8080/api/toiduained?index=0&nimi=Vorst&valk=15&rasv=5&sysivesik=1
    @PutMapping("toiduained")
    public List<ToiduaineEntity> muudaToiduaine(
            @RequestParam int index,
            @RequestParam String nimi,
            @RequestParam int valk,
            @RequestParam int rasv,
            @RequestParam int sysivesik
    ) {
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        //toiduained.set(index, toiduaine);
        toiduaineRepository.save(toiduaine); // täpselt sama mis POST
        // Hibernate kontrollib, kas on juba sellise primaarvõtmega element andmebaasis
        return toiduaineRepository.findAll();
    }

    @GetMapping("toiduained/{nimi}")
    public ToiduaineEntity saaYksToiduaine(@PathVariable String nimi) {
        return toiduaineRepository.findById(nimi).get();
    }

    @GetMapping("toiduainete-koguarv")
    public int toiduaineteKoguarv() {
        return toiduaineRepository.findAll().size();
    }

}
