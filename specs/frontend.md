# Project Chimera — Master Specification: Frontend

*User-facing views, flows, and integration contracts.*

---

## Overview

The frontend is a **React + Tailwind** application with two surfaces:

- the **Orchestration Dashboard** — for Network Operators, and
- the **HITL Review Interface** — for Human Reviewers.

---

## Views

### Fleet Status View

A **real-time** list of agents showing each agent's current state (**Planning / Working / Judging / Sleeping**), **wallet balance**, and **HITL queue depth**.

### Campaign Composer

An Operator types a **natural-language goal**; the Planner decomposes it into a **task tree** the Operator can **inspect and edit before execution**.

### Review Card (HITL)

Displays the generated content, a **colour-coded confidence badge** (green `> 0.90`, yellow `0.70–0.90`, red `< 0.70`), the **reasoning trace**, and **Approve / Reject** buttons. A **red border** appears when confidence `< 0.80`.

### Wallet & Transactions View

Per-agent **wallet balance**, a list of **recent transactions**, and a **spend-vs-budget bar** showing daily spend against the configured budget limit.

### Settings View

Edit an agent's **persona**, **niche**, and **daily budget limit**.

---

## Authentication

Operators and Reviewers sign in via **OAuth2 / JWT** (see [specs/security.md](security.md) for the authoritative auth model).

- **Login flow:** the user authenticates through the OAuth2 provider; on success the dashboard receives a signed **JWT** and stores it for the session.
- **Authenticated requests:** the JWT is sent as a **`Authorization: Bearer <token>`** header on **every** API and WebSocket call. Requests without a valid token are rejected.

---

## UI States

Every data view defines three states:

- **Loading** — data is being fetched (skeleton / spinner).
- **Empty** — the request succeeded but returned no data.
- **Error** — the request failed; show a retryable error message rather than blank content.

---

## User Flows

1. **Operator** sets a goal, reviews the task tree, then monitors the fleet.
2. **Reviewer** opens a flagged item from the queue and chooses **Approve**, **Reject**, or **Edit**.

---

## Integration Contracts

- The **Review Card** POSTs to `/api/approve/{task_id}` and `/api/reject/{task_id}`.
- The **Fleet Status View** loads initial data from `GET /api/fleet/status`, then **subscribes to live updates over a WebSocket** at `WS /ws/fleet`.
- The **review queue** is read from `GET /api/reviews?status=pending`.

All requests carry the `Authorization: Bearer <token>` header (see [Authentication](#authentication)).

**Example — `POST /api/approve/{task_id}` response:**

```json
{
  "task_id": "uuid",
  "status": "approved",
  "approved_by": "reviewer-id",
  "approved_at": "timestamp"
}
```

**Example — `GET /api/fleet/status` response:**

```json
{
  "agents": [
    {
      "agent_id": "uuid",
      "name": "string",
      "state": "Planning | Working | Judging | Sleeping",
      "wallet_balance": "number",
      "hitl_queue_depth": "integer"
    }
  ]
}
```
