package com.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinuteMailPage extends AbstractPage {
    private final String PAGE_URL = "https://10minutemail.com";
    protected final int WAIT_TIMEOUT_SECONDS = 40;
    private static final String generateMailValueAttribute = "value";

    @FindBy(xpath = "//*[@class='mail-address-address']")
    private WebElement generateMail;

    @FindBy(id = "ui-id-1")
    private WebElement emailDropDown;

    @FindBy(xpath = "//td[2]//h3")
    private WebElement totalCost;

    public TenMinuteMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public TenMinuteMailPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public String getGenerateMail() {
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.attributeToBeNotEmpty(generateMail,generateMailValueAttribute));
        return generateMail.getAttribute(generateMailValueAttribute);
    }

    public TenMinuteMailPage openEmail() {
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(emailDropDown));
        emailDropDown.click();
        return this;
    }

    public WebElement getTotalCost(){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(totalCost));
        return totalCost;
    }
}
