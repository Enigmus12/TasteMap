package eci.edu.co.users_service.service.impl;

import eci.edu.co.users_service.dto.UserRequestDTO;
import eci.edu.co.users_service.dto.UserResponseDTO;
import eci.edu.co.users_service.model.User;
import eci.edu.co.users_service.repository.UserRepository;
import eci.edu.co.users_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    
    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = User.builder()
                .name(userRequestDTO.getName())
                .email(userRequestDTO.getEmail())
                .password(userRequestDTO.getPassword())
                .role(userRequestDTO.getRole())
                .preferences(userRequestDTO.getPreferences())
                .build();
        
        User savedUser = userRepository.save(user);
        return mapToResponseDTO(savedUser);
    }
    
    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public UserResponseDTO getUserById(String id) {
        return userRepository.findById(id)
                .map(this::mapToResponseDTO)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
    
    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
    
    private UserResponseDTO mapToResponseDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .preferences(user.getPreferences())
                .build();
    }
}
