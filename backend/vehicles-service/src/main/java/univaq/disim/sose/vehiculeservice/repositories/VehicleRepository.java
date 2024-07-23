package univaq.disim.sose.vehiculeservice.repositories;

import univaq.disim.sose.vehiculeservice.entites.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Vehicle entities.
 * Extends JpaRepository to provide CRUD operations on Vehicle entities.
 */
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    /**
     * Find a vehicle by its registration number.
     * @param rn the registration number of the vehicle
     * @return the vehicle with the specified registration number
     */
    Vehicle findVehicleByRegistrationNumber(String rn);

    /**
     * Find vehicles by registration number containing the specified keyword.
     * Supports pagination.
     * @param keyword the keyword to search for within the registration number
     * @param pageable the pagination information
     * @return a page of vehicles with registration numbers containing the keyword
     */
    Page<Vehicle> findByRegistrationNumberContaining(String keyword, Pageable pageable);
}
