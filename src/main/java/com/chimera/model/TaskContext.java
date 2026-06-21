package com.chimera.model;

import java.util.List;

/**
 * Immutable context payload carried by an {@link AgentTask}.
 */
public record TaskContext(
        String goalDescription,
        List<String> personaConstraints,
        List<String> requiredResources) {
}
