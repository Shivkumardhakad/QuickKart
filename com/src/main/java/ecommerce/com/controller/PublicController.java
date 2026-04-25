package ecommerce.com.controller;

import ecommerce.com.model.User;
import ecommerce.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    UserService userService;

    @GetMapping("/health-check")
    public String HealthCheck()
    {
        return "app is working";
    }


    @PostMapping("/register")
    public ResponseEntity<?> creatUser(@RequestBody User user)
    {
         return new ResponseEntity<>(userService.createUser(user),HttpStatus.OK);
    }




}

