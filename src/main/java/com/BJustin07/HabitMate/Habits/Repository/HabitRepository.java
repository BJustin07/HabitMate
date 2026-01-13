package com.BJustin07.HabitMate.Habits.Repository;

import com.BJustin07.HabitMate.Habits.Model.HabitEntity;
import com.BJustin07.HabitMate.Users.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<HabitEntity, Integer> {
    public Boolean existsById(int id);
    public List<HabitEntity> findByUser(UserEntity userEntity);
}
