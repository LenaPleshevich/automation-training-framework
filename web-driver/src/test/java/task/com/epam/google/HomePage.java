package task.com.epam.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import task.com.epam.BasePage;

public class HomePage extends BasePage {
    @FindBy(xpath = "//*[@track-name='exploreProducts']")
    private WebElement buttonExploreAllProducts;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ProductPage goToPageProducts() {
        initWait(buttonExploreAllProducts);
        buttonExploreAllProducts.click();
        return new ProductPage(driver);
    }
}
