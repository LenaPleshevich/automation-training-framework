package task.com.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
