package com.chimera.model;

import java.time.Instant;

/** Immutable trend item returned by the trend-fetching skill. */
public record TrendItem(String topic, double relevanceScore, String source, Instant detectedAt) {}
