package univaq.disim.sose.amendservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the data related to a traffic violation that includes
 * the monitor ID, the vehicle's registration number, and the speed of the vehicle.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
