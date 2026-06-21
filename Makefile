# Project Chimera — build automation
# The project targets Java 21; pin the build to Temurin 21 so it is reproducible
# regardless of the shell's default JDK.
export JAVA_HOME := /Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home

.PHONY: help setup test lint format

help:
	@echo "Project Chimera — available commands:"
	@echo "  make setup   - build and install dependencies (skips tests)"
	@echo "  make test    - run the test suite"
	@echo "  make lint    - check formatting (Spotless)"
	@echo "  make format  - apply formatting (Spotless)"

setup:
	mvn clean install -DskipTests

test:
	mvn test

lint:
	mvn spotless:check

format:
	mvn spotless:apply
