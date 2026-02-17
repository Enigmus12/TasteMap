package eci.edu.co.users_service.service;

import eci.edu.co.users_service.dto.UserRequestDTO;
import eci.edu.co.users_service.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserById(String id);
    void deleteUser(String id);
}
