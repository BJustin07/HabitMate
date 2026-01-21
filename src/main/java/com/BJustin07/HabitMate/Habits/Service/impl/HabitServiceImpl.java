package com.BJustin07.HabitMate.Habits.Service.impl;

import com.BJustin07.HabitMate.Habits.Exception.HabitFailToCreate;
import com.BJustin07.HabitMate.Habits.Exception.HabitNotFound;
import com.BJustin07.HabitMate.Habits.Model.DTO.HabitDTO;
import com.BJustin07.HabitMate.Habits.Model.HabitEntity;
import com.BJustin07.HabitMate.Habits.Model.Schedule;
import com.BJustin07.HabitMate.Habits.Repository.HabitRepository;
import com.BJustin07.HabitMate.Habits.Service.HabitService;
import com.BJustin07.HabitMate.Users.Exception.UserNotFound;
import com.BJustin07.HabitMate.Users.Model.UserEntity;
import com.BJustin07.HabitMate.Users.Repository.UserRepository;
import com.BJustin07.HabitMate.Users.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HabitServiceImpl implements HabitService {
    private final HabitRepository habitRepository;
    private final UserService userService;

    public HabitServiceImpl(HabitRepository habitRepository, UserService userService) {
        this.habitRepository = habitRepository;
        this.userService = userService;
    }

    public String CreateHabit(HabitDTO habitDTO, int userId){
        UserEntity user = userService.findById(userId);
        HabitEntity habitEntity = new HabitEntity();
        habitEntity.setHabitName(habitDTO.getHabitName());
        habitEntity.setHabitGoal(habitDTO.getHabitGoal());
        habitEntity.setHabitSystem(habitDTO.getHabitSystem());
        Schedule habitSchedule = new Schedule();
        habitSchedule.setDays(habitDTO.getHabitSchedule().getDays());
        habitSchedule.setStartTime(habitDTO.getHabitSchedule().getStartTime());
        habitSchedule.setEndTime(habitDTO.getHabitSchedule().getEndTime());
        habitEntity.setHabitSchedule(habitSchedule);
        habitEntity.setUser(user);
        try{
            habitRepository.save(habitEntity);
        } catch (Exception e) {
            throw new HabitFailToCreate(e.getMessage());
        }
        return  "Successfully Created Habit";
    }

    public String DeleteHabit(int habitId){
        Boolean habitExists = habitRepository.existsById(habitId);
        if(!habitExists){
            throw new HabitNotFound("Habit does not exist");
        }
        habitRepository.deleteById(habitId);
        return  "Successfully Deleted Habit";
    }

    public String UpdateHabit(HabitDTO habitDTO, int habitId){
        HabitEntity habitData = habitRepository.findById(habitId).orElseThrow(() -> new HabitNotFound("Habit does not exist"));
        boolean updated = false;
        if (habitDTO.getHabitName() != null){
            updated = true;
            habitData.setHabitName(habitDTO.getHabitName());
        }
        if(habitDTO.getHabitGoal() != null){
            updated = true;
            habitData.setHabitGoal(habitDTO.getHabitGoal());
        }
        if(habitDTO.getHabitSystem() != null){
            updated = true;
            habitData.setHabitSystem(habitDTO.getHabitSystem());
        }
        if(habitDTO.getHabitSchedule() != null){
            updated = true;
            habitData.setHabitSchedule(habitDTO.getHabitSchedule());
        }
        if(!updated){
            return "Nothing was updated";
        }
        habitRepository.save(habitData);
        return  "Successfully Updated Habit";
    }

    public List<HabitDTO> getAllHabits(int userId){
        UserEntity user = userService.findById(userId);
        List<HabitEntity> habits = habitRepository.findByUser(user);
        List<HabitDTO> habitDTOs = new ArrayList<>();

        for(HabitEntity habitEntity : habits){
            HabitDTO habitDTO = new HabitDTO();
            habitDTO.setHabitName(habitEntity.getHabitName());
            habitDTO.setHabitGoal(habitEntity.getHabitGoal());
            habitDTO.setHabitSystem(habitEntity.getHabitSystem());
            Schedule  habitSchedule = new Schedule();
            habitSchedule.setDays(habitEntity.getHabitSchedule().getDays());
            habitSchedule.setStartTime(habitEntity.getHabitSchedule().getStartTime());
            habitSchedule.setEndTime(habitEntity.getHabitSchedule().getEndTime());
            habitDTO.setHabitSchedule(habitSchedule);
            habitDTOs.add(habitDTO);
        }

      return habitDTOs;
    }
}
