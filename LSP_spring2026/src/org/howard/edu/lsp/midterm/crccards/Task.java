package org.howard.edu.lsp.midterm.crccards;
/**
 * Represents a single task in the task management system.
 * A task has an ID, description, and status.
 * 
 * @author Sharon
 */
public class Task {

    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a Task with the given ID and description.
     * Default status is set to OPEN.
     * 
     * @param taskId unique identifier for the task
     * @param description description of the task
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns the task ID.
     * 
     * @return taskId
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task description.
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the current status of the task.
     * 
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the task status.
     * Valid values: OPEN, IN_PROGRESS, COMPLETE.
     * Any other value sets status to UNKNOWN.
     * 
     * @param status new status
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || 
            status.equals("IN_PROGRESS") || 
            status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns a formatted string representation of the task.
     * Format: taskId description [status]
     * 
     * @return formatted task string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}
