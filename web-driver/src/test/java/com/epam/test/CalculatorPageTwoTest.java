package com.epam.test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.model.Email;
import com.epam.page.TenMinuteMailNetPage;

import java.util.ArrayList;

public class CalculatorPageTwoTest extends CommonConditions{
    @Test
    public void checkTotalCostInEmailTest(){
        ((JavascriptExecutor)driver).executeScript("window.open('https://10minutemail.net','_blank');");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        tenMinuteMailNetPage = new TenMinuteMailNetPage(driver);
        driver.switchTo().window(tabs.get(1));
        email = new Email(tenMinuteMailNetPage.getGenerateMail());
        driver.switchTo().window(tabs.get(0));
        calculatorPage.switchToFrame();
        calculatorPage.inputEmail(email.getEmail()).sendEmail();
        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(1));
        driver.switchTo().defaultContent();
        tenMinuteMailNetPage.openEmail();
        String resultTotalCostFromEmail = tenMinuteMailNetPage.getTotalCost().getText();
        Assert.assertTrue(resultWithTotalCost.contains(resultTotalCostFromEmail),"Expected total cost on page does not match total cost from email");
    }
}
