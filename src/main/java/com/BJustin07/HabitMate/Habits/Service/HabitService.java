package com.BJustin07.HabitMate.Habits.Service;

import com.BJustin07.HabitMate.Habits.Model.DTO.HabitDTO;
import com.BJustin07.HabitMate.Habits.Model.HabitEntity;
import com.BJustin07.HabitMate.Users.Model.UserEntity;

import java.util.List;

public interface HabitService {
    public String CreateHabit(HabitDTO habitDTO, int userId);
    public String DeleteHabit(int habitId);
    public String UpdateHabit(HabitDTO habitDTO, int habitId);
    public List<HabitDTO> getAllHabits(int userId);
}
