package univaq.disim.sose.monitorservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Represents an amend (fine) for a traffic violation.
 * This class contains details about the violation, including the date, monitor ID, vehicle information, speeds, and the amount of the fine.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Amend {

    /**
     * The date when the traffic violation occurred.
     */
    private Date date;

    /**
     * The ID of the monitor that recorded the violation.
     */
    private Long monitorId;

    /**
     * The matricule (registration number) of the vehicle involved in the violation.
     */
    private String vehicleMatricule;

    /**
     * The speed of the vehicle at the time of the violation.
     */
    private double vehicleSpeed;

    /**
     * The maximum speed allowed as recorded by the monitor.
     */
    private double monitorMaxSpeed;

    /**
     * The amount of the fine for the violation.
     */
    private double amendAmount;
}
