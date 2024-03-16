package dev.gonzalotorrestz.onlinevotingsystem.controller;

import dev.gonzalotorrestz.onlinevotingsystem.dto.ResponseDTO;
import dev.gonzalotorrestz.onlinevotingsystem.dto.UserDTO;
import dev.gonzalotorrestz.onlinevotingsystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOs = userService.getAllUsers();
        return ResponseEntity.ok(userDTOs);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        UserDTO userDTO = userService.getUserByUsername(username);
        return ResponseEntity.ok(userDTO);
    }
    @PostMapping
    public ResponseEntity<ResponseDTO<?>> createUser(@RequestBody @Valid UserDTO userDTO) {
        ResponseDTO<?> response = new ResponseDTO<>();
        try {
            UserDTO createdUserDTO = userService.createUser(userDTO);
            response.setStatus(HttpStatus.CREATED.value());
            response.setMessage("User created!");
//            response.setData(createdUserDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (DataIntegrityViolationException e) {
            response.setStatus(HttpStatus.CONFLICT.value());
            response.setMessage("User with the same email or username already exists");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        } catch (Exception e){
            System.out.println("An unexpected error occurred: " + e);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("An internal server error occurred");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        finally {
        }
    }
}
