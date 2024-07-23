package univaq.disim.sose.monitorservice;

import univaq.disim.sose.monitorservice.entites.Monitor;
import univaq.disim.sose.monitorservice.repositories.MonitorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Main application class for the Monitor Service.
 * This class initializes and runs the Spring Boot application.
 */
@SpringBootApplication
@EnableFeignClients
public class MonitorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorServiceApplication.class, args);
    }

    Random random = new Random();

    /**
     * Bean to initialize the database with sample data.
     *
     * @param monitorRepository the repository to save the monitor entities
     * @return a CommandLineRunner to execute the initialization code
     */
    @Bean
    CommandLineRunner start(MonitorRepository monitorRepository) {
        return args -> {
            // Initialize the database with sample monitors
            Stream.of("R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8").forEach(i -> {
                Monitor monitor = Monitor.builder()
                        .name(i)
                        .status(true)
                        .maxSpeed(120)
                        .latitude(random.nextDouble(10))
                        .longitude(random.nextDouble(10))
                        .build();
                monitorRepository.save(monitor);
            });
        };
    }
}
