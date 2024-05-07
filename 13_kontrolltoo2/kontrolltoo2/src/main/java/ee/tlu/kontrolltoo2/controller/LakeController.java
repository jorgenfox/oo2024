package ee.tlu.kontrolltoo2.controller;

import ee.tlu.kontrolltoo2.repository.LakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LakeController {

    @Autowired
    LakeRepository lakeRepository;
}
