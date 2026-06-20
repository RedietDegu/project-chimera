# Project Chimera — Master Specification: Functional

*User Stories, grouped by actor*

## Network Operator

- As a **Network Operator**, I want to **set a high-level campaign goal in natural language** and have the swarm decompose it, so that I can direct the fleet without manually breaking work into tasks.
- As a **Network Operator**, I want to **monitor fleet health, task queues, and wallet balances on a dashboard**, so that I have real-time visibility into what the swarm is doing and spending.

## Human Reviewer (HITL Moderator)

- As a **Human Reviewer**, I want to **see flagged content in a review queue and Approve, Reject, or Edit it**, so that risky content never auto-publishes.

## Planner Agent

- As a **Planner agent**, I want to **read the GlobalState (goals, trends, budget) and decompose it into a task graph**, so that Workers have well-scoped, executable tasks.
- As a **Planner agent**, I want to **re-plan dynamically when context changes or a task fails**, so that the swarm adapts instead of stalling.

## Worker Agent

- As a **Worker agent**, I want to **fetch current trends via an MCP Resource**, so that the content I produce is timely and relevant.
- As a **Worker agent**, I want to **generate text, image, and video via MCP Tools**, so that I can produce content across formats through a standardized interface.
- As a **Worker agent**, I want to **attach a character-consistency reference to every image**, so that the influencer stays visually recognizable across all content.

## Judge Agent

- As a **Judge agent**, I want to **score each Worker output's confidence and route it (auto-approve, send to HITL, or reject/retry)**, so that quality and safety are enforced on every result.
- As the **"CFO" Judge**, I want to **check the budget before approving any transaction**, so that the network never spends beyond its limits.

## Developer

- As a **Developer**, I want to **add a new social platform by deploying a new MCP server, without changing the core agent logic**, so that the system extends to new platforms with minimal risk to the core.
