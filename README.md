# Lab 09: Refactoring, Defensive Programming, Tracing & Unit Testing

## Overview
This repository contains the complete Java (JDK 21 / Maven) implementation for **Software Construction Lab 09**, covering legacy code refactoring, fail-fast immutable domain modeling, structured request tracing, and isolated JUnit 5 unit testing.

## Task Descriptions

### Task 1: Refactoring Legacy Code (`ReportManager`)
- Replaced string concatenation inside a loop with `String.join(",", data)`.
- Fixed null-unsafe `type.equals(...)` checks and handled unsupported report types safely.
- Extracted report formatting behind the `ReportFormatter` interface (`PdfReportFormatter`, `CsvReportFormatter`) and injected `Notifier` (`ConsoleNotifier`) via constructor dependency injection.

### Task 2: Fail-Fast & Immutable Boundaries (`BankTransfer`)
- Implemented `BankTransfer` as an immutable Java `record` using `BigDecimal` for monetary precision.
- Added compact constructor guard clauses (`Objects.requireNonNull` and `amount.compareTo(BigDecimal.ZERO) <= 0`) to throw `NullPointerException` or `IllegalArgumentException` immediately on invalid construction.

### Task 3: Structured Tracing (`PaymentProcessor`)
- Added `[TraceID: ...]` structured console logging across payment execution and failure paths.
- Guaranteed trace context cleanup (`traceId = null` / `Context Cleared`) inside a `finally` block so stale correlation state cannot leak across operations.

### Task 4: Isolated Unit Testing with JUnit 5 (`OrderServiceTest`)
- Configured JUnit Jupiter 5 in `pom.xml` and verified VIP discount calculation (`calculateTotal_appliesVipDiscount_withoutTouchingDatabase`) using the **Arrange-Act-Assert** pattern without database dependencies.

## Project Structure
- `src/main/java/`
  - `ReportFormatter.java`, `PdfReportFormatter.java`, `CsvReportFormatter.java`
  - `Notifier.java`, `ConsoleNotifier.java`
  - `ReportManager.java`, `Lab09.java`
  - `BankTransfer.java`, `BankTransferMain.java`
  - `PaymentProcessor.java`
  - `OrderService.java`
- `src/test/java/`
  - `OrderServiceTest.java`

## How to Run
1. Open the `Lab09` Maven project in **Apache NetBeans** (JDK 21).
2. Right-click and select **Run File** (`Shift + F6`) on:
   - `Lab09.java` (Task 1)
   - `BankTransferMain.java` (Task 2)
   - `PaymentProcessor.java` (Task 3)
3. Right-click `OrderServiceTest.java` under **Test Packages** and select **Test File** (`Ctrl + F6`) to run the JUnit 5 test.
