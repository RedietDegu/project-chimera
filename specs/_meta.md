# Project Chimera — Master Specification: Meta

*Vision & Constraints*

## Vision

Project Chimera is an **Autonomous Influencer Network** — a fleet of goal-directed AI agents that research trends, generate content, manage engagement, and transact on-chain, all overseen by a single human **"Super-Orchestrator"** in a **fractal orchestration model**. It represents a shift away from scheduled content automation toward **autonomous agents possessing perception, reasoning, creative expression, and economic agency**. Rather than executing a fixed publishing calendar, Chimera agents perceive their environment, reason about goals, create original content, and act economically on their own.

## Source of Truth

This `specs/` directory is the **single source of truth** for Project Chimera. Implementation code is written **only after a spec is ratified** — we practice **spec-driven development**, so the specification leads and the code follows.

## Architecture in One Line

A **Planner–Worker–Judge swarm** for internal coordination, the **Model Context Protocol (MCP)** for all external connectivity, and **agentic commerce via non-custodial wallets** for economic agency.

## Constraints

1. **Regulatory** — The system must comply with AI-transparency law such as the **EU AI Act**. Agents **self-disclose their AI nature when asked**.
2. **Cost** — A **Resource Governor** enforces budget limits to prevent runaway inference and media-generation costs.
3. **Platform volatility** — Social-media APIs change frequently, so **all platform-specific logic lives at the MCP-server layer**, shielding the core agent from breaking changes.
4. **Technical** — **Java 21+**; all external calls go **through MCP** (no direct API calls from the agent core); **immutable DTOs via Java Records**; **Virtual Threads** for parallel Workers.
5. **Safety** — **Low-confidence or sensitive content must pass Human-in-the-Loop (HITL) review** before it can be published.
