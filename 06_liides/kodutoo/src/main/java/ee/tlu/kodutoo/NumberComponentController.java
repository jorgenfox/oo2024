package ee.tlu.kodutoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class NumberComponentController {
    @Autowired
    NumberComponentRepository numberComponentRepository;

    @GetMapping("numbercomponents")
    public List<NumberComponent> getNumberComponents() {
        return numberComponentRepository.findAll();
    }

    @DeleteMapping("numbercomponents/{id}")
    public List<NumberComponent> deleteNumberComponent(@PathVariable Long id) {
        numberComponentRepository.deleteById(id);
        return numberComponentRepository.findAll();
    }

    @PostMapping("numbercomponents")
    public List<NumberComponent> addNumberComponent(@RequestBody NumberComponent numberComponent) {
        numberComponentRepository.save(numberComponent);
        return numberComponentRepository.findAll();
    }
}
