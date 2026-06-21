package com.chimera.model;

/**
 * Immutable DTO for the WorkerResult API contract (Worker -> Judge).
 * The {@code stateVersion} field enables Optimistic Concurrency Control
 * when the Judge commits a result.
 */
public record WorkerResult(
        String resultId,
        String taskId,
        String workerId,
        Artifact artifact,
        double confidenceScore,
        String reasoningTrace,
        long stateVersion,
        String status) {
}
