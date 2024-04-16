package ee.tlu.salat.controller;

import ee.tlu.salat.entity.Toidukomponent;
import ee.tlu.salat.repository.ToidukomponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class ToidukomponentController {

    @Autowired
    ToidukomponentRepository toidukomponentRepository;

    // Bean ---> automaatselt loodav klass kui rakendus käivitub (new Class();)
    // @Autowired ---> samaväärne kui allolev constructor, tõmbab Repository siia sisse

    //public ToidukomponentController(ToidukomponentRepository toidukomponentRepository) {
    //    this.toidukomponentRepository = toidukomponentRepository;
    //}

    // Saaks andmebaasist päringuid teha.
    // INSERT INTO Toidukomponent VALUES("") --->  repository.save("");
    // DELETE FROM Toidukomponent WHERE id = 5  ---> repository.deleteById(5);
    // SELECT * FROM Toidukomponent  ---> repository.findAll();

    // http://localhost:8080/toidukomponendid
    @GetMapping("toidukomponendid")
    public List<Toidukomponent> getToidukomponents() {
        return toidukomponentRepository.findAll();
    }

    // --> PathVariable: http://localhost:8080/toidukomponendid/4
    // RequestParam: http://localhost:8080/toidukomponendid?id=4
    @DeleteMapping("toidukomponendid/{id}")
    public List<Toidukomponent> deleteToidukomponent(@PathVariable Long id) {
        toidukomponentRepository.deleteById(id);
        return toidukomponentRepository.findAll();
    }

    @PostMapping("toidukomponendid")
    public List<Toidukomponent> addToidukomponent(@RequestBody Toidukomponent toidukomponent) {
        toidukomponentRepository.save(toidukomponent);
        return toidukomponentRepository.findAll();
    }

}