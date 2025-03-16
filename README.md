# Playwright Test Automation Framework

A modern, robust test automation framework built with Playwright, Cucumber, and Java, following best practices and design patterns. Work in progress!

## 🏗 Architecture

### Design Patterns

1. **Page Object Model (POM)** - Enhanced with a three-layer approach:
    - `Component` - Contains element locators and basic element interactions
    - `Functions` - Contains business-level actions
    - `State` - Contains state verification and assertions

2. **Singleton Pattern**
    - Used in Configuration management
    - Ensures single instance of test context per thread.

3. **Factory Pattern**
    - Browser and page initialization
    - Configuration management

4. **Dependency Injection**
    - Using PicoContainer for Cucumber
    - Automatic dependency management
    - Improved test maintenance and readability

### Key Components

- `BasePage` - Abstract base class for all page objects
- `TestContext` - Thread-safe context management
- `Configuration` - Centralized configuration management
- `Hooks` - Test lifecycle management

## 🎯 Features

- ✅ Thread-safe execution
- ✅ Parallel test execution support
- ✅ Scenario context storage
- ✅ Automatic screenshot capture on failure
- ✅ Configurable timeouts
- ✅ Environment-specific configuration
- ✅ HTML, JSON, and XML reporting
- ✅ Custom exception handling

## 🔧 Technical Stack

- Java
- Playwright
- Cucumber (BDD)
- JUnit
- PicoContainer (Dependency Injection)
- Maven

## 💡 Design Benefits

1. **Maintainability**
    - Clear separation of concerns
    - Reusable components
    - Centralized configuration
    - Easy to extend and modify

2. **Reliability**
    - Thread-safe execution
    - Robust error handling
    - Consistent timeout management
    - Automatic cleanup of resources

3. **Scalability**
    - Support for parallel execution
    - Easy to add new features
    - Modular architecture
    - Environment-agnostic design

4. **Readability**
    - BDD-style test scenarios
    - Clear page object structure
    - Self-documenting code
    - Consistent naming conventions

## 🚀 Getting Started

1. **Prerequisites**
   ```bash
   - Java 11 or higher
   - Maven
   ```

2. **Running Tests**
   ```bash
   # Run all tests
   mvn clean test

   # Run with specific tags
   mvn test -Dcucumber.filter.tags="@smoke"

   # Run with specific environment
   mvn test -DbaseUrl=https://staging.ultimateqa.com
   ```

## 🔍 Test Reports

Reports are generated in `target/cucumber-reports/` directory:
- HTML Report: `cucumber.html`
- JSON Report: `cucumber.json`
- XML Report: `cucumber.xml`

## 🛠 Configuration

Environment variables can be set through:
- System properties
- Configuration class
- Maven command line parameters

Example:
```bash
mvn test -DbaseUrl=https://staging.ultimateqa.com -Dbrowser=firefox -Dheadless=true
```
## 🤝 Best Practices

1. **Page Objects**
    - Keep locators in Component classes
    - Business logic in Functions classes
    - State verification in State classes

2. **Test Data**
    - Use TestContext for sharing data between steps
    - Clear context after each scenario
    - Use thread-safe storage methods

3. **Error Handling**
    - Custom exceptions for better error reporting
    - Automatic screenshot capture on failure
    - Proper cleanup in teardown

4. **Configuration**
    - Environment-specific settings
    - Centralized configuration management
    - Easy to override defaults

## 📝 Contributing

1. Follow the existing design patterns
2. Add appropriate unit tests
3. Update documentation
4. Follow code style guidelines

## �� Running Tests

Now you can run the tests in several ways:

1. Run all tests in headless mode:
```bash
npm test
```

2. Run tests in headed mode (browser visible):
```bash
npm run test:headed
```

3. Run tests with Playwright UI mode (interactive):
```bash
npm run test:ui
```

4. Run tests in debug mode:
```bash
npm run test:debug
```

Let's try running the tests in headed mode so you can see what's happening:
