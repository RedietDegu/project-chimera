package com.chimera.skills;

import com.chimera.model.TrendItem;

import java.util.List;

/**
 * Placeholder implementation of {@link TrendFetcher}.
 *
 * <p>Intentionally unimplemented — defines work the agents must later fulfil
 * (see {@code specs/acceptance.md}).
 */
public class StubTrendFetcher implements TrendFetcher {

    @Override
    public List<TrendItem> fetchTrends(String niche, int timeWindowHours, String source) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
