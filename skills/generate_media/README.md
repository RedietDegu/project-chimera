# Skill: `generate_media`

## Purpose

A Worker calls this skill to **generate on-brand image or video content** via an **MCP generation tool**, with **character consistency**.

## Input Contract

```json
{
  "version": "1.0",
  "prompt": "string (required)",
  "character_reference_id": "string (required)",
  "media_type": "image | video (required)",
  "tier": "daily | hero (required)"
}
```

## Output Contract

```json
{
  "version": "1.0",
  "media_url": "string (required)",
  "generation_id": "string (required)",
  "cost_usd": "number (required)"
}
```

## Example

**Input:**

```json
{
  "version": "1.0",
  "prompt": "a daily selfie in a sunlit cafe",
  "character_reference_id": "char-001",
  "media_type": "image",
  "tier": "daily"
}
```

**Output:**

```json
{
  "version": "1.0",
  "media_url": "https://cdn.chimera.internal/media/gen-9f2a.png",
  "generation_id": "gen-9f2a",
  "cost_usd": 0.04
}
```

## Errors

- **`BudgetExceededException`** — raised if the projected cost would exceed the daily budget.
- **`ValidationError`** — raised if the Judge's likeness check fails.

## Note

Every request **MUST** include `character_reference_id` so the influencer stays recognizable (per [specs/technical.md](../../specs/technical.md) and [specs/acceptance.md](../../specs/acceptance.md)).
