# OOP Assignment – Byiringiro Urbain (27150)


# Names: Byiringiro Urbain Bobola
# id: 27150
# Date: 18 November 2025

## Overview
- All Java sources are under the root package `_27150`.
- Each question `q1` … `q10` is implemented as a dedicated subpackage .
- Every console output must include the student ID. This is enforced centrally via `_27150.StudentOutput`, which wraps `System.out` so no manual string changes are needed.

## Package Layout
- `_27150/StudentOutput.java` – shared utility that appends `27150` to every `System.out` call once `StudentOutput.enable()` runs. All `main` methods enable it at startup.
- `_27150/q1` … `_27150/q10` – per-question modules. Typical contents:
  - `*ManagementSystem` (or equivalent) – interactive program that prompts the user, validates input, and prints the assembled record.
  - `*Record`, entity classes, and custom exception types that encapsulate the business rules for that question.
  - `Test*System` – deterministic test harness showcasing validation failures and calculations without user input.

## Prerequisites
- JDK 17+ available on the PATH.
- Run commands from the repository root:

## Build
```powershell

$files = Get-ChildItem -Recurse -Filter *.java
javac $files.FullName
```

This compiles every package in place and produces `.class` files alongside the sources, matching the existing structure.

## Run Examples
Because the root package is `_27150`, every `java` command must include that namespace.

### Interactive runner (example: Question 1 Hospital System)
```powershell

java _27150.q1.HospitalManagementSystem
```

### Automated test harness (example: Question 1 tests)
```powershell

java _27150.q1.TestHospitalSystem
```

Replace `q1` with `q2` … `q10` and the class name (`SchoolManagementSystem`, `TestSchoolSystem`, etc.) to run any other scenario. All runners automatically call `StudentOutput.enable()`, so outputs are already suffixed with `27150`.

## Notes
- If you need to temporarily disable the ID suffix (e.g., for debugging), call `StudentOutput.restore()` before the program exits, but coursework submissions should keep it enabled for every run.
