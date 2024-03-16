package dev.gonzalotorrestz.onlinevotingsystem.config;

import dev.gonzalotorrestz.onlinevotingsystem.constraints.PasswordConstraintValidator;
import org.passay.PasswordValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {
    private final PasswordConstraintValidator passwordConstraintValidator;

    public SecurityConfig(PasswordConstraintValidator passwordConstraintValidator) {
        this.passwordConstraintValidator = passwordConstraintValidator;
    }

    @Bean
    public PasswordValidator passwordValidator() {
        return new PasswordValidator(passwordConstraintValidator.getRules());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
