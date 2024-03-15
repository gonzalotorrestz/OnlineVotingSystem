package dev.gonzalotorrestz.onlinevotingsystem.service;

import dev.gonzalotorrestz.onlinevotingsystem.dto.UserDTO;
import dev.gonzalotorrestz.onlinevotingsystem.model.User;
import dev.gonzalotorrestz.onlinevotingsystem.repository.UserRepository;
import dev.gonzalotorrestz.onlinevotingsystem.util.UserEntityDTOConverter;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final UserEntityDTOConverter userConverter;

    public UserService(UserRepository userRepository, UserEntityDTOConverter userConverter)
    {
            this.userRepository = userRepository;
            this.userConverter = userConverter;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = userConverter.convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userConverter.convertToDTO(savedUser);
    }

    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found with username: " + username));
        return userConverter.convertToDTO(user);
    }
    public List<UserDTO> getAllUsers(){
        var userList = userRepository.findAll();
        return userConverter.convertToDTOList(userList);
    }
}
