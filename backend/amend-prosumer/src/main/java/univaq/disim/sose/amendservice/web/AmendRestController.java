package univaq.disim.sose.amendservice.web;

import univaq.disim.sose.amendservice.entites.Amend;
import univaq.disim.sose.amendservice.feign.MonitorRestClient;
import univaq.disim.sose.amendservice.feign.VehicleRestClient;
import univaq.disim.sose.amendservice.models.NewData;
import univaq.disim.sose.amendservice.models.Monitor;
import univaq.disim.sose.amendservice.models.Vehicle;
import univaq.disim.sose.amendservice.repositories.AmendRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * REST controller for managing Amends.
 * This class provides endpoints for creating, retrieving, and managing traffic violation amends.
 */
@RestController
@RestResource
@RequestMapping("/api/amend")
@Tag(name = "Amend API", description = "API for managing traffic violation amends")
public class AmendRestController {

    private final VehicleRestClient vehicleRestClient;
    private final MonitorRestClient monitorRestClient;
    private final AmendRepository amendRepository;

    /**
     * Constructor for AmendRestController.
     * 
     * @param vehicleRestClient the Feign client for accessing vehicle data
     * @param monitorRestClient the Feign client for accessing monitor data
     * @param amendRepository the repository for managing amends
     */
    public AmendRestController(VehicleRestClient vehicleRestClient, MonitorRestClient monitorRestClient, AmendRepository amendRepository) {
        this.vehicleRestClient = vehicleRestClient;
        this.monitorRestClient = monitorRestClient;
        this.amendRepository = amendRepository;
    }

    /**
     * Saves a new amend based on the provided data.
     * 
     * @param newData the data for the new amend
     * @return the saved Amend entity
     */
    @Operation(summary = "Save a new amend", description = "Saves a new amend based on the provided data")
    @PostMapping("/saveAmend")
    public Amend saveAmend(@Parameter(description = "Data for the new amend") @RequestBody NewData newData) {
        Vehicle v = vehicleRestClient.getByRegistrationNumber(newData.getRn());
        Monitor r = monitorRestClient.getByMonitorById(newData.getMonitorId());
        r.setId(newData.getMonitorId());

        Amend amend = Amend.builder()
                .vehicle(v)
                .monitor(r)
                .paid(false)
                .vehicleSpeed(newData.getVehicleSpeed())
                .vehicleMatricule(newData.getRn())
                .monitorId(newData.getMonitorId())
                .amendAmount(new Random().nextInt(1000)) // Random amount for the amend
                .date(new Date()) // Current date for the amend
                .monitorMaxSpeed(r.getMaxSpeed())
                .build();

        amendRepository.save(amend);
        return amend;
    }

    /**
     * Retrieves all amends with full details.
     * 
     * @return a list of all amends with vehicle and monitor details
     */
    @Operation(summary = "Retrieve all amends", description = "Retrieves all amends with full details")
    @GetMapping(path = "/fullAmends")
    public List<Amend> getFullAmends() {
        List<Amend> amends = amendRepository.findAll();
        amends.forEach(amend -> {
            Vehicle vehicle = vehicleRestClient.getByRegistrationNumber(amend.getVehicleMatricule());
            amend.setVehicle(vehicle);

            Monitor monitor = monitorRestClient.getByMonitorById(amend.getMonitorId());
            monitor.setId(amend.getMonitorId());
            amend.setMonitor(monitor);
        });
        return amends;
    }

    /**
     * Retrieves the total count of amends.
     * 
     * @return the total number of amends
     */
    @Operation(summary = "Retrieve amends count", description = "Retrieves the total count of amends")
    @GetMapping("/count")
    public Long getAmendsCount() {
        return amendRepository.count();
    }

    /**
     * Retrieves amends with pagination and full details.
     * 
     * @param page the page number
     * @param size the page size
     * @return a page of amends with vehicle and monitor details
     */
    @Operation(summary = "Retrieve paginated amends", description = "Retrieves amends with pagination and full details")
    @GetMapping(path = "/fullAmendsPages")
    public Page<Amend> getFullAmends(
            @Parameter(description = "Page number to retrieve") @RequestParam(value = "page") int page,
            @Parameter(description = "Size of the page to retrieve") @RequestParam(value = "size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Amend> amendsPage = amendRepository.findAll(pageable);
        List<Amend> amends = amendsPage.getContent();
        amends.forEach(amend -> {
            Vehicle vehicle = vehicleRestClient.getByRegistrationNumber(amend.getVehicleMatricule());
            amend.setVehicle(vehicle);

            Monitor monitor = monitorRestClient.getByMonitorById(amend.getMonitorId());
            monitor.setId(amend.getMonitorId());
            amend.setMonitor(monitor);
        });
        long totalElements = amendsPage.getTotalElements();

        return new PageImpl<>(amends, pageable, totalElements);
    }

    /**
     * Retrieves amends in pages.
     * 
     * @param page the page number
     * @param size the page size
     * @return a list of amends in the specified page
     */
    @Operation(summary = "Retrieve amends by page", description = "Retrieves amends in pages")
    @GetMapping(path = "/PageAmend")
    public List<Amend> getFullInPagefractions(
            @Parameter(description = "Page number to retrieve") @RequestParam(value = "page", defaultValue = "0") int page,
            @Parameter(description = "Size of the page to retrieve") @RequestParam(value = "size", defaultValue = "5") int size) {
        List<Amend> amends = amendRepository.findAll();
        amends.forEach(amend -> {
            Vehicle vehicle = vehicleRestClient.getByRegistrationNumber(amend.getVehicleMatricule());
            amend.setVehicle(vehicle);

            Monitor monitor = monitorRestClient.getByMonitorById(amend.getMonitorId());
            monitor.setId(amend.getMonitorId());
            amend.setMonitor(monitor);
        });

        @SuppressWarnings("unused")
        Pageable pageable = PageRequest.of(page, size);
        return amends;
    }

    /**
     * Retrieves a single amend by its ID with full details.
     * 
     * @param id the ID of the amend to retrieve
     * @return the Amend entity with vehicle and monitor details
     */
    @Operation(summary = "Retrieve amend by ID", description = "Retrieves a single amend by its ID with full details")
    @GetMapping(path = "/save/{id}")
    public Amend getAmend(
            @Parameter(description = "ID of the amend to retrieve") @PathVariable(name = "id") Long id) {
        Amend amend = amendRepository.findById(id).get();
        Vehicle v = vehicleRestClient.getByRegistrationNumber(amend.getVehicleMatricule());
        Monitor r = monitorRestClient.getByMonitorById(amend.getMonitorId());

        r.setId(amend.getMonitorId());
        amend.setMonitor(r);
        amend.setVehicle(v);

        return amend;
    }
}
