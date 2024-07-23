package univaq.disim.sose.datageneratorservice.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Represents a vehicle involved in traffic violations.
 * This class contains information about the vehicle's identity, manufacturer, model, and fiscal power.
 */
@Data
@Schema(description = "Represents a vehicle involved in traffic violations.")
public class Vehicle {

    @Schema(description = "The unique identifier of the vehicle.")
    private Long id;

    @Schema(description = "The registration number of the vehicle.")
    private String registrationNumber;

    @Schema(description = "The manufacturer of the vehicle.")
    private String manufacturer;

    @Schema(description = "The fiscal power of the vehicle.")
    private Double fiscalPower;

    @Schema(description = "The model of the vehicle.")
    private String model;
}
