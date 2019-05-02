package com.epam.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractPage {
    private final String PAGE_URL = "https://cloud.google.com/products/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@track-name='seePricing']")
    private WebElement buttonSeePrising;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    protected ProductPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Product page opened");
        return this;
    }

    public PricingPage goToPagePrising() {
        waitUntilElementClickable(buttonSeePrising);
        buttonSeePrising.click();
        logger.info("Pricing page opened");
        return new PricingPage(driver);
    }
}
