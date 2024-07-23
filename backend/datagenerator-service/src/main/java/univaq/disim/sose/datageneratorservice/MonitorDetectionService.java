package univaq.disim.sose.datageneratorservice;

import lombok.extern.slf4j.Slf4j;
import univaq.disim.sose.datageneratorservice.models.NewData;
import univaq.disim.sose.datageneratorservice.models.Monitor;
import univaq.disim.sose.datageneratorservice.models.Vehicle;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Service for simulating monitor detections of over-speeding vehicles.
 * This service periodically submits over-speed detections to a remote service.
 */
@Service
@Slf4j
@EnableScheduling
public class MonitorDetectionService {
    private final RestTemplate restTemplate;
    private List<Monitor> monitorList = new ArrayList<>();
    private List<Vehicle> vehicleList = new ArrayList<>();
    private final Random random = new Random();

    /**
     * Constructor for MonitorDetectionService.
     * 
     * @param restTemplate the RestTemplate used for making HTTP requests
     */
    public MonitorDetectionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Loads the list of monitors and vehicles from their respective services.
     */
    public void loadMonitors() {
        ResponseEntity<Monitor[]> exchange = restTemplate.exchange(
            "http://localhost:8890/MONITOR-SERVICE/api/monitor/monitors", 
            HttpMethod.GET, 
            null, 
            Monitor[].class
        );
        ResponseEntity<Vehicle[]> exchangeVehicle = restTemplate.exchange(
            "http://localhost:8890/VEHICLES-SERVICE/api/vehicle/vehicles", 
            HttpMethod.GET, 
            null, 
            Vehicle[].class
        );
        this.monitorList = Arrays.asList(exchange.getBody());
        this.vehicleList = Arrays.asList(exchangeVehicle.getBody());
    }

    /**
     * Submits a simulated over-speed detection at fixed intervals.
     * This method is scheduled to run every 4000 milliseconds (4 seconds).
     */
    @Scheduled(fixedRate = 4000)
    public void submitOverSpeedDetection() {
        loadMonitors(); // Load the latest list of monitors and vehicles
        int indexR = random.nextInt(monitorList.size());
        Monitor monitor = monitorList.get(indexR);

        System.out.println("Monitor Name : " + monitor.getName());
        int indexV = random.nextInt(vehicleList.size());
        Vehicle vehicle = vehicleList.get(indexV);
        System.out.println("Vehicle RN : " + vehicle.getRegistrationNumber());

        // Create new data for the over-speed detection
        NewData newData = new NewData();
        newData.setMonitorId(monitor.getId());
        newData.setRn(vehicle.getRegistrationNumber());
        newData.setVehicleSpeed(monitor.getMaxSpeed() + new Random().nextInt(100));

        System.out.println("Vehicle Speed : " + newData.getVehicleSpeed());

        // Submit the over-speed detection data to the monitor service
        this.restTemplate.exchange(
            "http://localhost:8890/MONITOR-SERVICE/api/monitor/newAmend",
            HttpMethod.POST,
            new HttpEntity<>(newData),
            String.class
        );

        System.out.println("----------------------");
    }
}
