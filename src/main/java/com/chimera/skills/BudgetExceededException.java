package com.chimera.skills;

/** Raised when a projected cost would exceed the configured daily budget. */
public class BudgetExceededException extends Exception {

  public BudgetExceededException(String message) {
    super(message);
  }
}
