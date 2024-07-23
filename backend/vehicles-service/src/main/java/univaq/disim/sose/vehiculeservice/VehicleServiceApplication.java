package univaq.disim.sose.vehiculeservice;

import univaq.disim.sose.vehiculeservice.entites.Owner;
import univaq.disim.sose.vehiculeservice.entites.Vehicle;
import univaq.disim.sose.vehiculeservice.repositories.OwnerRepository;
import univaq.disim.sose.vehiculeservice.repositories.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Main class for the Vehicle Service application.
 */
@SpringBootApplication
public class VehicleServiceApplication {

    private final Random random = new Random();

    public static void main(String[] args) {
        SpringApplication.run(VehicleServiceApplication.class, args);
    }

    /**
     * Adds initial data to the H2 database at the start of the application.
     *
     * @param vehicleRepository the repository for managing Vehicle entities
     * @param ownerRepository the repository for managing Owner entities
     * @return a CommandLineRunner that adds data to the database
     */
    @Bean
    CommandLineRunner start(VehicleRepository vehicleRepository, OwnerRepository ownerRepository) {
        return args -> {
            // Create and save Owner entities
            Stream.of("Adam Bouafia", "Che Guevara", "Linus Torvalds", "Xayah of the Lhotlan", "kevin Mitnick").forEach(o -> {
                String email = o.replaceAll(" ", "") + "@gmail.com"; // Generate email address
                Owner owner = Owner.builder()
                        .name(o)
                        .email(email)
                        .birthDate(new Date()) // Set birth date to current date
                        .build();
                ownerRepository.save(owner);
            });

            // Create and save Vehicle entities for each Owner
            ownerRepository.findAll().forEach(owner -> {
                for (int i = 0; i < 3; i++) {
                    Vehicle vehicle = Vehicle.builder()
                            .registrationNumber(UUID.randomUUID().toString()) // Generate a random registration number
                            .fiscalPower(Double.valueOf(random.nextInt(1000))) // Generate a random fiscal power
                            .manufacturer("manufacturer" + random.nextInt(20)) // Generate a random manufacturer name
                            .model("model" + random.nextInt(20)) // Generate a random model name
                            .owner(owner) // Associate the vehicle with the owner
                            .build();
                    vehicleRepository.save(vehicle);
                }
            });
        };
    }
}
