package com.boarding.app.Service;

import com.boarding.app.DTO.UserDTO;
import com.boarding.app.DTO.UserRequestDTO;
import com.boarding.app.Entity.User;
import com.boarding.app.Mapper.UserMapper;
import com.boarding.app.Repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDTO createUser(UserRequestDTO userRequestDTO) {
        // Convert DTO to Entity
        User user = userMapper.toEntity(userRequestDTO);

        // Save user to DB
        user = userRepository.save(user);

        // Convert Entity to DTO and return
        return userMapper.toDTO(user);
    }

     // ✅ Add method to find user by username (for authentication)
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // ✅ Determine role based on roleId
    public String getUserRole(User user) {
        return user.getRoleId() == 1 ? "ROLE_ADMIN" : "ROLE_USER";
    }
}
