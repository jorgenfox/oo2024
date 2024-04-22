package ee.tlu.kodutoo.repository;

import ee.tlu.kodutoo.entity.NumberComponent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberComponentRepository extends JpaRepository<NumberComponent, Long> {
}
