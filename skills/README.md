# Project Chimera — Agent Skills

A **Skill** is a **reusable runtime capability** the Chimera agent invokes to get something done. It is **distinct from an MCP server**: an MCP server is an **external bridge** to the outside world, whereas a Skill is an internal, composable capability the agent calls (and which may itself use one or more MCP servers under the hood).

## Convention

Each skill lives in **its own folder** with a `README.md` that defines:

- **Purpose** — what the skill does and when an agent invokes it.
- **Input contract** — the formal shape of the input.
- **Output contract** — the formal shape of the output.
- **Errors** — the exceptions the skill can raise.

## Skills

- [`fetch_trends`](fetch_trends/README.md) — retrieve trending topics for the agent's niche via an MCP news resource.
- [`generate_media`](generate_media/README.md) — generate on-brand image or video content via an MCP generation tool, with character consistency.
