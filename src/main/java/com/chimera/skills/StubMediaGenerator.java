package com.chimera.skills;

import com.chimera.model.MediaResult;

/**
 * Placeholder implementation of {@link MediaGenerator}.
 *
 * <p>Intentionally unimplemented — defines work the agents must later fulfil
 * (see {@code specs/acceptance.md}).
 */
public class StubMediaGenerator implements MediaGenerator {

    @Override
    public MediaResult generate(String prompt, String characterReferenceId, String mediaType, String tier)
            throws BudgetExceededException {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
