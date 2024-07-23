package univaq.disim.sose.vehiculeservice.web.soap;

import univaq.disim.sose.vehiculeservice.entites.Owner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller to handle SOAP service requests for Owner entities.
 */
@RestController
@RequestMapping("/api/soap/owner")
public class OwnerSoapController {

    private final OwnerSoapService ownerSoapService; // Service to handle SOAP operations for Owner entities.

    /**
     * Constructor to inject OwnerSoapService.
     *
     * @param ownerSoapService the service to handle SOAP operations
     */
    public OwnerSoapController(OwnerSoapService ownerSoapService) {
        this.ownerSoapService = ownerSoapService;
    }

    /**
     * Get all owners using SOAP service.
     *
     * @return a list of all owners
     */
    @GetMapping("/owners")
    public List<Owner> getOwners() {
        return ownerSoapService.getOwners();
    }

    /**
     * Get owner by ID using SOAP service.
     *
     * @param id the ID of the owner
     * @return the owner with the specified ID
     */
    @GetMapping("/owners/{id}")
    public Owner getOwnerById(@PathVariable("id") Long id) {
        return ownerSoapService.getOwnerById(id);
    }
}
