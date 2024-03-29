package dev.gonzalotorrestz.onlinevotingsystem.dto;

import dev.gonzalotorrestz.onlinevotingsystem.constraints.ValidPassword;
import dev.gonzalotorrestz.onlinevotingsystem.model.Country;
import jakarta.validation.constraints.Email;

import java.time.LocalDateTime;

public class UserDTO {
    private String firstName;
    private String lastName;
    @Email(message = "Invalid email address")
    private String email;
    @ValidPassword(message = "Invalid password. Please choose a stronger password.")
    private String password;
    private Country country;
    private boolean enabled;
    private LocalDateTime registrationDate;
    private LocalDateTime lastLoginDate;

    public UserDTO() {

    }

    public UserDTO(String email, String firstName, String lastName, String password, Country country, boolean enabled) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.country = country;
        this.enabled = false;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
