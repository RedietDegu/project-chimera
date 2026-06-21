# Project Chimera — Master Specification: MCP Configuration

*External tool/service configuration required by agents.*

---

## Two Categories

MCP servers in Project Chimera fall into two distinct categories:

- **Developer MCPs** — servers that help the **engineer build** the system, used during development rather than at runtime. Examples: `git-mcp` for version control, `filesystem-mcp` for file edits, plus the **Tenx feedback analytics recorder**.
- **Agent Runtime MCPs** — servers the **Chimera agents use at runtime** to perceive and act on the outside world. All external connectivity from the agent core flows through these.

---

## Agent Runtime MCP Servers

- **`mcp-server-twitter`** — post and reply to content, and read mentions.
- **`mcp-server-weaviate`** — semantic memory (vector storage and retrieval).
- **`mcp-server-coinbase`** — wallet and transaction operations (agentic commerce).
- **`mcp-server-openclaw`** — publish status and discover peer agents on the agent network.
- **Image / video generation server** — e.g. `mcp-server-ideogram` or `mcp-server-runway` — for media generation.

---

## Authentication & Secrets

Every runtime MCP server's credentials — **API keys and wallet keys** — are **injected from the secrets manager as environment variables at startup** and are **NEVER written into the config file** (see [specs/security.md](security.md) for the authoritative secrets model). The config references secrets only by environment-variable placeholder (e.g. `${TWITTER_API_KEY}`), so the file itself stays free of sensitive material and safe to commit.

---

## Sample Configuration

A full `mcpServers` block configuring all five runtime servers, with secrets injected via environment variables:

```json
{
  "mcpServers": {
    "twitter": {
      "transport": "sse",
      "url": "https://mcp.chimera.internal/twitter/sse",
      "env": { "TWITTER_API_KEY": "${TWITTER_API_KEY}" }
    },
    "weaviate": {
      "transport": "stdio",
      "command": "mcp-server-weaviate",
      "env": { "WEAVIATE_API_KEY": "${WEAVIATE_API_KEY}" }
    },
    "coinbase": {
      "transport": "sse",
      "url": "https://mcp.chimera.internal/coinbase/sse",
      "env": {
        "COINBASE_API_KEY": "${COINBASE_API_KEY}",
        "WALLET_PRIVATE_KEY": "${WALLET_PRIVATE_KEY}"
      }
    },
    "openclaw": {
      "transport": "sse",
      "url": "https://mcp.chimera.internal/openclaw/sse",
      "env": { "OPENCLAW_API_KEY": "${OPENCLAW_API_KEY}" }
    },
    "media": {
      "transport": "sse",
      "url": "https://mcp.chimera.internal/media/sse",
      "env": { "MEDIA_API_KEY": "${MEDIA_API_KEY}" }
    }
  }
}
```

---

## Transports

**stdio** is used for **local** servers; **SSE / HTTP** is used for **remote** servers.

---

## Reliability

Each runtime server defines:

- a **connection timeout** — how long the agent core waits before treating a server as unreachable;
- a **retry policy** — a maximum number of retries with **exponential backoff**;
- a **rate limit** — the maximum request rate the agent core will issue to that server.

If a server is **unavailable** after retries, the agent core **fails safe**: the task is **re-queued for the Planner**, never silently dropped.
