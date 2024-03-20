package ee.tlu.kodutoo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NumberEntityController {
    private List<NumberEntity> entities = new ArrayList<>();

    @GetMapping("entities")
    public List<NumberEntity> getAllEntities() {
        return entities;
    }

    @PostMapping("entities/{id}/{name}/{description}/{number}")
    public List<NumberEntity> addEntity(
            @PathVariable String name,
            @PathVariable String description,
            @PathVariable int number
    ) {
        NumberEntity newentity = new NumberEntity(name, description, number);
        entities.add(newentity);
        return entities;
    }

    @PutMapping("entities")
    public List<NumberEntity> updateEntity(
            @RequestParam int index,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam int number
    ) {
        NumberEntity newentity = new NumberEntity(name, description, number);
        entities.set(index, newentity);
        return entities;
    }

    @DeleteMapping("toiduained/{index}")
    public List<NumberEntity> kustutaToiduaine(@PathVariable int index) {
        entities.remove(index);
        return entities;
    }

    @GetMapping("/entities/sum")
    public int getEntitiesSum() {
        int sum = 0;
        for (NumberEntity entity : entities) {
            sum += entity.number;
        }
        return sum;
    }
}
