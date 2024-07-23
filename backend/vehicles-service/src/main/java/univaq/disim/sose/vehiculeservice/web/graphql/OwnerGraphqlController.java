package univaq.disim.sose.vehiculeservice.web.graphql;

import univaq.disim.sose.vehiculeservice.entites.Owner;
import univaq.disim.sose.vehiculeservice.entites.OwnerRequest;
import univaq.disim.sose.vehiculeservice.repositories.OwnerRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * GraphQL controller for handling operations related to Owner entities.
 */
@Controller
public class OwnerGraphqlController {

    private final OwnerRepository ownerRepository;

    /**
     * Constructor for dependency injection of OwnerRepository.
     * @param ownerRepository the repository to interact with Owner entities
     */
    public OwnerGraphqlController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    /**
     * Query to get all owners.
     * @return a list of all owners
     */
    @QueryMapping
    public List<Owner> getOwners(){
        return ownerRepository.findAll();
    }

    /**
     * Query to get an owner by ID.
     * @param id the ID of the owner to retrieve
     * @return the owner with the specified ID
     * @throws RuntimeException if the owner is not found
     */
    @QueryMapping
    public Owner getOwnerById(@Argument Long id){
        return ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Owner %s not found ! ", id)));
    }

    /**
     * Mutation to add a new owner.
     * @param owner the details of the owner to add
     * @return the added owner
     */
    @MutationMapping
    public Owner addOwner(@Argument OwnerRequest owner){
        Owner o = new Owner();
        o.setName(owner.getName());
        o.setEmail(owner.getEmail());
        o.setBirthDate(owner.getBirthDate());
        return ownerRepository.save(o);
    }

    /**
     * Mutation to delete an owner by ID.
     * @param id the ID of the owner to delete
     * @return true if the owner was deleted successfully
     */
    @MutationMapping
    public Boolean deleteOwner(@Argument Long id){
        ownerRepository.deleteById(id);
        return true;
    }
}
