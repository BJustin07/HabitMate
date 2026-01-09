package com.BJustin07.HabitMate.Habits.Model;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Table(name ="habits")
public class HabitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String habitName;
    public String habitGoal;
    public String habitSystem;
    //strng muna kunware MWF, pero dapat matutunan ko yung naka ENUM
    public String habitSchedule;
    public int habitCurrentStreak;
    public int habitLongestStreak;

}
