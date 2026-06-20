# Project Chimera — Research Summary

*Day 1 Deliverable*

## 1. Reading Insights

**a16z, "The Trillion Dollar AI Code Stack."** a16z argues that the entire software development lifecycle (SDLC) is being rebuilt around autonomous agents rather than retrofitted to accommodate them. As agents move from autocomplete assistants to first-class authors of code, the tools, interfaces, and workflows of the SDLC must be redesigned to serve machine collaborators directly. The guiding principle is to **build for agents as well as humans** — treating agents as primary consumers of documentation, APIs, and tooling, not just as features bolted onto human-centric systems. This reframing implies a vast new layer of infrastructure (and economic value) across the stack.

**OpenClaw.** OpenClaw is an open-source, local-first agent framework. Rather than locking memory and behavior into opaque databases or proprietary cloud services, it stores an agent's **memory and skills as plain Markdown files** on the user's own machine, making agent state legible, portable, and user-owned. It is extensible through a **portable skill format**, so capabilities can be authored, shared, and composed across agents and deployments. This local-first, file-based design lowers the barrier to inspection and customization and aligns with a broader move toward transparent, user-controlled agent infrastructure.

**Moltbook.** Launched in January 2026, Moltbook is described as the first **agent-only social network**: a platform where only verified AI agents may post and interact, while humans participate solely as observers. It inverts the usual model of social media — instead of humans producing content for algorithmic distribution, autonomous agents are the authors and audience, and humans watch the agent-to-agent discourse unfold. Moltbook is an early, concrete instance of the "Open Agentic Web," where agents form a social layer of their own.

**Project Chimera SRS.** The Software Requirements Specification defines Chimera as a multi-agent system built on a **Planner–Worker–Judge swarm**: a Planner decomposes goals into tasks, Workers execute them, and a Judge evaluates and validates outputs before they are accepted. The system uses **MCP (Model Context Protocol)-based connectivity** to reach external tools, resources, and data sources in a standardized way, and supports **agentic commerce** — agents that can transact on a user's behalf. Together these establish Chimera as an autonomous, tool-using, transaction-capable agent system rather than a single conversational model.

## 2. Security Context

Agents in this ecosystem operate with **credential-level access to a user's entire digital life** — email, calendars, files, payment instruments, and connected services — and the skills that drive them are easy to author, share, and therefore to abuse. A malicious or poorly written skill, or a prompt-injection attack delivered through untrusted content, can turn that broad access into real-world harm: data exfiltration, unauthorized purchases, or destructive actions taken at machine speed and scale. Because the blast radius of a misbehaving agent is so large and the attack surface (skills, tools, external content, other agents) so wide, a **Human-in-the-Loop (HITL) safety layer** — requiring explicit human confirmation for sensitive or irreversible actions — is a necessary control rather than an optional feature.

## 3. Q1: How Chimera Fits into the OpenClaw Agent Social Network

Chimera is not only a system that *influences humans* — it is also a *participant in an agent-to-agent network*. Beyond serving its own user, a Chimera agent publishes its **availability and status** to a social layer like OpenClaw, making itself **discoverable** to other agents that might need its capabilities. It can be found, contacted, and engaged by peer agents, and it can **transact via wallets** to pay for or be paid for services. In this framing, Chimera is a **socially integrated participant in the "Open Agentic Web"** — an agent that advertises what it can do, negotiates and delegates work with other agents, and settles value autonomously — rather than an isolated bot operating in a silo. Its value compounds through participation in a broader marketplace of cooperating agents.

## 4. Q2: Social Protocols for Agent-to-Agent Communication

For Chimera to operate as a first-class member of an agent network, a set of social and technical protocols is required:

1. **Identity & Verification** — Each agent must carry a verifiable identity so peers can confirm who (or what) they are interacting with, and so platforms like Moltbook can restrict participation to verified agents.
2. **Capability Advertisement & Discovery** — Agents must publish a machine-readable description of the skills and services they offer, and be able to discover others' capabilities, to find suitable collaborators.
3. **Status / Availability Publishing** — Agents broadcast their current state (online, busy, accepting work) so peers know when and whether they can be engaged.
4. **MCP for Shared Tools & Resources** — The Model Context Protocol provides a standardized way to expose and consume tools, resources, and data, enabling interoperable access across agents and services.
5. **Task Negotiation & Delegation** — Agents need protocols to propose work, agree on terms, hand off subtasks, and report results — the basis of cooperative, multi-agent problem solving.
6. **Reputation & Norms** — Shared reputation signals and behavioral norms let agents decide whom to trust and discourage bad actors over repeated interactions.
7. **Agentic Commerce (ACP / AgentKit)** — Standardized commerce protocols (e.g., Agentic Commerce Protocol, AgentKit) let agents pay, get paid, and settle transactions programmatically and safely.
8. **Trust & Safety** — Cross-cutting safeguards including **scoped credentials** (least-privilege access), **prompt-injection resistance**, and norms of **honesty and disclosure** (agents identifying themselves as agents and representing their capabilities truthfully).

## Sources

- **a16z** — "The Trillion Dollar AI Code Stack" (a16z.com)
- **OpenClaw** — open-source, local-first agent framework (Markdown-based memory and portable skills)
- **Moltbook** — agent-only social network (launched January 2026)
- **Project Chimera SRS** — Software Requirements Specification (Planner–Worker–Judge swarm, MCP connectivity, agentic commerce)
- **Security research on agent ecosystems** — credential exposure, skill abuse, and prompt-injection risks motivating Human-in-the-Loop controls
