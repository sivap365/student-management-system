package net.javaguides.sms.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import net.javaguides.sms.entity.Role;
import net.javaguides.sms.entity.User;
import net.javaguides.sms.repository.RoleRepository;
import net.javaguides.sms.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepo;
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    public DataInitializer(RoleRepository roleRepo, UserRepository userRepo, PasswordEncoder encoder) {
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) {
        Role adminRole = roleRepo.findByName("ROLE_ADMIN")
                .orElseGet(() -> roleRepo.save(new Role("ROLE_ADMIN")));
        Role userRole = roleRepo.findByName("ROLE_USER")
                .orElseGet(() -> roleRepo.save(new Role("ROLE_USER")));

        String adminEmail = "admin@sms.com";
        String adminPass = "Admin@123";

        if (!userRepo.existsByEmail(adminEmail)) {
            User admin = new User();
            admin.setFirstName("System");
            admin.setLastName("Admin");
            admin.setEmail(adminEmail);
            admin.setPassword(encoder.encode(adminPass));
            admin.getRoles().add(adminRole);
            admin.getRoles().add(userRole);
            admin.setEnabled(true);
            userRepo.save(admin);
            System.out.println("✅ Created default ADMIN user: " + adminEmail + " / " + adminPass);
        }
    }
}
