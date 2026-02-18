package com.tourist.backend.config;

import com.tourist.backend.entity.Spot;
import com.tourist.backend.repository.SpotRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final com.tourist.backend.repository.UserRepository userRepository;

    public DataSeeder(SpotRepository spotRepository, com.tourist.backend.repository.UserRepository userRepository) {
        this.spotRepository = spotRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (spotRepository.count() == 0) {
            Spot s1 = new Spot();
            s1.setName("Mirissa Beach");
            s1.setCategory("Beach");
            s1.setDescription("A beautiful beach famous for whale watching and surfing.");
            s1.setImageUrl("https://images.unsplash.com/photo-1590523741831-ab97e3ad633d");

            Spot s2 = new Spot();
            s2.setName("Ella Rock");
            s2.setCategory("Mountain");
            s2.setDescription("A famous hiking spot with panoramic views of the hill country.");
            s2.setImageUrl("https://images.unsplash.com/photo-1588710929944-77a452a32483");

            Spot s3 = new Spot();
            s3.setName("Sigiriya");
            s3.setCategory("History");
            s3.setDescription("Ancient rock fortress and palace ruin.");
            s3.setImageUrl("https://images.unsplash.com/photo-1590429783935-866b8fb7fb3b");

            Spot s4 = new Spot();
            s4.setName("Yala National Park");
            s4.setCategory("Nature");
            s4.setDescription("Famous formatting rich wildlife and leopards.");
            s4.setImageUrl("https://images.unsplash.com/photo-1534063264669-e77894d86b72");

            Spot s5 = new Spot();
            s5.setName("Arugam Bay");
            s5.setCategory("Beach");
            s5.setDescription("Top surfing destination in the east coast.");
            s5.setImageUrl("https://images.unsplash.com/photo-1471922694854-ff1b63b20054");

            spotRepository.saveAll(Arrays.asList(s1, s2, s3, s4, s5));
            System.out.println("--- Data Seeding Completed ---");
        }

        // Seed Users
        if (userRepository.findByEmail("admin@tourist.com") == null) {
}
            com.tourist.backend.entity.User admin = new com.tourist.backend.entity.User();
            admin.setName("Admin User");
            admin.setEmail("admin@tourist.com");
            admin.setPassword("admin123");
            admin.setRole("ADMIN");
            userRepository.save(admin);
            System.out.println("--- Seeded Admin User ---");
        }

        if (userRepository.findByEmail("user@tourist.com") == null) {
            com.tourist.backend.entity.User user = new com.tourist.backend.entity.User();
            user.setName("John Doe");
            user.setEmail("user@tourist.com");
            user.setPassword("user123");
            user.setRole("USER");
            userRepository.save(user);
            System.out.println("--- Seeded Regular User ---");
        }}}
