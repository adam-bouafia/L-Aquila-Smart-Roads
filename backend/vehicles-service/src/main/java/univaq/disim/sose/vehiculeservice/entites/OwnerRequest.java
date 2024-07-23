package univaq.disim.sose.vehiculeservice.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * DTO for creating or updating an Owner.
 * Used in GraphQL operations.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerRequest {

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

