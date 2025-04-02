package com.boarding.app.Controller;

import com.boarding.app.DTO.UserDTO;
import com.boarding.app.DTO.UserRequestDTO;
import com.boarding.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public UserDTO createUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO);
    }
    
}
