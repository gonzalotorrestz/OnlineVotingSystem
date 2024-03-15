package dev.gonzalotorrestz.onlinevotingsystem.util;

import dev.gonzalotorrestz.onlinevotingsystem.dto.UserDTO;
import dev.gonzalotorrestz.onlinevotingsystem.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserEntityDTOConverter implements EntityDTOConverter<User, UserDTO> {

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDTO convertToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
    @Override
    public User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public List<UserDTO> convertToDTOList(List<User> users) {
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}

