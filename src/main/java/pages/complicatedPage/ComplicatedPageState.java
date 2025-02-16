package pages.complicatedPage;

import com.microsoft.playwright.Page;
import pages.BasePage;

public class ComplicatedPageState extends BasePage {
    private final ComplicatedPageComponent complicatedPageComponent;

    public ComplicatedPageState(Page page) {
        super(page);
        this.complicatedPageComponent = new ComplicatedPageComponent(page);
    }

    public String getColorOfFirstButton() {
        String color = complicatedPageComponent.firstButton.getAttribute("color");
        return color != null ? color : "No color attribute found";
    }
}
