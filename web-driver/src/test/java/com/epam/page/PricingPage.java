package com.epam.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricingPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://cloud.google.com/products/";

    @FindBy(xpath = "//a[text()='Calculators']")
    private WebElement calculator;

    public PricingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    protected PricingPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Pricing page opened");
        return this;
    }

    public CalculatorPage goToPageCalculators() {
        waitUntilElementClickable(calculator);
        calculator.click();
        return new CalculatorPage(driver);
    }
}
