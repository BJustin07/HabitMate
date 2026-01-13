package com.BJustin07.HabitMate.Habits.Model.DTO;


public class HabitDTO {
    private int id;
    private String habitName;
    private String habitGoal;
    private String habitSystem;
    private String habitSchedule;

    public String getHabitSchedule() {
        return habitSchedule;
    }

    public void setHabitSchedule(String habitSchedule) {
        this.habitSchedule = habitSchedule;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public String getHabitGoal() {
        return habitGoal;
    }

    public void setHabitGoal(String habitGoal) {
        this.habitGoal = habitGoal;
    }

    public String getHabitSystem() {
        return habitSystem;
    }

    public void setHabitSystem(String habitSystem) {
        this.habitSystem = habitSystem;
    }
}
