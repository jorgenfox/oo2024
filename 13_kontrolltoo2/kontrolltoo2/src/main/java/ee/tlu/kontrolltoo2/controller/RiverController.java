package ee.tlu.kontrolltoo2.controller;

import ee.tlu.kontrolltoo2.entity.RiverEntity;
import ee.tlu.kontrolltoo2.repository.LakeRepository;
import ee.tlu.kontrolltoo2.repository.RiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RiverController {

    @Autowired
    RiverRepository riverRepository;

    @GetMapping("rivers")
    public List<RiverEntity> getAllRivers() {
        return riverRepository.findAll();
    }

    @PostMapping("rivers")
    public List<RiverEntity> addRiver(@RequestBody RiverEntity riverEntity) {
        riverRepository.save(riverEntity);
        return riverRepository.findAll();
    }

    @DeleteMapping("rivers/{id}")
    public List<RiverEntity> deleteRiver(@PathVariable Long id) {
        riverRepository.deleteById(id);
        return riverRepository.findAll();
    }

    @GetMapping("/rivers/{id}/distance")
    public int calculateDistance(@PathVariable Long id) {
        RiverEntity river = riverRepository.findById(id).orElse(null);
        if (river == null) {
            throw new RuntimeException("River not found with id: " + id);
        }

        double distanceInPixels = calculateDistanceInPixels(river.getLahtmeX(), river.getLahtmeY(), river.getSuudmeX(), river.getSuudmeY());

        return (int) distanceInPixels;
    }

    private int calculateDistanceInPixels(double lahtmeX, double lahtmeY, double suudmeX, double suudmeY) {

        double distance = (int) Math.sqrt(Math.pow((suudmeX - lahtmeX), 2) + Math.pow((suudmeY - lahtmeY), 2));
        return (int) distance;
    }

    @GetMapping("/rivers/fastest")
    public RiverEntity getFastestRiver() {
        return riverRepository.findTopByOrderByKiirusDesc();
    }

    @GetMapping("/rivers/slowest")
    public RiverEntity getSlowestRiver() {
        return riverRepository.findTopByOrderByKiirusAsc();
    }
}
