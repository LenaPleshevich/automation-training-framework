package task.com.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {
    private final String PAGE_URL = "https://cloud.google.com/ ";
    @FindBy(xpath = "//*[@track-name='seeProducts']")
    private WebElement buttonExploreAllProducts;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public HomePage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public ProductPage goToPageProducts() {
        initWait(buttonExploreAllProducts);
        buttonExploreAllProducts.click();
        return new ProductPage(driver);
    }
}
