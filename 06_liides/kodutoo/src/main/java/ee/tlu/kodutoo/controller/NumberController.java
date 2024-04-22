package ee.tlu.kodutoo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class NumberController {
    private List<Integer> numbers = new ArrayList<>();

    @GetMapping("/numbers")
    public List<Integer> getAllNumbers() {
        return numbers;
    }

    @PostMapping("/numbers/add")
    public void addNumber(@RequestBody int number) {
        numbers.add(number);
    }

    @DeleteMapping("/numbers/{index}")
    public void deleteNumber(@PathVariable int index) {
        if (index >= 0 && index < numbers.size()) {
            numbers.remove(index);
        }
    }

    @GetMapping("/numbers/count")
    public int getCount() {
        return numbers.size();
    }

    @GetMapping("/numbers/sum")
    public int getSum() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    @GetMapping("/numbers/average")
    public double getAverage() {
        if (numbers.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum / numbers.size();
    }
}
