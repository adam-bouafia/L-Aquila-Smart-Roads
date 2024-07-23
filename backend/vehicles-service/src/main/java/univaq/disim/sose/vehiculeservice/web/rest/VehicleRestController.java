package univaq.disim.sose.vehiculeservice.web.rest;

import univaq.disim.sose.vehiculeservice.entites.Vehicle;
import univaq.disim.sose.vehiculeservice.repositories.VehicleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

/**
 * REST controller for handling vehicle-related requests.
 */
@RestController
@RequestMapping("/api/vehicle")
@Tag(name = "Vehicle API", description = "API for managing vehicles")
public class VehicleRestController {

    // Repository for accessing vehicle data
    private final VehicleRepository vehicleRepository;

    // Constructor-based dependency injection
    public VehicleRestController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * Get all vehicles.
     * 
     * @return List of all vehicles.
     */
    @Operation(summary = "Get all vehicles", description = "Retrieve a list of all vehicles")
    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    /**
     * Get vehicle by ID.
     * 
     * @param id The ID of the vehicle.
     * @return The vehicle with the specified ID.
     */
    @Operation(summary = "Get vehicle by ID", description = "Retrieve a vehicle by its ID")
    @GetMapping("/vehicles/{id}")
    public Vehicle getVehicleById(@Parameter(description = "ID of the vehicle to be retrieved") @PathVariable Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Vehicle %s not found!", id)));
    }

    /**
     * Save a new vehicle.
     * 
     * @param vehicle The vehicle entity to save.
     * @return The saved vehicle entity.
     */
    @Operation(summary = "Save a new vehicle", description = "Save a new vehicle")
    @PostMapping("/vehicles")
    public Vehicle saveVehicle(@Parameter(description = "Vehicle entity to be saved") @RequestBody Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    /**
     * Update an existing vehicle.
     * 
     * @param id The ID of the vehicle to update.
     * @param vehicle The vehicle entity with updated data.
     * @return The updated vehicle entity.
     */
    @Operation(summary = "Update an existing vehicle", description = "Update a vehicle by its ID")
    @PutMapping("/vehicles/{id}")
    public Vehicle updateVehicle(
        @Parameter(description = "ID of the vehicle to be updated") @PathVariable Long id, 
        @Parameter(description = "Updated vehicle entity") @RequestBody Vehicle vehicle) {
        
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Vehicle %s not found!", id)));

        // Update fields if they are not null
        if (vehicle.getModel() != null) existingVehicle.setModel(vehicle.getModel());
        if (vehicle.getManufacturer() != null) existingVehicle.setManufacturer(vehicle.getManufacturer());
        if (vehicle.getFiscalPower() != null) existingVehicle.setFiscalPower(vehicle.getFiscalPower());
        if (vehicle.getRegistrationNumber() != null) existingVehicle.setRegistrationNumber(vehicle.getRegistrationNumber());
        if (vehicle.getOwner() != null) existingVehicle.setOwner(vehicle.getOwner());

        return vehicleRepository.save(existingVehicle);
    }

    /**
     * Delete a vehicle by ID.
     * 
     * @param id The ID of the vehicle to delete.
     */
    @Operation(summary = "Delete a vehicle by ID", description = "Delete a vehicle by its ID")
    @DeleteMapping("/vehicles/{id}")
    public void deleteVehicle(@Parameter(description = "ID of the vehicle to be deleted") @PathVariable Long id) {
        vehicleRepository.deleteById(id);
    }

    /**
     * Get a paginated list of vehicles.
     * 
     * @param page The page number to retrieve.
     * @param size The size of the page to retrieve.
     * @return A page of vehicles.
     */
    @Operation(summary = "Get a paginated list of vehicles", description = "Retrieve a paginated list of vehicles")
    @GetMapping("/pageVehicle")
    public Page<Vehicle> getPageVehicle(
            @Parameter(description = "Page number to retrieve") @RequestParam(value = "page", defaultValue = "0") int page,
            @Parameter(description = "Size of the page to retrieve") @RequestParam(value = "size", defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return vehicleRepository.findAll(pageable);
    }

    /**
     * Search vehicles by registration number containing a keyword, with pagination.
     * 
     * @param keyword The keyword to search for in registration numbers.
     * @param page The page number to retrieve.
     * @param size The size of the page to retrieve.
     * @return A page of vehicles matching the keyword.
     */
    @Operation(summary = "Search vehicles by registration number", description = "Search for vehicles by registration number containing a keyword, with pagination")
    @GetMapping("/pageVehicleName/{keyword}")
    public Page<Vehicle> getVehiclesByName(
            @Parameter(description = "Keyword to search for in registration numbers") @PathVariable String keyword,
            @Parameter(description = "Page number to retrieve") @RequestParam(value = "page", defaultValue = "0") int page,
            @Parameter(description = "Size of the page to retrieve") @RequestParam(value = "size", defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        if (keyword == null) return vehicleRepository.findAll(pageable);
        return vehicleRepository.findByRegistrationNumberContaining(keyword, pageable);
    }

    /**
     * Get the total number of vehicles.
     * 
     * @return The count of all vehicles.
     */
    @Operation(summary = "Get the total number of vehicles", description = "Retrieve the total number of vehicles")
    @GetMapping("/count")
    public Long getVehiclesCount() {
        return vehicleRepository.count();
    }

    /**
     * Get a vehicle by its registration number.
     * 
     * @param rn The registration number of the vehicle.
     * @return The vehicle with the specified registration number.
     */
    @Operation(summary = "Get a vehicle by registration number", description = "Retrieve a vehicle by its registration number")
    @GetMapping("/vehicleByRn/{rn}")
    public Vehicle getByRegistrationNumber(@Parameter(description = "Registration number of the vehicle to be retrieved") @PathVariable String rn) {
        return vehicleRepository.findVehicleByRegistrationNumber(rn);
    }
}
