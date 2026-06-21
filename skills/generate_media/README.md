# Skill: `generate_media`

## Purpose

A Worker calls this skill to **generate on-brand image or video content** via an **MCP generation tool**, with **character consistency**.

## Input Contract

```json
{
  "prompt": "string",
  "character_reference_id": "string",
  "media_type": "image | video",
  "tier": "daily | hero"
}
```

## Output Contract

```json
{
  "media_url": "string",
  "generation_id": "string",
  "cost_usd": "number"
}
```

## Errors

- **`BudgetExceededException`** — raised if the projected cost would exceed the daily budget.
- **`ValidationError`** — raised if the Judge's likeness check fails.

## Note

Every request **MUST** include `character_reference_id` so the influencer stays recognizable (per [specs/technical.md](../../specs/technical.md) and [specs/acceptance.md](../../specs/acceptance.md)).
