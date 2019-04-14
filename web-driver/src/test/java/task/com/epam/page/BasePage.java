package task.com.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import task.com.epam.driver.DriverSingleton;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebElement webDriverWait;
    private static final int SIZE_WAIT = 20;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void initWait(WebElement webElement){
        webDriverWait = new WebDriverWait(driver,SIZE_WAIT).until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
