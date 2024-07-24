package univaq.disim.sose.amendservice.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import univaq.disim.sose.amendservice.models.Monitor;
import univaq.disim.sose.amendservice.models.Vehicle;

import java.util.Date;

/**
 * Represents an amend for a traffic violation.
 * This entity captures the details of a traffic fine including 
 * information about the vehicle, speed, and the monitoring device.
 */
@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class Amend {

    /**
     * The unique identifier for this amend.
     * This is the primary key and is auto-generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The date when the traffic violation occurred.
     */
    private Date date;

    /**
     * Indicates whether the amend has been paid or not.
     */
    private boolean paid;

    /**
     * The ID of the monitor that recorded the violation.
     * This relates to the Monitor entity.
     */
    private Long monitorId;

    /**
     * The matricule (registration number) of the vehicle involved in the violation.
     */
    private String vehicleMatricule;

    /**
     * The vehicle involved in the violation.
     * This field is marked as transient, meaning it is not persisted in the database.
     * It is used to store the vehicle information retrieved from another service.
     */
    @Transient
    private Vehicle vehicle;

    /**
     * The speed of the vehicle at the time of the violation.
     */
    private double vehicleSpeed;

    /**
     * The monitor that recorded the violation.
     * This field is marked as transient, meaning it is not persisted in the database.
     * It is used to store the monitor information retrieved from another service.
     */
    @Transient
    private Monitor monitor;

    /**
     * The maximum speed allowed as recorded by the monitor.
     */
    private double monitorMaxSpeed;

    /**
     * The amount of the fine for the violation.
     */
    private double amendAmount;
}
