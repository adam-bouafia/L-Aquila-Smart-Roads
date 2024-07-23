package univaq.disim.sose.vehiculeservice.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * Entity representing an owner of vehicles.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "vehicles", includeFieldNames = false)
public class Owner {
    
    /**
     * The unique identifier for the owner.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * The name of the owner.
     */
    private String name;
    
    /**
     * The birth date of the owner.
     */
    private Date birthDate;
    
    /**
     * The email address of the owner.
     */
    private String email;

    /**
     * The list of vehicles owned by the owner.
     * This field is not persisted in the database and is only used for serialization.
     */
    @Transient
    // Load vehicles eagerly (i.e., load all vehicles when the owner is loaded)
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Vehicle> vehicles;
}
