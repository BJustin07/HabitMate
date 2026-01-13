package com.BJustin07.HabitMate.Habits.Controller;

import com.BJustin07.HabitMate.Habits.Model.DTO.HabitDTO;
import com.BJustin07.HabitMate.Habits.Model.HabitEntity;
import com.BJustin07.HabitMate.Habits.Service.HabitService;
import com.BJustin07.HabitMate.Users.Model.UserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {
    private final HabitService habitService;
    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @PostMapping("/")
    public String createHabit(@RequestBody HabitEntity habitEntity){
        return habitService.CreateHabit(habitEntity);
    }

    @PostMapping("/update")
    public String updateHabit(@RequestBody HabitDTO habitDTO, @RequestParam int habitId){
        return habitService.UpdateHabit(habitDTO, habitId);
    }

    @DeleteMapping("/")
    public String deleteHabit(@RequestBody HabitEntity habitEntity){
        return habitService.DeleteHabit(habitEntity);
    }

    @GetMapping("/")
    public List<HabitDTO> getAllHabits(@RequestParam int userId){
        return habitService.getAllHabits(userId);
    }
}
