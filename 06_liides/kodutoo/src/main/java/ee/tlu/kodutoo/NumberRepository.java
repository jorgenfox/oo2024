package ee.tlu.kodutoo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<NumberEntity, String> {
}
