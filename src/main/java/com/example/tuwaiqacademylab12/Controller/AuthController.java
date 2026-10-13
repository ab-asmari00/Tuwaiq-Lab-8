package com.example.tuwaiqacademylab12.Controller;

import com.example.tuwaiqacademylab12.Api.ApiResponse;
import com.example.tuwaiqacademylab12.Model.User;
import com.example.tuwaiqacademylab12.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        authService.register(user);
        return ResponseEntity.status(200).body(new ApiResponse("User registered successfully"));
    }

}
