package com.chimera;

import com.chimera.model.TrendItem;
import com.chimera.skills.StubTrendFetcher;
import com.chimera.skills.TrendFetcher;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Acceptance test for the trend-fetching skill (see specs/acceptance.md).
 *
 * <p>Intentionally failing against the current stub — defines required behaviour.
 */
class TrendFetcherTest {

    @Test
    void fetchTrendsReturnsRelevantItems() {
        TrendFetcher fetcher = new StubTrendFetcher();

        List<TrendItem> trends = fetcher.fetchTrends("fashion", 4, "news://ethiopia/fashion");

        assertNotNull(trends, "trends list must not be null");
        assertFalse(trends.isEmpty(), "trends list must not be empty");
        for (TrendItem trend : trends) {
            assertNotNull(trend.topic(), "trend topic must not be null");
            assertTrue(trend.relevanceScore() > 0.75,
                    "every trend must have a relevance score above 0.75");
        }
    }
}
