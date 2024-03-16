package dev.gonzalotorrestz.onlinevotingsystem.controller;

import dev.gonzalotorrestz.onlinevotingsystem.dto.RegisteredUserDTO;
import dev.gonzalotorrestz.onlinevotingsystem.dto.ResponseDTO;
import dev.gonzalotorrestz.onlinevotingsystem.dto.UserDTO;
import dev.gonzalotorrestz.onlinevotingsystem.service.UserService;
import dev.gonzalotorrestz.onlinevotingsystem.util.UserEntityDTOConverter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserEntityDTOConverter userEntityDTOConverter;

    @Autowired
    public UserController(UserService userService, UserEntityDTOConverter userEntityDTOConverter) {
        this.userService = userService;
        this.userEntityDTOConverter = userEntityDTOConverter;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOs = userService.getAllUsers();
        return ResponseEntity.ok(userDTOs);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<RegisteredUserDTO>> registerUser(@RequestBody @Valid UserDTO userDTO) {
        ResponseDTO<RegisteredUserDTO> response = new ResponseDTO<>();
        try {
            RegisteredUserDTO registeredUser = userService.registerUser(userDTO);
            response.setStatus(HttpStatus.CREATED.value());
            response.setMessage("Registration completed successfully!");
            response.setData(registeredUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (DataIntegrityViolationException e) {
            response.setStatus(HttpStatus.CONFLICT.value());
            response.setMessage("User with the same email already exists");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("An internal server error occurred");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
