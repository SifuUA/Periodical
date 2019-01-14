# Periodical

## Final project

#### Task

```
Create the system of the Periodical. 
The administrator maintains a catalogue of periodicals. 
The reader can Subscribe by selecting periodicals from the list. 
The system calculates the amount to be paid and registers the Payment.
```

#### General requirements 
```
    You must build a web application that supports the following functionality:
    1. On the basis of domain entities to create classes describing them.
    2. Classes and methods should have names reflecting their functionality and should be correctly structured by packages.
    3. To store domain information in the database, use the JDBC API for access using a connection pool, standard or          developed independently.
    4. The application must support the work with Cyrillic (be multilingual), including the storage of information in the   database.
    5. The code must be documented.
    6. The application must be covered by Unit tests
    7. When developing business logic, use sessions and filters, and process events in the system using Log4j.
    8. The application needs to implement Pagination, Transaction depending on Your project.
    9. Using servlets and JSP, implement the functionality proposed in the formulation of a specific task.
    10 . In JSP pages, use the JSTL library
    11 . The application must correctly respond to errors and exceptions of various kinds (the User should never see stack-trace on the front-end side).
    12 . The application must be implemented Authorization and Authentication system
 ```

## Steps to Setup

**1. Clone the repository** 

```bash
git clone https://github.com/SifuUA/Periodical.git
```

**2. Run the app using maven**

```bash
cd periodical
mvn clean compile tomkat7:run
```

The application can be accessed at `http://localhost:8888/servlet/home`.

**3. See the database configuration** `/src/main/resources/db_config.properties`

**4. You mast have installed MySQL Server and MySQL Workbench, than you can using MySQL Workbench run** `database.sql`
**for creating database, tables and some data**


    
