package univaq.disim.sose.monitorservice.entites;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a monitoring device that records traffic violations.
 * This class contains information about the monitor's identity, status, 
 * maximum speed it monitors, and its geographical location.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monitor {

    /**
     * The unique identifier of the monitor.
     * This is the primary key and is auto-generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the monitor.
     */
    private String name;

    /**
     * The operational status of the monitor.
     * True if the monitor is active, false otherwise.
     */
    private boolean status;

    /**
     * The maximum speed that the monitor is set to enforce.
     * Default value is set to 120.
     */
    private int maxSpeed = 120;

    /**
     * The longitude coordinate of the monitor's location.
     */
    private double longitude;

    /**
     * The latitude coordinate of the monitor's location.
     */
    private double latitude;
}
