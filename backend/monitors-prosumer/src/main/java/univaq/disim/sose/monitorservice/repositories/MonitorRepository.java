package univaq.disim.sose.monitorservice.repositories;

import univaq.disim.sose.monitorservice.entites.Monitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for accessing and managing Monitor entities in the database.
 * This interface extends JpaRepository to provide CRUD operations and additional query methods for Monitor entities.
 */
public interface MonitorRepository extends JpaRepository<Monitor, Long> {

    /**
     * Finds a page of monitors whose names contain the specified string.
     * 
     * @param name the string to search for in monitor names
     * @param pageable the pagination information
     * @return a page of monitors whose names contain the specified string
     */
    Page<Monitor> findByNameContains(String name, Pageable pageable);
}
