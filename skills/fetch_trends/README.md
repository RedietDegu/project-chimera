# Skill: `fetch_trends`

## Purpose

A Worker calls this skill to **retrieve trending topics for the agent's niche**, via an **MCP news resource**.

## Input Contract

```json
{
  "version": "1.0",
  "niche": "string (required)",
  "time_window_hours": "integer (required)",
  "source": "string, MCP resource URI (required)"
}
```

## Output Contract

```json
{
  "version": "1.0",
  "trends": [
    {
      "topic": "string (required)",
      "relevance_score": "number 0.0-1.0 (required)",
      "source": "string (required)",
      "detected_at": "timestamp (required)"
    }
  ]
}
```

## Example

**Input:**

```json
{
  "version": "1.0",
  "niche": "fashion",
  "time_window_hours": 4,
  "source": "news://ethiopia/fashion"
}
```

**Output:**

```json
{
  "version": "1.0",
  "trends": [
    {
      "topic": "habesha kemis modern cuts",
      "relevance_score": 0.88,
      "source": "news://ethiopia/fashion",
      "detected_at": "2026-06-21T09:15:00Z"
    }
  ]
}
```

## Errors

- **`ResourceUnavailableException`** — raised if the MCP resource cannot be reached.

## Note

Only trends with `relevance_score` **above `0.75`** are passed to the Planner (per [specs/acceptance.md](../../specs/acceptance.md)).
