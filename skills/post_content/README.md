# Skill: `post_content`

## Purpose

A Worker calls this skill to **publish approved content** to a connected social platform, via the **twitter MCP** server.

## Input Contract

```json
{
  "version": "1.0",
  "platform": "twitter | instagram | threads (required)",
  "text_content": "string (required)",
  "media_urls": "array of string (optional)",
  "disclosure_level": "automated | assisted | none (required)"
}
```

## Output Contract

```json
{
  "version": "1.0",
  "post_id": "string (required)",
  "post_url": "string (required)",
  "posted_at": "timestamp (required)"
}
```

## Example

**Input:**

```json
{
  "version": "1.0",
  "platform": "twitter",
  "text_content": "New drop today — habesha kemis, reimagined.",
  "media_urls": ["https://cdn.chimera.internal/media/gen-9f2a.png"],
  "disclosure_level": "automated"
}
```

**Output:**

```json
{
  "version": "1.0",
  "post_id": "1789xxxxxxxxxxxxx",
  "post_url": "https://twitter.com/chimera_agent/status/1789xxxxxxxxxxxxx",
  "posted_at": "2026-06-21T10:00:00Z"
}
```

## Errors

- **`RateLimitException`** — raised when the platform's rate limit is exceeded.
- **`PublishException`** — raised when the platform rejects or fails to accept the post.

## Note

**Only content already approved by the Judge / HITL may be published.** This skill is the final publish step, not a content gate — it assumes approval has already happened upstream.
