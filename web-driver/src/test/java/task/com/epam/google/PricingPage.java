package task.com.epam.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import task.com.epam.BasePage;

public class PricingPage extends BasePage {
    @FindBy(xpath = "//a[text()='Calculators']")
    private WebElement calculator;

    public PricingPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage goToPageCalculators() {
        initWait(calculator);
        calculator.click();
        return new CalculatorPage(driver);
    }
}
