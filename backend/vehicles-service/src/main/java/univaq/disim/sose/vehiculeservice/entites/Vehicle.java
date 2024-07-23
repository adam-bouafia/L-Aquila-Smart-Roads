package univaq.disim.sose.vehiculeservice.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representing a Vehicle.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    /**
     * The unique identifier for the vehicle.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The registration number of the vehicle.
     */
    private String registrationNumber;

    /**
     * The manufacturer of the vehicle.
     */
    private String manufacturer;

    /**
     * The fiscal power of the vehicle.
     */
    private Double fiscalPower;

    /**
     * The model of the vehicle.
     */
    private String model;

    /**
     * The owner of the vehicle.
     * This is a many-to-one relationship with the Owner entity.
     */
    @ManyToOne
    private Owner owner;
}
