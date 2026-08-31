package com.example.employeemanagement.config;

import com.example.employeemanagement.model.AppUser;
import com.example.employeemanagement.model.Role;
import com.example.employeemanagement.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner seedUsers(AppUserRepository repository, PasswordEncoder encoder,
                                @Value("${APP_ADMIN_PASSWORD:admin123}") String adminPassword,
                                @Value("${APP_HR_PASSWORD:hr123}") String hrPassword,
                                @Value("${APP_EMPLOYEE_PASSWORD:employee123}") String employeePassword) {
        return args -> {
            createIfMissing(repository, encoder, "admin", adminPassword, Role.ADMIN);
            createIfMissing(repository, encoder, "hr", hrPassword, Role.HR);
            createIfMissing(repository, encoder, "employee", employeePassword, Role.EMPLOYEE);
        };
    }

    private void createIfMissing(AppUserRepository repo, PasswordEncoder encoder, String username, String password, Role role) {
        if (repo.existsByUsername(username)) return;
        AppUser user = new AppUser();
        user.setUsername(username); user.setPassword(encoder.encode(password)); user.setRole(role); user.setEnabled(true);
        repo.save(user);
    }
}
