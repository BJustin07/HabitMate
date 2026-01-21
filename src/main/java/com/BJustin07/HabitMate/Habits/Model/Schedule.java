package com.BJustin07.HabitMate.Habits.Model;

import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Schedule {

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "habit_days",
            joinColumns = @JoinColumn(name = "habit_id")
    )
    @Column(name = "day_of_week", length = 20)
    private List<String> days = new ArrayList<>();

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    public Schedule() {}

    public List<String> getDays() { return days; }
    public void setDays(List<String> days) { this.days = days; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
}

