package org.example;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Task {
    private static int inc = 0;
    private int id;
    private LocalDate data;
    private String timeCreate;
    private String node;
    private String deadLineTime;
    private String deadLineDate;
    private String avtor;


    public Task(LocalDate data, String node, String deadLineTime, String deadLineDate, String avtor) {

        StringBuilder sb = new StringBuilder();
        this.id = inc++;
        this.data = data;
        sb.append(LocalDateTime.now().getHour()).append(':').append(LocalDateTime.now().getMinute());
        timeCreate = sb.toString();
        this.node = node;
        this.deadLineTime = deadLineTime;
        this.deadLineDate = deadLineDate;
        this.avtor = avtor;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{id=" + id +
                ", data=" + data +
                ", timeCreate='" + timeCreate + '\'' +
                ", node='" + node + '\'' +
                ", deadLineTime='" + deadLineTime + '\'' +
                ", deadLineDate='" + deadLineDate + '\'' +
                ", avtor='" + avtor + '\'' +
                "}\n";
    }
}
