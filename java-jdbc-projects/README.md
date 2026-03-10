# Restaurant CRUD Application (Java JDBC)

A console-based Java application that performs CRUD operations on a Restaurant database using JDBC and MySQL.

## Features

- Insert restaurant data
- Fetch all restaurant records
- Fetch restaurant by ID
- Update restaurant information
- Delete restaurant data

## Technologies Used

- Java
- JDBC
- MySQL
- DAO Design Pattern

## Project Structure

controller → Handles user interaction  
dao → Database operations  
entity → Java object representing database table  
util → Database connection utility

## Example Menu

1. Insert Data
2. Fetch All Data
3. Fetch Data by ID
4. Update Data
5. Delete Data
6. Exit

## Database Table Example

```sql
CREATE TABLE restaurant (
    id BIGINT PRIMARY KEY,
    name VARCHAR(50),
    location VARCHAR(50),
    fooditems VARCHAR(100),
    rating VARCHAR(10),
    description VARCHAR(200)
);
```

## How to Run

Compile the project

```
javac jdbc/**/*.java
```

Run the controller

```
java jdbc.controller.RestorentController
```
