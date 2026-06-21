# Project Chimera — Master Specification: Security

*Authentication, authorization, secrets, rate limiting, and containment.*

---

## Authentication

Operators and Reviewers sign in to the dashboard via **OAuth2 / JWT sessions**.

## Authorization

**Role-based access control (RBAC)** with three roles — **Network Operator**, **HITL Moderator**, and **Developer** — plus **strict multi-tenant data isolation**, so one tenant's agents, memories, and wallets are **never visible to another**.

## Secrets Management

Agent **wallet private keys** and all **API keys** live in an **encrypted secrets manager** (**AWS Secrets Manager** or **HashiCorp Vault**), injected into the agent runtime **only at startup** — **never logged or committed**.

## Rate Limiting

Enforced at the **MCP layer**, which also provides **request logging** and a **dry-run mode** for testing.

## Containment Boundaries

- Each agent runs in an **isolated environment**.
- A **Resource Governor** caps **daily spend**.
- The **CFO Judge** must approve **every transaction**.
- **Sensitive-topic content** is forced through **Human-in-the-Loop** review.
- Agents follow an **honesty / disclosure directive** and use **least-privilege scoped credentials** to **resist prompt injection**.
