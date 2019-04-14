package task.com.epam.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import task.com.epam.BasePage;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//*[@track-name='seePricing']")
    private WebElement buttonSeePrising;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public PricingPage goToPagePrising() {
        initWait(buttonSeePrising);
        buttonSeePrising.click();
        return new PricingPage(driver);
    }
}
