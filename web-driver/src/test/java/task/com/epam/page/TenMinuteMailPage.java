package task.com.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinuteMailPage extends BasePage {
    @FindBy(xpath = "//*[@class='mail-address-address']")
    private WebElement generateMail;
    @FindBy(id = "ui-id-1")
    private WebElement emailDropDown;
    @FindBy(xpath = "//td[2]//h3")
    private WebElement totalCost;
    private static final String generateMailAttribute = "value";

    public TenMinuteMailPage(WebDriver driver) {
        super(driver);
    }

    public String getGenerateMail() {
        return generateMail.getAttribute(generateMailAttribute);
    }

    public TenMinuteMailPage openEmail() {
        new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(emailDropDown));
        emailDropDown.click();
        return this;
    }

    public WebElement getTotalCost(){
        new WebDriverWait(driver,40).until(ExpectedConditions.visibilityOf(totalCost));
        return totalCost;
    }
}
