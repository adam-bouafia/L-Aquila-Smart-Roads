package univaq.disim.sose.monitorservice.web;

import univaq.disim.sose.monitorservice.entites.Monitor;
import univaq.disim.sose.monitorservice.feign.AmendRestClient;
import univaq.disim.sose.monitorservice.models.Amend;
import univaq.disim.sose.monitorservice.models.NewData;
import univaq.disim.sose.monitorservice.repositories.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.Date;
import java.util.List;

/**
 * Rest Controller for managing Monitor entities.
 */
@RestController
@RestResource
@RequestMapping("/api/monitor")
@Component
@Tag(name = "Monitor API", description = "API for managing monitors")
public class MonitorRestController {
    private MonitorRepository monitorRepository;
    private AmendRestClient amendRestClient;

    @Autowired
    public MonitorRestController(MonitorRepository monitorRepository,
                               AmendRestClient amendRestClient) {
        this.monitorRepository = monitorRepository;
        this.amendRestClient = amendRestClient;
    }

    // Operations in Monitors

    /**
     * Retrieve a paginated list of monitors.
     *
     * @param page the page number to retrieve, default is 0
     * @param size the size of the page to retrieve, default is 5
     * @return a Page of Monitor entities
     */
    @Operation(summary = "Retrieve paginated list of monitors", description = "Retrieve a paginated list of monitors")
    @GetMapping("/pageMonitor")
    public Page<Monitor> getPageMonitor(
            @Parameter(description = "Page number to retrieve") @RequestParam(value = "page", defaultValue = "0") int page,
            @Parameter(description = "Size of the page to retrieve") @RequestParam(value = "size", defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return monitorRepository.findAll(pageable);
    }

    /**
     * Retrieve a paginated list of monitors filtered by name.
     *
     * @param keyword the name keyword to filter by
     * @param page the page number to retrieve, default is 0
     * @param size the size of the page to retrieve, default is 5
     * @return a Page of Monitor entities filtered by name
     */
    @Operation(summary = "Retrieve paginated list of monitors by name", description = "Retrieve a paginated list of monitors filtered by name")
    @GetMapping("/pageMonitorName/{keyword}")
    public Page<Monitor> getMonitorsByName(
            @Parameter(description = "Name keyword to filter by") @PathVariable String keyword,
            @Parameter(description = "Page number to retrieve") @RequestParam(value = "page", defaultValue = "0") int page,
            @Parameter(description = "Size of the page to retrieve") @RequestParam(value = "size", defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);

        if (keyword == null) return monitorRepository.findAll(pageable);
        return monitorRepository.findByNameContains(keyword, pageable);
    }

    /**
     * Retrieve a list of all monitors.
     *
     * @return a List of Monitor entities
     */
    @Operation(summary = "Retrieve all monitors", description = "Retrieve a list of all monitors")
    @GetMapping("/monitors")
    public List<Monitor> getMonitors(){
        return monitorRepository.findAll();
    }

    /**
     * Retrieve the count of all monitors.
     *
     * @return the count of Monitor entities
     */
    @Operation(summary = "Retrieve monitor count", description = "Retrieve the count of all monitors")
    @GetMapping("/count")
    public Long getMonitorsCount() {
        return monitorRepository.count();
    }

    /**
     * Retrieve a monitor by its ID.
     *
     * @param id the ID of the monitor to retrieve
     * @return the Monitor entity
     * @throws RuntimeException if the monitor is not found
     */
    @Operation(summary = "Retrieve monitor by ID", description = "Retrieve a monitor by its ID")
    @GetMapping("/monitors/{id}")
    public Monitor getMonitorById(@Parameter(description = "ID of the monitor to retrieve") @PathVariable Long id){
        return monitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Monitor %s not found!", id)));
    }

    /**
     * Create a new amend for a traffic violation.
     *
     * @param newData the data for the new amend
     */
    @Operation(summary = "Create a new amend", description = "Create a new amend for a traffic violation")
    @PostMapping("/newAmend")
    public void newAmend(@Parameter(description = "Data for the new amend") @RequestBody NewData newData){
        amendRestClient.saveAmend(newData);
    }

}
