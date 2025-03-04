import { Page, expect } from '@playwright/test';
import { ComplicatedPageFunctions } from '../functions/ComplicatedPageFunctions';
import { TestContext } from '../core/TestContext';

export class ComplicatedPageState {
  private complicatedPageFunctions: ComplicatedPageFunctions;
  private context: TestContext;

  constructor(page: Page) {
    this.complicatedPageFunctions = new ComplicatedPageFunctions(page);
    this.context = TestContext.getInstance();
  }

  async assertButtonIsVisible(): Promise<void> {
    const isVisible = await this.complicatedPageFunctions.checkButtonVisibility();
    expect(isVisible, 'Button should be visible on the page').toBeTruthy();
  }

  async assertButtonChangesColorOnHover(): Promise<void> {
    const colorChanged = await this.complicatedPageFunctions.checkButtonColorChange();
    expect(colorChanged, 'Button color should change on hover').toBeTruthy();
  }
} 