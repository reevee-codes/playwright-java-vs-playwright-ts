import { Page } from '@playwright/test';
import { BasePage } from '../core/BasePage';

export class ComplicatedPageComponent extends BasePage {
  // Locators for Complicated Page elements
  private readonly firstButton = "//a[@class='et_pb_button et_pb_button_0 et_pb_bg_layout_light']";

  constructor(page: Page) {
    super(page);
  }

  async isButtonVisible(): Promise<boolean> {
    return await this.isVisible(this.firstButton);
  }

  async hoverOverButton(): Promise<void> {
    await this.page.hover(this.firstButton);
  }

  async getButtonColor(): Promise<string> {
    const button = await this.page.locator(this.firstButton);
    return await button.evaluate((el) => window.getComputedStyle(el).color);
  }
} 