package univaq.disim.sose.monitorservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the data related to a traffic violation.
 * This class contains the ID of the monitor that recorded the violation,
 * the registration number of the vehicle, and the speed of the vehicle.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewData {

    /**
     * The ID of the monitor that recorded the violation.
     */
    private Long monitorId;

    /**
     * The registration number of the vehicle involved in the violation.
     */
    private String rn;

    /**
     * The speed of the vehicle at the time of the violation.
     */
    private double vehicleSpeed;
}
