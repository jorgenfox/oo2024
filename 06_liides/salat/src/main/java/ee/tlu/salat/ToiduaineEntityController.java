package ee.tlu.salat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToiduaineEntityController {

    ToiduaineRepository toiduaineRepository;

    public ToiduaineEntityController(ToiduaineRepository toiduaineRepository){
        this.toiduaineRepository = toiduaineRepository;
    }

//    @Autowired
//    ToiduaineRepository toiduaineRepository;
    // List<ToiduaineEntity> toiduained = new ArrayList<>(); // imiteerime andmebaasi

    // localhost:8080/api/toiduained
    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduained() {
        return toiduaineRepository.findAll();
    }

    // localhost:8080/api/toiduained/Kartul/10/5/5
    // ON jarjekord tahtis
    // ma voin kogemata sassi ajada, muutes jarjekorda ja paneb valesti
    // ma ei saa uhtegi vahele jatta
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
    public List<ToiduaineEntity> lisaToiduained(@RequestBody ToiduaineEntity toiduaineEntity) {
        if (toiduaineEntity.valk + toiduaineEntity.rasv + toiduaineEntity.sysivesik > 100) {
            return toiduaineRepository.findAll();
        }
        // ToiduaineEntity toiduaine = new ToiduaineEntity(nimetus, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaineEntity);
        return toiduaineRepository.findAll();
    }

    @DeleteMapping("toiduained/{nimi}")
    public List<ToiduaineEntity> kustutaToiduaine(@PathVariable String nimi) {
        toiduaineRepository.deleteById(nimi);
        return toiduaineRepository.findAll();
    }

    // localhost:8080/api/toiduained?index=0&nimi=Kartul&valk=10&rasv=5&sysivesik=5
    // lubab mingil moel vahele jatta mingid vaartused
    @PutMapping("toiduained")
    public List<ToiduaineEntity> muudaToiduaine(
            @RequestParam String nimi,
            @RequestParam int valk,
            @RequestParam int rasv,
            @RequestParam int sysivesik
    ) {
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaine); // tapselt sama, mis POST
        // Hibernate kontrollib, kas on juba sellise primaarvotmega element andmebaasis
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