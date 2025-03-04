import { Browser, BrowserContext, Page } from '@playwright/test';

export class TestContext {
  private static instance: TestContext;
  private context: { [key: string]: any } = {};
  private browser?: Browser;
  private browserContext?: BrowserContext;
  private page?: Page;

  private constructor() {}

  public static getInstance(): TestContext {
    if (!TestContext.instance) {
      TestContext.instance = new TestContext();
    }
    return TestContext.instance;
  }

  // Browser management
  setBrowser(browser: Browser): void {
    this.browser = browser;
  }

  getBrowser(): Browser | undefined {
    return this.browser;
  }

  // Browser context management
  setBrowserContext(context: BrowserContext): void {
    this.browserContext = context;
  }

  getBrowserContext(): BrowserContext | undefined {
    return this.browserContext;
  }

  // Page management
  setPage(page: Page): void {
    this.page = page;
  }

  getPage(): Page | undefined {
    return this.page;
  }

  // State management
  set(key: string, value: any): void {
    this.context[key] = value;
  }

  get(key: string): any {
    return this.context[key];
  }

  // Clear context
  clear(): void {
    this.context = {};
  }

  // Clear all
  async clearAll(): Promise<void> {
    this.context = {};
    if (this.page) {
      await this.page.close();
      this.page = undefined;
    }
    if (this.browserContext) {
      await this.browserContext.close();
      this.browserContext = undefined;
    }
    if (this.browser) {
      await this.browser.close();
      this.browser = undefined;
    }
  }
} 