package univaq.disim.sose.amendservice.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the owner of a vehicle.
 * This class contains information about the owner's identity, birth date, and contact details.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    /**
     * The unique identifier of the owner.
     */
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
}
