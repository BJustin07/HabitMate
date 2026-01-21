package com.BJustin07.HabitMate.Habits.Model;

import com.BJustin07.HabitMate.Users.Model.UserEntity;
import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Table(name ="habits")
public class HabitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    private String habitName;
    private String habitGoal;
    private String habitSystem;
    @Embedded
    private Schedule habitSchedule;
    private int habitCurrentStreak;
    private int habitLongestStreak;

    public HabitEntity(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }
    public String getHabitName() {
        return habitName;
    }
    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public String getHabitSystem() {
        return habitSystem;
    }

    public void setHabitSystem(String habitSystem) {
        this.habitSystem = habitSystem;
    }

    public Schedule getHabitSchedule() {
        return habitSchedule;
    }

    public void setHabitSchedule(Schedule habitSchedule) {
        this.habitSchedule = habitSchedule;
    }

    public String getHabitGoal() {
        return habitGoal;
    }

    public void setHabitGoal(String habitGoal) {
        this.habitGoal = habitGoal;
    }
}
