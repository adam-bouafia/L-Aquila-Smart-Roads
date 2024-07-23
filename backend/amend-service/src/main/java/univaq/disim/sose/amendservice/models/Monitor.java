package univaq.disim.sose.amendservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a monitoring device that records traffic violations.
 * This class contains information about the monitor's identity, status, 
 * maximum speed it monitors, and its geographical location.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monitor {
    
    /**
     * The unique identifier of the monitor.
     */
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
     */
    private int maxSpeed;
    
    /**
     * The longitude coordinate of the monitor's location.
     */
    private double longitude;
    
    /**
     * The latitude coordinate of the monitor's location.
     */
    private double latitude;
}
