package com.chimera;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.chimera.model.AgentTask;
import com.chimera.model.TaskContext;
import java.time.Instant;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Unit test: immutable DTOs expose their values through record accessors and have no setters
 * (see specs/technical.md — DTOs between Planner/Worker/Judge are immutable Records).
 */
class DataModelImmutabilityTest {

  @Test
  void agentTaskAccessorsReturnSuppliedValues() {
    Instant createdAt = Instant.parse("2026-06-21T00:00:00Z");
    TaskContext context = new TaskContext("grow the fashion niche", List.of("witty", "warm"), List.of("mcp://news/fashion"));

    AgentTask task =
        new AgentTask("task-1", "generate_content", "high", context, "worker-1", createdAt, "pending");

    assertEquals("task-1", task.taskId());
    assertEquals("generate_content", task.taskType());
    assertEquals("high", task.priority());
    assertSame(context, task.context());
    assertEquals("worker-1", task.assignedWorkerId());
    assertEquals(createdAt, task.createdAt());
    assertEquals("pending", task.status());
  }
}
