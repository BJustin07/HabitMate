package com.BJustin07.HabitMate.Habits.Repository;

import com.BJustin07.HabitMate.Habits.Model.HabitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends JpaRepository<HabitEntity, Integer> {
    public Boolean existsById(int id);
}
