package univaq.disim.sose.vehiculeservice.repositories;

import univaq.disim.sose.vehiculeservice.entites.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Owner entities.
 * Extends JpaRepository to provide CRUD operations on Owner entities.
 */
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
