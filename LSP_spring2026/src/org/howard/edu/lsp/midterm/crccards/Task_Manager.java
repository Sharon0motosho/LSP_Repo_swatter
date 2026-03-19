package org.howard.edu.lsp.midterm.crccards;

import java.util.*;

/**
 * Manages a collection of Task objects.
 * Supports adding tasks, searching by ID, and filtering by status.
 * 
 * @author Sharon
 */
public class Task_Manager {

    private Map<String, Task> tasks;

    /**
     * Constructs a TaskManager with an empty task collection.
     */
    public Task_Manager() {
        tasks = new HashMap<>();
    }

    /**
     * Adds a new task to the system.
     * Throws an exception if a duplicate taskId is found.
     * 
     * @param task the task to add
     * @throws IllegalArgumentException if duplicate taskId exists
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds a task by its ID.
     * 
     * @param taskId the ID to search for
     * @return the Task if found, otherwise null
     */
    public Task findTask(String taskId) {
        return tasks.getOrDefault(taskId, null);
    }

    /**
     * Returns all tasks with a given status.
     * 
     * @param status the status to filter by
     * @return list of matching tasks
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();

        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }

        return result;
    }
}
