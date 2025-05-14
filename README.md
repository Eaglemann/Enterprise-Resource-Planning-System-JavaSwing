# Enterprise-Resource-Planning-System-JavaSwing

### This is a management panel application (ERP) built with Java Swing and Oracle Database.

**Note: To put this application into work, first you need to set up the Oracle Database in your local system or in cloud services.**

This application consists of 6 views, and each view has its own interaction with the database, including CRUD operations.

## Project Overview

This Enterprise Resource Planning (ERP) system is a desktop application developed using Java Swing for the user interface and Oracle Database for data persistence. It aims to provide a comprehensive solution for managing various aspects of a business, including:

*   **Inventory Management:** Track and manage inventory levels, stock movements, and product information.
*   **Sales Management:** Record sales transactions, generate invoices, and manage customer data.
*   **Purchasing Management:** Create purchase orders, track supplier information, and manage incoming shipments.
*   **Employee Management:** Maintain employee records, track attendance, and manage payroll information.
*   **Financial Management:** Manage financial transactions, generate reports, and track key performance indicators.
*   **Reporting:** Generate custom reports based on available data.

The application is designed to be modular and extensible, allowing for future expansion and customization.

## Installation Instructions

To set up the ERP application, follow these steps:

1.  **Oracle Database Setup:**

    *   **Local Installation:**
        > a. Download and install Oracle Database from the [Oracle website](https://www.oracle.com/database/technologies/databaseappdev-vm.html). Choose the appropriate version for your operating system.
        >
        > b. Follow the installation instructions provided by Oracle. Note the System Identifier (SID), username, and password you set during installation.
        >
        > c. Ensure that the Oracle Database instance is running.
    *   **Cloud Installation (e.g., Oracle Cloud):**
        > a. Sign up for an Oracle Cloud account or use an existing one.
        >
        > b. Create an Oracle Database instance in the cloud. Choose the appropriate configuration based on your needs.
        >
        > c. Note the connection details for your cloud database, including the hostname, port, SID, username, and password.
    *   **Database Configuration:**
        > a.  Create the necessary tables and schema in your Oracle database. Sample DDL scripts can be found in the `db` directory of this repository (if available), or you will need to create them manually based on the application's data model.  Example table creation statement:
        bash
        git clone <repository_url>
        cd Enterprise-Resource-Planning-System-JavaSwing
        ## Usage Guide

The application consists of six views, each supporting CRUD (Create, Read, Update, Delete) operations:

1.  **Inventory View:**

    *   **Create:** Add a new item to the inventory. Enter the item name, description, quantity, and price.
        > Example: Add "Laptop" with description "High-performance laptop", quantity 10, and price $1200.
    *   **Read:** View the list of all inventory items.
    *   **Update:** Modify the details of an existing inventory item.
        > Example: Update the quantity of "Laptop" to 15.
    *   **Delete:** Remove an item from the inventory.

2.  **Sales View:**

    *   **Create:** Record a new sale. Enter the customer name, items sold, and total amount.
        > Example: Record a sale to "John Doe" for "Laptop" (quantity 1) at $1200.
    *   **Read:** View the list of all sales transactions.
    *   **Update:** Modify the details of an existing sale.
    *   **Delete:** Remove a sale transaction.

3.  **Purchasing View:**

    *   **Create:** Create a new purchase order. Enter the supplier name, items ordered, and total amount.
        > Example: Create a purchase order to "Supplier A" for "Laptop" (quantity 5) at $1000 each.
    *   **Read:** View the list of all purchase orders.
    *   **Update:** Modify the details of an existing purchase order.
    *   **Delete:** Remove a purchase order.

4.  **Employee View:**

    *   **Create:** Add a new employee. Enter the employee name, contact information, and job title.
        > Example: Add "Jane Smith" with contact information "jane.smith@example.com" and job title "Sales Manager".
    *   **Read:** View the list of all employees.
    *   **Update:** Modify the details of an existing employee.
    *   **Delete:** Remove an employee.

5.  **Financial View:**

    *   **Create:** Record a new financial transaction. Enter the transaction type, amount, and date.
        > Example: Record a "Revenue" transaction of $5000 on "2023-10-27".
    *   **Read:** View the list of all financial transactions.
    *   **Update:** Modify the details of an existing transaction.
    *   **Delete:** Remove a transaction.

6.  **Reporting View:**

    *   This view allows you to generate custom reports based on the data in the database.
    >  The specific features available depend on the current implementation.  Typically, you can filter data by date range, employee, product, etc. and generate reports in various formats (e.g., PDF, CSV).

> **Note:** Consider adding screenshots of each view to visually guide the user.

## Dependencies List

The following libraries and dependencies are required to run the application:

*   Java Swing (included with Java SE)
*   Oracle JDBC Driver: `ojdbc8.jar` (or a compatible version)
    >  Download the appropriate JDBC driver for your Oracle Database version from the [Oracle website](https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html).  Place the JAR file in your project's classpath.
*   Maven or Gradle (for dependency management)
*   Any other libraries used for specific functionalities (e.g., reporting, charting).  List these here.

## Contribution Guidelines

We welcome contributions to the ERP system! To contribute, please follow these guidelines:

1.  **Coding Standards:**

    *   Follow the Java coding conventions.
    *   Write clear and concise code with meaningful comments.
    *   Use consistent formatting and indentation.

2.  **Testing Procedures:**

    *   Write unit tests for your code.
    *   Test your changes thoroughly before submitting a pull request.
    *   Ensure that your changes do not break existing functionality.

3.  **Pull Request Submission:**

    *   Fork the repository and create a new branch for your changes.
    *   Submit a pull request with a clear description of your changes.
    *   Address any feedback from the maintainers.

## License Information

This application is released under the MIT License. See the `LICENSE` file for details.

## Troubleshooting Section

*   **Database Connection Errors:**
    > Ensure that the database is running and that the connection details in the configuration file are correct.  Check the hostname, port, SID, username, and password. Also, ensure that the Oracle JDBC driver is correctly added to the project's classpath.
*   **Missing Dependencies:**
    > If you encounter `ClassNotFoundException` or similar errors, ensure that all required dependencies are resolved and available in the project's classpath.
*   **UI Issues:**
    > If you encounter UI rendering issues, ensure that you are using a compatible Java Runtime Environment (JRE).

## Contact Information

For questions, bug reports, or feature requests, please contact:

> Denis Tola - denis.tola22@gmail.com
