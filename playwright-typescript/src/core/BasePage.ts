import { Page } from '@playwright/test';

export abstract class BasePage {
  constructor(protected page: Page) {}

  /**
   * Navigate to a specific URL
   * @param url - The URL to navigate to
   */
  async navigate(url: string): Promise<void> {
    await this.page.goto(url);
  }

  /**
   * Wait for element to be visible
   * @param selector - The selector to wait for
   */
  async waitForElement(selector: string): Promise<void> {
    await this.page.waitForSelector(selector, { state: 'visible' });
  }

  /**
   * Get text content of an element
   * @param selector - The selector to get text from
   */
  async getText(selector: string): Promise<string | null> {
    return await this.page.textContent(selector);
  }

  /**
   * Click on an element
   * @param selector - The selector to click
   */
  async click(selector: string): Promise<void> {
    await this.page.click(selector);
  }

  /**
   * Fill an input field
   * @param selector - The selector of the input field
   * @param value - The value to fill
   */
  async fill(selector: string, value: string): Promise<void> {
    await this.page.fill(selector, value);
  }

  /**
   * Check if element is visible
   * @param selector - The selector to check
   */
  async isVisible(selector: string): Promise<boolean> {
    const element = await this.page.$(selector);
    return element !== null && await element.isVisible();
  }

  /**
   * Take a screenshot
   * @param name - Name of the screenshot
   */
  async takeScreenshot(name: string): Promise<void> {
    await this.page.screenshot({ path: `./screenshots/${name}.png` });
  }
} 