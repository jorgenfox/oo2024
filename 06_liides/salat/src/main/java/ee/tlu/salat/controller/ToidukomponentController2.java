package ee.tlu.salat.controller;

import ee.tlu.salat.entity.Toidukomponent;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToidukomponentController2 {
    List<Toidukomponent> toidukomponendid = new ArrayList<>();

    @PostMapping("toidukomponent")
    public List<Toidukomponent> lisaToidukomponent(@RequestBody Toidukomponent komponent) {
        toidukomponendid.add(komponent);
        return toidukomponendid;
    }

    @PutMapping("toidukomponent/{index}")
    public List<Toidukomponent> muudaToidukomponent(@PathVariable int index, @RequestBody Toidukomponent komponent) {
        toidukomponendid.set(index, komponent);
        return toidukomponendid;
    }
}
