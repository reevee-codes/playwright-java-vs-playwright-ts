package pages;

import com.microsoft.playwright.Page;
import constants.Timeouts;

public abstract class BasePage {
    protected final Page page;

    public BasePage(Page page) {
        this.page = page;
        page.setDefaultTimeout(Timeouts.DEFAULT_TIMEOUT);
    }

    protected void waitForPageLoad() {
        page.waitForLoadState();
    }
} 