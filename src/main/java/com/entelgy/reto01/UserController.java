package com.entelgy.reto01;

import com.entelgy.reto01.service.UserService;
import com.entelgy.reto01.service.UserServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/reto")
    public ResponseEntity<Object> readData() {
        try {
            return ResponseEntity.ok(userService.processData());
        } catch (UserServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
