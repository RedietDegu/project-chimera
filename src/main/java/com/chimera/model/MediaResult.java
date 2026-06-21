package com.chimera.model;

/** Immutable result returned by the media-generation skill. */
public record MediaResult(String mediaUrl, String generationId, double costUsd) {}
