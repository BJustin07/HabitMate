package com.BJustin07.HabitMate.Habits.Service;

import com.BJustin07.HabitMate.Habits.Model.HabitEntity;

import java.util.List;

public interface HabitService {
    public String CreateHabit(HabitEntity habitEntity);
    public String DeleteHabit(HabitEntity habitEntity);
    public String UpdateHabit(HabitEntity habitEntity);
    public List<HabitEntity> getAllHabits();
}
