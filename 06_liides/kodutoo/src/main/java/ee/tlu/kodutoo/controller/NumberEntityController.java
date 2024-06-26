package ee.tlu.kodutoo.controller;

import ee.tlu.kodutoo.entity.NumberEntity;
import ee.tlu.kodutoo.repository.NumberRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class NumberEntityController {
    NumberRepository numberRepository;

    public NumberEntityController(NumberRepository numberRepository){
        this.numberRepository = numberRepository;
    }

    @GetMapping("entities")
    public List<NumberEntity> getAllEntities() {
        return numberRepository.findAll();
    }

    @PostMapping("entities/{name}/{description}/{number}")
    public List<NumberEntity> addEntity(
            @PathVariable String name,
            @PathVariable String description,
            @PathVariable int number
    ) {
        NumberEntity newentity = new NumberEntity(name, description, number);
        numberRepository.save(newentity);
        return numberRepository.findAll();
    }

    @PostMapping("entities")
    public List<NumberEntity> addEntity(@RequestBody NumberEntity numbriEntity) {
        numberRepository.save(numbriEntity);
        return numberRepository.findAll();
    }

    @PutMapping("entities")
    public List<NumberEntity> updateEntity(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam int number
    ) {
        NumberEntity newentity = new NumberEntity(name, description, number);
        numberRepository.save(newentity); // tapselt sama, mis POST
        // Hibernate kontrollib, kas on juba sellise primaarvotmega element andmebaasis
        return numberRepository.findAll();
    }

    @DeleteMapping("entities/{name}")
    public List<NumberEntity> kustutaToiduaine(@PathVariable String name) {
        numberRepository.deleteById(name);
        return numberRepository.findAll();
    }

    @GetMapping("entities/sum")
    public int getEntitiesSum() {
        int sum = 0;
        List<NumberEntity> entities = numberRepository.findAll();
        for (NumberEntity entity : entities) {
            sum += entity.getNumber();
        }
        return sum;
    }
}
