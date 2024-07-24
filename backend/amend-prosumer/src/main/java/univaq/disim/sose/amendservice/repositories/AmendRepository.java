package univaq.disim.sose.amendservice.repositories;

import univaq.disim.sose.amendservice.entites.Amend;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for accessing and managing Amend entities in the database.
 * This interface extends JpaRepository to provide CRUD operations and more for Amend entities.
 */
public interface AmendRepository extends JpaRepository<Amend, Long> {
}
