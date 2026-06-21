# Skill: `fetch_trends`

## Purpose

A Worker calls this skill to **retrieve trending topics for the agent's niche**, via an **MCP news resource**.

## Input Contract

```json
{
  "niche": "string",
  "time_window_hours": "integer",
  "source": "string (MCP resource URI)"
}
```

## Output Contract

```json
{
  "trends": [
    {
      "topic": "string",
      "relevance_score": "number 0.0-1.0",
      "source": "string",
      "detected_at": "timestamp"
    }
  ]
}
```

## Errors

- **`ResourceUnavailableException`** — raised if the MCP resource cannot be reached.

## Note

Only trends with `relevance_score` **above `0.75`** are passed to the Planner (per [specs/acceptance.md](../../specs/acceptance.md)).
