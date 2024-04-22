package ee.tlu.salat.repository;

import ee.tlu.salat.entity.ToiduaineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToiduaineRepository extends JpaRepository<ToiduaineEntity, String> {
    // Saan siia kirjutada custom repository käske, mis tagastavad kas
    // ToiduaineEntity või List<ToiduaineEntity>

    // SELECT * FROM Toiduained WHERE valk >= 5;
    // JPA Buddy
    List<ToiduaineEntity> findAllByValkGreaterThan(int valk);

    // SELECT * FROM Toiduained WHERE sysivesik >= 5 AND sysivesik <= 10;
    List<ToiduaineEntity> findAllBySysivesikBetween(int min, int max);


    //@Query("SELECT t FROM Toiduained WHERE t.valk >= 5")
    //List<ToiduaineEntity> leiaKoikKellelValkSuurem(int valk);


}