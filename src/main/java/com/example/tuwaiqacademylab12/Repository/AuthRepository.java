package com.example.tuwaiqacademylab12.Repository;

import com.example.tuwaiqacademylab12.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);

}
