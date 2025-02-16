package tests.context;

import com.microsoft.playwright.*;
import config.Configuration;

import java.util.concurrent.ConcurrentHashMap;

public class TestContext {
    private  Playwright playwright;
    private  Browser browser;
    private  BrowserContext browserContext;
    private  Page page;

    private static final ThreadLocal<ConcurrentHashMap<String, Object>> SCENARIO_CONTEXT = 
        ThreadLocal.withInitial(ConcurrentHashMap::new);

    public TestContext() {
        initializePlaywright();
    }

    private void initializePlaywright() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions()
                .setHeadless(Configuration.isHeadless())
        );
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    public Page getPage() {
        return page;
    }

    public void storeData(String key, Object value) {
        SCENARIO_CONTEXT.get().put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T getData(String key) {
        return (T) SCENARIO_CONTEXT.get().get(key);
    }

    public void clearScenarioContext() {
        SCENARIO_CONTEXT.get().clear();
    }

    public void tearDown() {
        if (page != null) page.close();
        if (browserContext != null) browserContext.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
        clearScenarioContext();
    }
} 