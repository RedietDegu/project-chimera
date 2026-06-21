# Project Chimera

**Spec-driven agentic infrastructure for an Autonomous Influencer Network.**

---

## What this repo is

Project Chimera is a **specification-first scaffold**, not a finished product. It is a blueprint that AI coding agents use to build features.

- The **`specs/` directory is the single source of truth.** AI coding agents implement *against* the specs — code follows a ratified spec, never the other way around.
- The **tests are intentionally failing (red)**. They encode the acceptance criteria from the specs; an agent's job is to implement the specs until the tests turn **green**. This is test-driven development at the agent scale.

If you are reading the code expecting a working application, read the specs instead — they describe what the system *will* do once the agents have implemented them.

## Architecture at a glance

- **Planner–Worker–Judge swarm** — a Planner decomposes goals into tasks, stateless Workers execute them in parallel, and a Judge gates quality and safety on every result.
- **MCP-only external connectivity** — all external and third-party calls flow through the Model Context Protocol; the agent core never calls external APIs directly.
- **Confidence-gated Human-in-the-Loop** — low-confidence or sensitive outputs are routed to human review before they can be published.

See [research/architecture_strategy.md](research/architecture_strategy.md) for the full rationale and diagrams.

## Repository structure

```text
project-chimera/
├── CLAUDE.md                  # Agent rule file — governs how coding agents behave here
├── specs/                     # Single source of truth: vision, contracts, acceptance criteria
├── skills/                    # Agent capabilities defined as formal I/O contracts
├── src/main/                  # Java 21 source — immutable DTOs, skill interfaces, swarm layer
├── src/test/                  # JUnit 5 acceptance tests (intentionally red under TDD)
├── research/                  # Background analysis and architecture strategy + diagrams
├── .github/workflows/         # CI pipeline (lint + tests) on push and pull request
├── Makefile                   # Build automation: setup, test, lint, format, docker-test
└── Dockerfile                 # Reproducible Java 21 + Maven build/test environment
```

## How the agent workflow works

1. **`CLAUDE.md` is the agent rule file.** Its prime directive: *never write implementation code without first consulting `specs/`.*
2. **`specs/` is the source of truth.** Every feature traces to a ratified spec; ambiguity is resolved in the spec before any code is written.
3. **`skills/` defines agent capabilities** as formal Input/Output contracts, so a Worker knows exactly what each capability consumes and returns.

## Getting started

**Prerequisites:** Java 21, Maven, and Docker.

| Command | Description |
| --- | --- |
| `make setup` | Build and install dependencies (skips tests) |
| `make test` | Run the test suite (red by design under TDD) |
| `make lint` | Check formatting (Spotless) |
| `make format` | Apply formatting (Spotless) |
| `make docker-test` | Run the suite inside a reproducible container |

`make docker-test` builds the Docker image and runs the test suite inside it, giving a clean, reproducible Java 21 + Maven environment independent of your local toolchain.

## Governance

Every pull request must pass two gates before merge:

- **CI pipeline** ([GitHub Actions](.github/workflows/main.yml)) — runs `lint` and `tests`.
- **CodeRabbit AI review** — an automated reviewer enforcing **spec alignment**, **thread safety**, and **security** on every change.

## Tech stack

- **Java 21** — Records (immutable DTOs) and Virtual Threads (parallel Workers)
- **Maven** — build and dependency management
- **JUnit 5** — acceptance tests
- **Docker** — reproducible build/test environment
- **GitHub Actions** — continuous integration
- **CodeRabbit** — automated AI code review
