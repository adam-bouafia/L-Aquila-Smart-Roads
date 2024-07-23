package univaq.disim.sose.amendservice.feign;

import univaq.disim.sose.amendservice.models.Monitor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign client interface to communicate with the Monitor Service.
 * This interface defines methods for interacting with the Monitor Service via REST API.
 */
@FeignClient(name = "monitor-service")
public interface MonitorRestClient {

    /**
     * Fetches a Monitor entity by its ID from the Monitor Service.
     *
     * @param id the ID of the monitor to retrieve
     * @return the Monitor entity with the specified ID
     */
    @GetMapping("monitors/{id}")
    Monitor getByMonitorById(@PathVariable Long id);
}
