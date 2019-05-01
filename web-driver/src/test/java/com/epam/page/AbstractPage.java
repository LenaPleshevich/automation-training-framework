package com.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected final int WAIT_TIMEOUT_SECONDS = 20;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    protected abstract AbstractPage openPage();

    protected void waitUntilElementClickable(WebElement webElement){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
