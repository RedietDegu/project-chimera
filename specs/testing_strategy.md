# Project Chimera — Master Specification: Testing Strategy

*The test-first approach that drives autonomous implementation.*

---

## Red–Green–Refactor

Project Chimera is built test-first:

1. **Red** — the specs define the required behaviour; **failing tests are written first**, encoding the acceptance criteria.
2. **Green** — an agent **implements against the specs** until the tests pass.
3. **Refactor** — with the suite green, the implementation is cleaned up without changing behaviour.

The tests are therefore an **executable contract**: when they go green, the specs have been faithfully implemented.

## Test Layers

- **Unit tests** — exercise the data models in isolation (e.g. record immutability and accessors). These run against already-implemented `record` DTOs and are **green today**.
- **Contract tests** — validate each skill's Input/Output contract and boundary rules (budget, relevance threshold). These run against the skill **stubs** (`StubTrendFetcher`, `StubMediaGenerator`) and are **intentionally red** until the skills are implemented.
- **Integration tests** — will exercise the end-to-end Planner–Worker–Judge flow (task dispatch → execution → gating). **Not yet present / stubbed** — to be added once the skills are implemented.

## Test-to-Spec Mapping

| Test file | Validates | Status |
| --- | --- | --- |
| `DataModelImmutabilityTest` | `specs/technical.md` — immutable record DTOs | Green |
| `TrendFetcherTest` | `skills/fetch_trends` + `specs/acceptance.md` (relevance) | Red (stub) |
| `RelevanceThresholdTest` | `skills/fetch_trends` — strict `> 0.75` boundary | Red (stub) |
| `SkillsInterfaceTest` | `skills/generate_media` — budget reject + daily generate | Red (stub) |
| `BudgetBoundaryTest` | `skills/generate_media` + `specs/acceptance.md` (budget boundary) | Red (stub) |
| *(integration — Planner→Worker→Judge)* | `specs/technical.md` swarm flow | Not yet added |

## Continuous Integration

CI runs the **full test suite on every push and pull request** (see [.github/workflows/main.yml](../.github/workflows/main.yml)). Under TDD the `test` job is **expected to be red** until the skills are implemented; that red state is the signal of outstanding implementation work, not a broken build.
