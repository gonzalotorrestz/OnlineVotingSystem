package dev.gonzalotorrestz.onlinevotingsystem.dto;

import dev.gonzalotorrestz.onlinevotingsystem.model.Country;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class UserDTO {
    @NotBlank(message = "Username cannot be blank")
    private String username;
    @NotBlank(message = "First Name cannot be blank")

    private String firstName;
    @NotBlank(message = "Last Name cannot be blank")
    private String lastName;
    @Email(message = "Invalid email address")
    private String email;

    private int age;

    private Country country;

    public UserDTO() {

    }

    public UserDTO(String username, String email, String firstName, String lastName, int age, Country country) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
