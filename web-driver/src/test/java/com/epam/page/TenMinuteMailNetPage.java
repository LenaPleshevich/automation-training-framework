package com.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinuteMailNetPage extends AbstractPage{
    private final String PAGE_URL = "https://10minutemail.net";
    @FindBy(xpath = "//*[@id='fe_text']")
    private WebElement generateMail;
    @FindBy(xpath = "//*[a='Google Cloud Platform Price Estimate']")
    private WebElement emailDropDown;
    @FindBy(xpath = "//td[2]//h3")
    private WebElement totalCost;
    private static final String generateMailAttribute = "value";

    public TenMinuteMailNetPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public AbstractPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public String getGenerateMail() {
        return generateMail.getAttribute(generateMailAttribute);
    }

    public TenMinuteMailNetPage openEmail() {
        new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(emailDropDown));
        emailDropDown.click();
        return this;
    }

    public WebElement getTotalCost(){
        new WebDriverWait(driver,40).until(ExpectedConditions.visibilityOf(totalCost));
        return totalCost;
    }
}
