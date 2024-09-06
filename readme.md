# Ecommerce Automation Testing

This project is a test automation suite for an ecommerce website. It uses Selenium WebDriver with Java for browser automation, JUnit for assertions, and Maven for project management.

## Project Structure

The project follows the Page Object Model (POM) design pattern and is structured as follows:

- `src/main/java/org/example/pages`: Contains page classes for each page of the ecommerce website. Each page class encapsulates the web elements and actions that can be performed on a specific page.

- `src/main/java/org/example/test`: Contains the test runner class that executes the test scenarios.

- `src/main/java/org/example/utilities`: Contains utility classes for WebDriver management and explicit waits.

## Running the Tests

To run the tests, navigate to the project directory and execute the following command:

```bash
mvn clean test
```

## Test Scenarios

The `TestRunner` class in the `src/main/java/org/example/test` directory contains the following test scenarios:

- `testEcommerceFlow`: Tests the end-to-end ecommerce flow, including login, adding items to the cart, and proceeding to checkout.

## Dependencies

- Selenium WebDriver: For browser automation.
- JUnit: For assertions in tests.
- Maven: For project management.