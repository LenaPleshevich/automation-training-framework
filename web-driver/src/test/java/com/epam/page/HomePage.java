package com.epam.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {
    private final String PAGE_URL = "https://cloud.google.com/ ";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@track-name='seeProducts']")
    private WebElement buttonExploreAllProducts;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public HomePage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Home page opened");
        return this;
    }

    public ProductPage goToPageProducts() {
        waitUntilElementClickable(buttonExploreAllProducts);
        buttonExploreAllProducts.click();
        logger.info("Product page opened");
        return new ProductPage(driver);
    }
}
