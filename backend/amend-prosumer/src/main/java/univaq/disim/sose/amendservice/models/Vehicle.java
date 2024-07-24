package univaq.disim.sose.amendservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a vehicle involved in traffic violations.
 * This class contains information about the vehicle's identity, manufacturer, model, fiscal power, and its owner.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    /**
     * The unique identifier of the vehicle.
     */
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
     * This is an instance of the Owner class.
     */
    private Owner owner;
}
