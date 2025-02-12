package pages.complicatedPage;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class ComplicatedPageComponent {

     final Locator firstButton;

    public ComplicatedPageComponent(Page page) {
        this.firstButton = page.locator("//a[@class='et_pb_button et_pb_button_0 et_pb_bg_layout_light']");
    }
}
