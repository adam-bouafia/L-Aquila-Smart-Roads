package univaq.disim.sose.monitorservice.feign;

import univaq.disim.sose.monitorservice.models.Amend;
import univaq.disim.sose.monitorservice.models.NewData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Feign client interface to communicate with the Amend Service.
 * This interface defines methods for interacting with the Amend Service via REST API.
 */
@FeignClient(name = "amend-service")
public interface AmendRestClient {

    /**
     * Sends a POST request to save a new amend.
     *
     * @param newData the data for the new amend
     * @return the saved Amend entity
     */
    @PostMapping("api/amend/saveAmend")
    Amend saveAmend(@RequestBody NewData newData);
}
