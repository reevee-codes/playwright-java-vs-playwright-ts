import dotenv from 'dotenv';

export class Configuration {
  private static instance: Configuration;
  private config: { [key: string]: string } = {};

  private constructor() {
    // Load environment variables
    dotenv.config();

    // Set default configuration
    this.config = {
      baseUrl: process.env.BASE_URL || 'http://localhost:3000',
      browser: process.env.BROWSER || 'chromium',
      headless: process.env.HEADLESS || 'true',
      defaultTimeout: process.env.DEFAULT_TIMEOUT || '30000',
      viewport: process.env.VIEWPORT || '1280x720',
      slowMo: process.env.SLOW_MO || '0',
      traceDir: process.env.TRACE_DIR || './traces',
      screenshotDir: process.env.SCREENSHOT_DIR || './screenshots',
      videoDir: process.env.VIDEO_DIR || './videos',
      reportDir: process.env.REPORT_DIR || './reports',
      environment: process.env.ENV || 'development'
    };
  }

  public static getInstance(): Configuration {
    if (!Configuration.instance) {
      Configuration.instance = new Configuration();
    }
    return Configuration.instance;
  }

  get(key: string): string {
    return this.config[key];
  }

  set(key: string, value: string): void {
    this.config[key] = value;
  }

  getViewportWidth(): number {
    return parseInt(this.config.viewport.split('x')[0]);
  }

  getViewportHeight(): number {
    return parseInt(this.config.viewport.split('x')[1]);
  }

  isHeadless(): boolean {
    return this.config.headless.toLowerCase() === 'true';
  }

  getDefaultTimeout(): number {
    return parseInt(this.config.defaultTimeout);
  }

  getSlowMo(): number {
    return parseInt(this.config.slowMo);
  }
} 