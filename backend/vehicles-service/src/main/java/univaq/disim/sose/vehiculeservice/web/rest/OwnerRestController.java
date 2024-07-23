package univaq.disim.sose.vehiculeservice.web.rest;

import univaq.disim.sose.vehiculeservice.entites.Owner;
import univaq.disim.sose.vehiculeservice.repositories.OwnerRepository;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

/**
 * REST controller for handling owner-related requests.
 */
@RestController
@RequestMapping("/api/owner")
@Tag(name = "Owner API", description = "API for managing vehicle owners")
public class OwnerRestController {
    
    // Repository for accessing owner data
    private final OwnerRepository ownerRepository;

    // Constructor-based dependency injection
    public OwnerRestController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    /**
     * Get all owners.
     * 
     * @return List of all owners.
     */
    @Operation(summary = "Get all owners", description = "Retrieve a list of all vehicle owners")
    @GetMapping("/owners")
    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    /**
     * Get owner by ID.
     * 
     * @param id The ID of the owner.
     * @return The owner with the specified ID.
     */
    @Operation(summary = "Get owner by ID", description = "Retrieve a vehicle owner by their ID")
    @GetMapping("/owners/{id}")
    public Owner getOwnerById(@Parameter(description = "ID of the owner to be retrieved") @PathVariable Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Owner %s not found!", id)));
    }

    /**
     * Save a new owner.
     * 
     * @param owner The owner entity to save.
     * @return The saved owner entity.
     */
    @Operation(summary = "Save a new owner", description = "Save a new vehicle owner")
    @PostMapping("/owners")
    public Owner saveOwner(@Parameter(description = "Owner entity to be saved") @RequestBody Owner owner) {
        return ownerRepository.save(owner);
    }

    /**
     * Update an existing owner.
     * 
     * @param id The ID of the owner to update.
     * @param owner The owner entity with updated data.
     * @return The updated owner entity.
     */
    @Operation(summary = "Update an existing owner", description = "Update a vehicle owner by their ID")
    @PutMapping("/owners/{id}")
    public Owner updateOwner(
        @Parameter(description = "ID of the owner to be updated") @PathVariable Long id, 
        @Parameter(description = "Updated owner entity") @RequestBody Owner owner) {
        
        Owner existingOwner = ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Owner %s not found!", id)));

        // Update fields if they are not null
        if (owner.getName() != null) existingOwner.setName(owner.getName());
        if (owner.getEmail() != null) existingOwner.setEmail(owner.getEmail());
        if (owner.getBirthDate() != null) existingOwner.setBirthDate(owner.getBirthDate());
        if (owner.getVehicles() != null) existingOwner.setVehicles(owner.getVehicles());

        return ownerRepository.save(existingOwner);
    }

    /**
     * Delete an owner by ID.
     * 
     * @param id The ID of the owner to delete.
     */
    @Operation(summary = "Delete an owner by ID", description = "Delete a vehicle owner by their ID")
    @DeleteMapping("/owners/{id}")
    public void deleteOwner(@Parameter(description = "ID of the owner to be deleted") @PathVariable Long id) {
        ownerRepository.deleteById(id);
    }
}
