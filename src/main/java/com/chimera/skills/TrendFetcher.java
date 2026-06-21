package com.chimera.skills;

import com.chimera.model.TrendItem;
import java.util.List;

/** Skill contract: retrieve trending topics for the agent's niche via an MCP news resource. */
public interface TrendFetcher {

  List<TrendItem> fetchTrends(String niche, int timeWindowHours, String source);
}
