package com.chimera;

import com.chimera.model.MediaResult;
import com.chimera.skills.BudgetExceededException;
import com.chimera.skills.MediaGenerator;
import com.chimera.skills.StubMediaGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Acceptance tests for the media-generation skill (see specs/acceptance.md).
 *
 * <p>Intentionally failing against the current stub — defines required behaviour.
 */
class SkillsInterfaceTest {

    @Test
    void heroTierTransactionExceedingBudgetIsRejected() {
        MediaGenerator generator = new StubMediaGenerator();

        assertThrows(BudgetExceededException.class,
                () -> generator.generate("a luxury campaign film", "char-001", "video", "hero"));
    }

    @Test
    void dailyTierGenerationReturnsMedia() throws BudgetExceededException {
        MediaGenerator generator = new StubMediaGenerator();

        MediaResult result = generator.generate("a daily selfie", "char-001", "image", "daily");

        assertNotNull(result.mediaUrl(), "mediaUrl must not be null");
        assertNotNull(result.generationId(), "generationId must not be null");
    }
}
