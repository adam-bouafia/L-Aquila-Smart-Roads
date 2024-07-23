package univaq.disim.sose.datageneratorservice.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
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
@Schema(description = "Represents the data related to a traffic violation.")
public class NewData {

    @Schema(description = "The ID of the monitor that recorded the violation.")
    private Long monitorId;

    @Schema(description = "The registration number of the vehicle involved in the violation.")
    private String rn;

    @Schema(description = "The speed of the vehicle at the time of the violation.")
    private double vehicleSpeed;
}
