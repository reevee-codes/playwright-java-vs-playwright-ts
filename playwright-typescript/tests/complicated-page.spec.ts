import { test } from '@playwright/test';
import { ComplicatedPageFunctions } from '../src/functions/ComplicatedPageFunctions';
import { ComplicatedPageState } from '../src/state/ComplicatedPageState';
import { TestContext } from '../src/core/TestContext';
import { Configuration } from '../src/config/Configuration';

test.describe('Complicated Page Tests', () => {
  let complicatedPageFunctions: ComplicatedPageFunctions;
  let complicatedPageState: ComplicatedPageState;
  let context: TestContext;
  let config: Configuration;

  test.beforeEach(async ({ page }) => {
    // Initialize components
    complicatedPageFunctions = new ComplicatedPageFunctions(page);
    complicatedPageState = new ComplicatedPageState(page);
    context = TestContext.getInstance();
    config = Configuration.getInstance();

    // Navigate to complicated page
    await page.goto('https://ultimateqa.com/complicated-page');
  });

  test.afterEach(async () => {
    // Clear test context
    context.clear();
  });

  test('verify button is visible on complicated page', async () => {
    await complicatedPageState.assertButtonIsVisible();
  });

  test('verify button changes color on hover', async () => {
    await complicatedPageState.assertButtonChangesColorOnHover();
  });
}); 