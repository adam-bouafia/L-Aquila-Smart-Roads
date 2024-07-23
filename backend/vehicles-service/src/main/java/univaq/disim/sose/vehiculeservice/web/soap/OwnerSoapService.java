package univaq.disim.sose.vehiculeservice.web.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import univaq.disim.sose.vehiculeservice.entites.Owner;
import univaq.disim.sose.vehiculeservice.repositories.OwnerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * SOAP Web Service for managing Owner entities.
 */
@Component
@WebService
@AllArgsConstructor
public class OwnerSoapService {

    private final OwnerRepository ownerRepository; // Repository for accessing Owner data

    /**
     * Retrieves all owners.
     *
     * @return a list of all owners
     */
    @WebMethod
    public List<Owner> getOwners(){
        return ownerRepository.findAll();
    }

    /**
     * Retrieves an owner by their ID.
     *
     * @param id the ID of the owner
     * @return the owner with the specified ID
     */
    @WebMethod
    public Owner getOwnerById(@WebParam(name = "id") Long id){
        return ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Owner with ID %s not found!", id)));
    }
}
