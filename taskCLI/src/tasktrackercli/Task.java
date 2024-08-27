/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tasktrackercli;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author SENGOUA NATHAN
 */
public class Task {
    private int id;
    private String description;
    private String status; // "todo", "in-progress", "done"
    private String createdAt;
    private String updatedAt;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "todo";
        this.createdAt = getCurrentTime();
        this.updatedAt = this.createdAt;
    }

    private String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    public int getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = getCurrentTime();
    }

    public void setStatus(String status) {
        this.status = status;
        this.updatedAt = getCurrentTime();
    }

    public String toJson() {
        return String.format("{\"id\":%d,\"description\":\"%s\",\"status\":\"%s\",\"createdAt\":\"%s\",\"updatedAt\":\"%s\"}",
                id, description, status, createdAt, updatedAt);
    }

    public static Task fromJson(String json) {
        int id = Integer.parseInt(json.split("\"id\":")[1].split(",")[0]);
        String description = json.split("\"description\":\"")[1].split("\"")[0];
        String status = json.split("\"status\":\"")[1].split("\"")[0];
        String createdAt = json.split("\"createdAt\":\"")[1].split("\"")[0];
        String updatedAt = json.split("\"updatedAt\":\"")[1].split("\"")[0];

        Task task = new Task(id, description);
        task.setStatus(status);
        task.createdAt = createdAt;
        task.updatedAt = updatedAt;

        return task;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    public String getstatus() {
        return status;
    }
}
