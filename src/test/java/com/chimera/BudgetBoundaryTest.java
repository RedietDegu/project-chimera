package com.chimera;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.chimera.model.MediaResult;
import com.chimera.skills.BudgetExceededException;
import com.chimera.skills.MediaGenerator;
import com.chimera.skills.StubMediaGenerator;
import org.junit.jupiter.api.Test;

/**
 * Budget-boundary contract for the media-generation skill (see specs/acceptance.md).
 *
 * <p>Intentionally failing against the current stub — defines required behaviour.
 */
class BudgetBoundaryTest {

  private static final double DAILY_BUDGET = 100.0;

  @Test
  void costExactlyEqualToBudgetIsAllowed() throws BudgetExceededException {
    MediaGenerator generator = new StubMediaGenerator();

    MediaResult result = generator.generate("a campaign film priced at the budget", "char-001", "video", "hero");

    assertTrue(result.costUsd() <= DAILY_BUDGET, "a cost exactly equal to the daily budget must be allowed");
  }

  @Test
  void costExceedingBudgetIsRejected() {
    MediaGenerator generator = new StubMediaGenerator();

    assertThrows(
        BudgetExceededException.class,
        () -> generator.generate("a campaign film priced over the budget", "char-001", "video", "hero"));
  }
}
