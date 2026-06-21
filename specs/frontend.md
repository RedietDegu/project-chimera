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

---

## User Flows

1. **Operator** sets a goal, reviews the task tree, then monitors the fleet.
2. **Reviewer** opens a flagged item from the queue and chooses **Approve**, **Reject**, or **Edit**.

---

## Integration Contracts

- The **Review Card** POSTs to `/api/approve/{task_id}` and `/api/reject/{task_id}`.
- The **Fleet Status View** reads `GET /api/fleet/status`.
- The **review queue** is read from `GET /api/reviews?status=pending`.
