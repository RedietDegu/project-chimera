# Project Chimera — Master Specification: Acceptance Criteria

*Testable definitions of when each feature is complete, written as Given / When / Then.*

---

## Trend Fetcher

- **Given** an MCP news resource,
- **When** a Worker fetches trends,
- **Then** it returns items matching the trend schema, **and only items with a relevance score above `0.75`** create a new task for the Planner.

## Content Generation & Character Consistency

- **Given** an image-generation task,
- **When** a Worker generates an image,
- **Then** the request includes a `character_reference_id`, **and** the Judge verifies the likeness **before** the content is published.

## HITL Routing

- **Given** a `WorkerResult` with a `confidence_score`,
- **When** the Judge evaluates it,
- **Then** a score **above `0.90` auto-approves**, **`0.70–0.90` queues for human approval**, and **below `0.70` auto-rejects**; **and** any **sensitive-topic content (politics, health, finance, legal) always queues for human review regardless of score.**

## Budget Governance

- **Given** a transaction request,
- **When** daily spend plus the amount exceeds the configured limit,
- **Then** the CFO Judge **rejects it and raises a `BudgetExceededException`**.

## AI Disclosure

- **Given** a direct "are you an AI?" inquiry,
- **When** the agent responds,
- **Then** it **truthfully discloses that it is an AI persona**.
