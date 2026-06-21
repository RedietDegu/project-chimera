package com.chimera.swarm;

import com.chimera.model.AgentTask;
import com.chimera.model.WorkerResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Concurrency layer for the Planner-Worker-Judge swarm.
 *
 * <p>Each dispatched task runs on its own Java 21 Virtual Thread. Because virtual threads are
 * lightweight and decoupled from OS threads, the swarm can run thousands of Workers in parallel
 * without exhausting the underlying platform thread pool.
 */
public class SwarmExecutor implements AutoCloseable {

  /** Executes a single {@link AgentTask} and returns its {@link WorkerResult}. */
  @FunctionalInterface
  public interface Worker {
    WorkerResult execute(AgentTask task);
  }

  private final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

  /** Submits each task to its own virtual thread and returns the pending Futures. */
  public List<Future<WorkerResult>> dispatch(List<AgentTask> tasks, Worker worker) {
    List<Future<WorkerResult>> futures = new ArrayList<>(tasks.size());
    for (AgentTask task : tasks) {
      futures.add(executor.submit(() -> worker.execute(task)));
    }
    return futures;
  }

  @Override
  public void close() {
    executor.close();
  }
}
