package com.BJustin07.HabitMate.Users.Repository;

import com.BJustin07.HabitMate.Users.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    boolean existsByUsername(String username);
    boolean existsByUsernameAndPassword(String username, String password);
    UserEntity findByUsername(String username);

}
