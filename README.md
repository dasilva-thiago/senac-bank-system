# senac-bank-system
This project was initially developed as part of an assessment at Senac. I decided to continue improving the code, refining its structure, and adding new features. By hosting it on GitHub, I aim to showcase my work, demonstrate my development skills, and continue growing as a software developer.

SENAC Bank – Java Banking System

[![Java Version](https://img.shields.io/badge/Java-11%2B-orange)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

1. Overview

A Java-based ATM simulation that evolves from a simple procedural implementation to a clean, maintainable, and professional architecture.
SENAC Bank is a console-based banking system built to demonstrate progressive code improvement.
It includes realistic banking operations such as:

Checking balances

Depositing funds

Withdrawing with banknote control

Loan simulation

Managing ATM cash inventory

The project serves as an educational tool for understanding code evolution, clean architecture, and object-oriented design.


2. Project Evolution
v1 – Basic Version

A minimal implementation focused on core logic.
Features:

Procedural code in a single file

Simple control flow

No modularization or abstractions

v2 – Professional Version

A refactored version applying real-world development principles.
Highlights:

Layered architecture (Model–View–Service)

Object-Oriented Programming (Encapsulation, Enums)

BigDecimal for precise monetary calculations

Robust input validation

Organized package structure and improved user interface

3. Running the Project
Basic Version
cd v1-basic
javac SenacBank.java
java SenacBank

Professional Version
cd v2-professional/src
javac com/senacbank/Main.java
java com.senacbank.Main

4. Technologies

Java 11+

Collections Framework

Enums

BigDecimal for monetary precision

Scanner for input handling

5. Development Roadmap
Version	Description

✅ v1	Basic implementation

✅ v2	Professional architecture

⏳ v3	File persistence

⏳ v4	Database integration (JDBC)

⏳ v5	REST API with Spring Boot

⏳ v6	Unit testing (JUnit)

⏳ v7	Docker and CI/CD pipeline


6. Key Principles and Practices

Design Patterns: Service Layer, MVC

Clean Code: descriptive naming, small methods, readability

SOLID: Single Responsibility Principle

Error Handling: structured exception control and validation

Architecture: clear separation of responsibilities

7. Author

Da Silva, Thiago
[LinkedIn](https://www.linkedin.com/in/thiago-da-silva-876805269/) | [GitHub](github.com/dasilva-thiago) | [Email](mailto:thiagosilva785@gmail.com)

8. License

This project is distributed under the MIT License.
See the LICENSE
 file for details.
