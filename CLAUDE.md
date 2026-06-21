# CLAUDE.md — Project Chimera Agent Rules

## Project Context

This is **Project Chimera**, an autonomous AI-influencer system: a fleet of agents that research trends, generate content, manage engagement, and transact, coordinated by a **Planner–Worker–Judge swarm** and connected to the outside world **only through the Model Context Protocol (MCP)**.

## Prime Directive

**NEVER generate implementation code without first checking the `specs/` directory.** The `specs/` folder is the **single source of truth**. If a spec is missing or ambiguous, **ask before coding**.

## Java Directives

- Strictly use **Java 21+** idioms.
- Use **Java Records** for all immutable data-transfer objects (DTOs) passed between Planner, Worker, and Judge (for example `AgentTask` and `WorkerResult`).
- Use **Java 21 Virtual Threads** (`Executors.newVirtualThreadPerTaskExecutor()`) for parallel Worker execution.
- All external and third-party API calls go **through MCP** — never call external APIs directly from agent-core code.
- Use **JUnit 5** for all generated tests; tests live in `src/test/java`.

## Traceability

- **Explain your plan before writing code**, and state which spec file the change implements.
- Keep commits **small** with **conventional-commit** messages (`feat:`, `docs:`, `test:`, `chore:`).
