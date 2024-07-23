package univaq.disim.sose.amendservice.feign;

import univaq.disim.sose.amendservice.models.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign client interface to communicate with the Vehicle Service.
 * This interface defines methods for interacting with the Vehicle Service via REST API.
 */
@FeignClient(name = "vehicles-service")
public interface VehicleRestClient {

    /**
     * Fetches a Vehicle entity by its registration number from the Vehicle Service.
     *
     * @param rn the registration number of the vehicle to retrieve
     * @return the Vehicle entity with the specified registration number
     */
    @GetMapping("api/vehicle/vehicleByRn/{rn}")
    Vehicle getByRegistrationNumber(@PathVariable String rn);
}
