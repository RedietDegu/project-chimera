package com.chimera.model;

import java.util.List;

/**
 * Immutable artifact produced by a Worker and carried in a {@link WorkerResult}.
 */
public record Artifact(
        String type,
        String content,
        List<String> mediaUrls) {
}
