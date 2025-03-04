# Playwright TypeScript UI Testing Framework

A modern UI testing framework built with Playwright and TypeScript, implementing the Page Object Model with a three-layer architecture.

## 🎯 Key Features

- ✅ Three-layer Page Object Model (Components/Functions/State)
- ✅ Strong TypeScript typing
- ✅ Parallel test execution
- ✅ Automatic screenshot capture on failure
- ✅ Environment-based configuration
- ✅ HTML and JSON reporting

## 🏗 Architecture

### Three-Layer Approach

1. **Component Layer** (`src/components/`)
   - Element locators
   - Basic element interactions
   - Example: `ComplicatedPageComponent.ts`

2. **Functions Layer** (`src/functions/`)
   - Business-level actions
   - Complex interactions
   - Example: `ComplicatedPageFunctions.ts`

3. **State Layer** (`src/state/`)
   - Test assertions
   - State verification
   - Example: `ComplicatedPageState.ts`

### Core Components

- `BasePage` - Base class with common page interactions
- `TestContext` - Singleton for managing test state
- `Configuration` - Environment configuration management

## 🚀 Getting Started

### Prerequisites

- Node.js 14 or higher
- npm/yarn
- Git

### Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd playwright-typescript
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Set up environment:
   ```bash
   # Copy environment template
   cp .env.template .env
   
   # Edit .env with your settings
   ```

### Running Tests

```bash
# Run all tests
npm test

# Run in headed mode (browser visible)
npm run test:headed

# Run with UI mode
npm run test:ui

# Run specific test file
npx playwright test tests/complicated-page.spec.ts
```

## 📁 Project Structure

```
playwright-typescript/
├── src/
│   ├── components/    # Element locators & basic interactions
│   │   └── ComplicatedPageComponent.ts
│   ├── functions/     # Business logic & complex actions
│   │   └── ComplicatedPageFunctions.ts
│   ├── state/        # Assertions & state verification
│   │   └── ComplicatedPageState.ts
│   ├── core/         # Framework core
│   │   ├── BasePage.ts
│   │   └── TestContext.ts
│   └── config/       # Configuration management
│       └── Configuration.ts
├── tests/            # Test specifications
│   └── complicated-page.spec.ts
├── playwright.config.ts
└── package.json
```

## ⚙️ Configuration

Configuration can be managed through:
1. `.env` file (recommended for local development)
2. Environment variables
3. Command line parameters

Example `.env`:
```env
BASE_URL=https://ultimateqa.com/complicated-page
BROWSER=chromium
HEADLESS=true
DEFAULT_TIMEOUT=30000
```

## 🔍 Test Examples

### Button Visibility Test
```typescript
test('verify button is visible on complicated page', async () => {
  await complicatedPageState.assertButtonIsVisible();
});
```

### Button Color Change Test
```typescript
test('verify button changes color on hover', async () => {
  await complicatedPageState.assertButtonChangesColorOnHover();
});
```

## 📝 Development Guidelines

1. **Adding New Tests**
   - Create component class for element interactions
   - Create functions class for business logic
   - Create state class for assertions
   - Add test file in `tests/` directory

2. **Code Style**
   - Use TypeScript types
   - Follow existing patterns
   - Add JSDoc comments for functions

3. **Best Practices**
   - Keep components focused and small
   - Use meaningful names
   - Write self-documenting code
   - Add appropriate error handling

## 🐛 Debugging

1. Run in headed mode:
   ```bash
   npm run test:headed
   ```

2. Use UI mode for interactive debugging:
   ```bash
   npm run test:ui
   ```

3. Check generated reports in:
   - `playwright-report/` - HTML reports
   - `test-results/` - Test artifacts

## 🤝 Contributing

1. Create feature branch
2. Make changes
3. Add/update tests
4. Update documentation
5. Submit pull request

## 📄 License

This project is licensed under the MIT License. 