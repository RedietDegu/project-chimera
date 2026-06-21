# Project Chimera — build automation
# The project targets Java 21. If a local Temurin 21 is present (e.g. on the
# developer's Mac, where the default JDK may differ), pin the build to it so it
# is reproducible. In CI, JAVA_HOME is already set by setup-java, so leave it be.
LOCAL_JDK21 := /Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home
ifneq ($(wildcard $(LOCAL_JDK21)),)
export JAVA_HOME := $(LOCAL_JDK21)
endif

.PHONY: help setup test lint format docker-test

help:
	@echo "Project Chimera — available commands:"
	@echo "  make setup        - build and install dependencies (skips tests)"
	@echo "  make test         - run the test suite"
	@echo "  make lint         - check formatting (Spotless)"
	@echo "  make format       - apply formatting (Spotless)"
	@echo "  make docker-test  - build the image and run the tests inside it"

setup:
	mvn clean install -DskipTests

test:
	mvn test

lint:
	mvn spotless:check

format:
	mvn spotless:apply

docker-test:
	docker build -t project-chimera:test .
	docker run --rm project-chimera:test
