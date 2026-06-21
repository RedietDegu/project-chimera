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

## Sample Configuration

```json
{
  "mcpServers": {
    "weaviate": {
      "transport": "stdio",
      "command": "mcp-server-weaviate"
    },
    "twitter": {
      "transport": "sse",
      "url": "https://mcp.chimera.internal/twitter/sse"
    }
  }
}
```

---

## Transports

**stdio** is used for **local** servers; **SSE / HTTP** is used for **remote** servers.
