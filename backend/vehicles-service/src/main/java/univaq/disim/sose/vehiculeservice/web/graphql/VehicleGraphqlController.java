package univaq.disim.sose.vehiculeservice.web.graphql;

import univaq.disim.sose.vehiculeservice.entites.Vehicle;
import univaq.disim.sose.vehiculeservice.repositories.VehicleRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * GraphQL controller for handling operations related to Vehicle entities.
 */
@Controller
public class VehicleGraphqlController {
    
    private final VehicleRepository vehicleRepository;

    /**
     * Constructor for dependency injection of VehicleRepository.
     * @param vehicleRepository the repository to interact with Vehicle entities
     */
    public VehicleGraphqlController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * Query to get all vehicles.
     * @return a list of all vehicles
     */
    @QueryMapping
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    /**
     * Query to get a vehicle by ID.
     * @param id the ID of the vehicle to retrieve
     * @return the vehicle with the specified ID
     * @throws RuntimeException if the vehicle is not found
     */
    @QueryMapping
    public Vehicle getVehicleById(@Argument Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Vehicle %s not found! ", id)));
    }

    /**
     * Mutation to add a new vehicle.
     * @param vehicle the vehicle to add
     * @return the added vehicle
     */
    @MutationMapping
    public Vehicle addVehicle(@Argument Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    /**
     * Mutation to delete a vehicle by ID.
     * @param id the ID of the vehicle to delete
     * @return true if the vehicle was deleted successfully
     */
    @MutationMapping
    public Boolean deleteVehicle(@Argument Long id) {
        vehicleRepository.deleteById(id);
        return true;
    }
}
