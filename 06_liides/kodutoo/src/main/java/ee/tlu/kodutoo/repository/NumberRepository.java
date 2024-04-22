package ee.tlu.kodutoo.repository;

import ee.tlu.kodutoo.entity.NumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<NumberEntity, String> {
}
