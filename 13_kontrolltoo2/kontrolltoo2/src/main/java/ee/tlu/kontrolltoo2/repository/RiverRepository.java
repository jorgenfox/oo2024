package ee.tlu.kontrolltoo2.repository;

import ee.tlu.kontrolltoo2.entity.Lake;
import ee.tlu.kontrolltoo2.entity.RiverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiverRepository extends JpaRepository<RiverEntity, Long> {

    // Leia kõige kiirem jõgi
    RiverEntity findTopByOrderByKiirusDesc();

    // Leia kõige aeglasem jõgi
    RiverEntity findTopByOrderByKiirusAsc();
}
