package galerie.dao;

import galerie.entity.Exposition;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring 

public interface ExpositionRepository extends JpaRepository<Exposition, Integer> {

}
