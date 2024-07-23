package univaq.disim.sose.datageneratorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Main class for the Monitor Road application.
 * This is the entry point for the Spring Boot application.
 */

@EnableFeignClients
@SpringBootApplication
public class DataGeneratorApplication {

    /**
     * Main method to run the Spring Boot application.
     * 
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(DataGeneratorApplication.class, args);
    }

    /**
     * Creates a RestTemplate bean to be used for making HTTP requests.
     * 
     * @return a new instance of RestTemplate
     */
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
