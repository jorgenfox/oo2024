package ee.tlu.salat.repository;

import ee.tlu.salat.entity.Toidukomponent;
import org.springframework.data.jpa.repository.JpaRepository;

// extends CrudRepository<>
// extends SortingAndPagingRepository<>
public interface ToidukomponentRepository extends JpaRepository<Toidukomponent, Long> {
}