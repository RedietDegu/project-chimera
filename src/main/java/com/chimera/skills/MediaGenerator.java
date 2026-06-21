package com.chimera.skills;

import com.chimera.model.MediaResult;

/**
 * Skill contract: generate on-brand image or video content via an MCP generation tool, with
 * character consistency.
 */
public interface MediaGenerator {

  MediaResult generate(String prompt, String characterReferenceId, String mediaType, String tier)
      throws BudgetExceededException;
}
