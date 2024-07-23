package univaq.disim.sose.datageneratorservice.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Represents a monitoring device that records traffic violations.
 * This class contains information about the monitor's identity, status, 
 * maximum speed it monitors, and its geographical location.
 */
@Data
@Schema(description = "Represents a monitoring device that records traffic violations.")
public class Monitor {

    @Schema(description = "The unique identifier of the monitor.")
    private Long id;

    @Schema(description = "The name of the monitor.")
    private String name;

    @Schema(description = "The operational status of the monitor. True if the monitor is active, false otherwise.")
    private boolean status;

    @Schema(description = "The maximum speed that the monitor is set to enforce.")
    private int maxSpeed;

    @Schema(description = "The longitude coordinate of the monitor's location.")
    private double longitude;

    @Schema(description = "The latitude coordinate of the monitor's location.")
    private double latitude;
}
