package com.chimera;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.chimera.model.TrendItem;
import com.chimera.skills.StubTrendFetcher;
import com.chimera.skills.TrendFetcher;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Relevance-threshold contract for the trend-fetching skill (see specs/acceptance.md):
 * only items with relevance_score strictly greater than 0.75 are returned.
 *
 * <p>Intentionally failing against the current stub — defines required behaviour.
 */
class RelevanceThresholdTest {

  private static final double THRESHOLD = 0.75;

  @Test
  void onlyItemsStrictlyAboveThresholdAreReturned() {
    TrendFetcher fetcher = new StubTrendFetcher();

    List<TrendItem> trends = fetcher.fetchTrends("fashion", 24, "news://global/fashion");

    for (TrendItem trend : trends) {
      assertTrue(trend.relevanceScore() > THRESHOLD, "every returned trend must score strictly above 0.75");
    }
    boolean anyAtBoundary = trends.stream().anyMatch(t -> t.relevanceScore() == THRESHOLD);
    assertFalse(anyAtBoundary, "an item exactly at the 0.75 boundary must be excluded");
  }
}
