import { Page } from '@playwright/test';
import { ComplicatedPageComponent } from '../components/ComplicatedPageComponent';
import { TestContext } from '../core/TestContext';

export class ComplicatedPageFunctions {
  private complicatedPageComponent: ComplicatedPageComponent;
  private context: TestContext;
  private page: Page;

  constructor(page: Page) {
    this.page = page;
    this.complicatedPageComponent = new ComplicatedPageComponent(page);
    this.context = TestContext.getInstance();
  }

  async checkButtonVisibility(): Promise<boolean> {
    const isVisible = await this.complicatedPageComponent.isButtonVisible();
    this.context.set('isButtonVisible', isVisible);
    return isVisible;
  }

  async checkButtonColorChange(): Promise<boolean> {
    const initialColor = await this.complicatedPageComponent.getButtonColor();
    await this.complicatedPageComponent.hoverOverButton();
    await this.page.waitForTimeout(500);
    const newColor = await this.complicatedPageComponent.getButtonColor();
    
    const hasColorChanged = initialColor !== newColor;
    this.context.set('buttonColorChanged', hasColorChanged);
    return hasColorChanged;
  }
} 