package com.chimera.model;

import java.time.Instant;

/**
 * Immutable DTO for the AgentTask API contract (Planner -> Worker).
 */
public record AgentTask(
        String taskId,
        String taskType,
        String priority,
        TaskContext context,
        String assignedWorkerId,
        Instant createdAt,
        String status) {
}
