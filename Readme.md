# Selenium Automation Project

This project is designed to automate UI tests for an e-commerce application using Selenium.  The project structure follows a Page Object Model (POM) design pattern for maintainability and scalability.

## Project Structure

The project is structured as follows:

* **`config`**: Contains configuration related classes, such as `ConfigLoader` for loading properties from configuration files.
* **`pages`**: Houses the Page Object classes representing different web pages in the application, like `ProductPage` and `CartPage`. These classes encapsulate the web elements and actions related to each page.
* **`stepDefinitions`**: Contains the step definition classes implementing the test scenarios defined in feature files, such as `ProductStepDefinitions` and `LoginStepDefinitions`.
* **`utils`**: Contains utility classes like `TestContext` providing helper methods and managing the WebDriver instance.

## Functionality

The implemented test scenarios cover user interactions with the product and cart pages of the e-commerce application, including:

* Adding products to the cart.
* Verifying the cart contents.
* Checking page navigation and URIs.
* Login functionality.

## Technologies Used

* **Selenium WebDriver**: For browser automation.
* **TestNG**: For test execution and assertions.
* **Cucumber**: For defining test scenarios in a human-readable format.
* **Java**: Programming language used for the project.
* **Maven**: For dependency management.
* **Extent-Reports**: reporting mechanism to generate detailed test reports.
* **log4j2**: For adding logs to file and console.

## Configuration

The project's configuration is managed through property files located in the `src/test/resources/configurations` directory.  The `ConfigLoader` class handles loading and accessing these properties.

## Page Object Model (POM)

The project utilizes the POM design pattern, where each web page is represented by a corresponding Page Object class.  This enhances code maintainability and reduces code duplication.

## Running the Tests

Instructions on how to run the tests (e.g., Maven commands, IDE integration) would be added here once further details about the project setup are provided.

## Future Enhancements

* **Expand Test Coverage**: Include more test scenarios to cover other functionalities of the application, such as checkout process, user registration, etc.
* **Data-Driven Testing**: Implement data-driven tests to execute the same scenarios with different input data sets.
* **Cross-Browser Testing**: Configure the project to run tests across different browsers for better compatibility testing.
* **Reporting**: Integrate a reporting mechanism to generate detailed test reports.



## Contributing

Guidelines for contributing to the project would be added here as needed.

