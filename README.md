## Freelance Invoice Manager V2
A lightweight Java-based invoice management system tailored for freelancers. This is the second version of my microproject — rebuilt using Hibernate JPA for better data handling, maintainability, and cleaner code architecture.

## ✨ Tech Stack
Java (JDK 17+)

Hibernate JPA (ORM)

PostgreSQL

Maven (Dependency Management)

## 📁 Project Structure
com.freelance.model – Entity classes for Client, Invoice, Service

com.freelance.repository – Interfaces for database operations

com.freelance.service – Core logic like adding clients or generating invoices

com.freelance.main – Contains App.java, the entry point of the project

## ⚙️ How to Run
Make sure PostgreSQL is running and a database is created (as configured in persistence.xml)

Clone this repository:

git clone https://github.com/Krishna-Rohra/Freelance-Invoice-Manager-V2.git

Open in an IDE like VS Code or IntelliJ

Run the main file:
com.freelance.main.App.java

Hibernate will auto-generate the necessary tables in your PostgreSQL DB on first run.

## 🧩 Features
Add clients with contact and billing details

Add services rendered with descriptions and amounts

Generate invoices and view summary in console

Uses JPA for easy CRUD and table mapping
