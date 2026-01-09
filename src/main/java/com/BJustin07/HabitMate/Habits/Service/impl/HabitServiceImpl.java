package com.BJustin07.HabitMate.Habits.Service.impl;

import com.BJustin07.HabitMate.Habits.Model.HabitEntity;
import com.BJustin07.HabitMate.Habits.Repository.HabitRepository;
import com.BJustin07.HabitMate.Habits.Service.HabitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitServiceImpl implements HabitService {
    private final HabitRepository habitRepository;

    public HabitServiceImpl(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public String CreateHabit(HabitEntity habitEntity){
        try{
            habitRepository.save(habitEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  "Successfully Created Habit";
    }

    public String DeleteHabit(HabitEntity habitEntity){
        Boolean habitExists = habitRepository.existsById(habitEntity.id);
        if(!habitExists){
            throw new RuntimeException("Habit does not exist");
        }
        habitRepository.deleteById(habitEntity.id);
        return  "Successfully Deleted Habit";
    }

    public String UpdateHabit(HabitEntity habitEntity){
        HabitEntity habitData = habitRepository.findById(habitEntity.id).orElseThrow(() -> new RuntimeException("Habit does not exist"));
        boolean habitName = false;
        boolean habitGoal = false;
        boolean habitSystem = false;
        boolean habitStatus = false;
        if (habitEntity.habitName != null){
            habitName = true;
            habitData.habitName = habitEntity.habitName;
        }
        if(habitEntity.habitGoal != null){
            habitGoal = true;
            habitData.habitGoal = habitEntity.habitGoal;
        }
        if(habitEntity.habitSystem != null){
            habitSystem = true;
            habitData.habitSystem = habitEntity.habitSystem;
        }
        if(habitEntity.habitSchedule != null){
            habitStatus = true;
            habitData.habitSchedule = habitEntity.habitSchedule;
        }
        if(!habitName && !habitGoal && !habitSystem && !habitStatus){
            return "Nothing was updated";
        }
        habitRepository.save(habitData);
        return  "Successfully Updated Habit";
    }

    public List<HabitEntity> getAllHabits(){
        return habitRepository.findAll();
    }
}
