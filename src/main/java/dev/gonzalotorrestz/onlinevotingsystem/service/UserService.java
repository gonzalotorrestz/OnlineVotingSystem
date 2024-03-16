package dev.gonzalotorrestz.onlinevotingsystem.service;

import dev.gonzalotorrestz.onlinevotingsystem.dto.RegisteredUserDTO;
import dev.gonzalotorrestz.onlinevotingsystem.dto.UserDTO;
import dev.gonzalotorrestz.onlinevotingsystem.model.User;
import dev.gonzalotorrestz.onlinevotingsystem.repository.UserRepository;
import dev.gonzalotorrestz.onlinevotingsystem.util.UserEntityDTOConverter;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final UserEntityDTOConverter userConverter;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserEntityDTOConverter userConverter, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisteredUserDTO registerUser(@NotNull UserDTO userDTO) {
        userDTO.setRegistrationDate(LocalDateTime.now());
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User savedUser = userRepository.save(userConverter.convertToEntity(userDTO));
        return userConverter.convertToRegisteredUserDTO(savedUser);
    }

    public List<UserDTO> getAllUsers() {
        var userList = userRepository.findAll();
        return userConverter.convertToDTOList(userList);
    }
}
