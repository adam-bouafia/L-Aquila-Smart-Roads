package univaq.disim.sose.amendservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Main class for the Amend Service application.
 * This is the entry point for the Spring Boot application.
 */
@SpringBootApplication
@EnableFeignClients
public class AmendServiceApplication {

    /**
     * Main method to run the Spring Boot application.
     * 
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(AmendServiceApplication.class, args);
    }
}
