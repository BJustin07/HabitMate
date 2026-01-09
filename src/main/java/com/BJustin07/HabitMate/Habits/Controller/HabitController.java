package com.BJustin07.HabitMate.Habits.Controller;

import com.BJustin07.HabitMate.Habits.Model.HabitEntity;
import com.BJustin07.HabitMate.Habits.Service.HabitService;
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
    public String updateHabit(@RequestBody HabitEntity habitEntity){
        return habitService.UpdateHabit(habitEntity);
    }

    @DeleteMapping("/")
    public String deleteHabit(@RequestBody HabitEntity habitEntity){
        return habitService.DeleteHabit(habitEntity);
    }

    @GetMapping("/")
    public List<HabitEntity> getAllHabits(){
        return habitService.getAllHabits();
    }
}
