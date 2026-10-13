package com.example.tuwaiqacademylab12.Service;

import com.example.tuwaiqacademylab12.Model.User;
import com.example.tuwaiqacademylab12.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    public void register(User user) {
        user.setRole("USER");
        String hash = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hash);
        authRepository.save(user);
    }

}
