package com.epam.test;

import com.epam.model.Email;
import com.epam.page.TenMinuteMailPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CalculatorPageTest extends CommonConditions{
   private final String SCRIPT_TO_OPEN_TAB_10MINUTEMAILCOM = "window.open('https://10minutemail.com','_blank');";

   @Test
    public void checkTotalCostInEmailTest(){
       ((JavascriptExecutor)driver).executeScript(SCRIPT_TO_OPEN_TAB_10MINUTEMAILCOM);
       ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
       tenMinuteMailPage = new TenMinuteMailPage(driver);
       driver.switchTo().window(tabs.get(1));
       email = new Email(tenMinuteMailPage.getGenerateMail());
       driver.switchTo().window(tabs.get(0));
       calculatorPage.switchToInnerHtmlDocument();
       calculatorPage.inputEmail(email.getEmail()).sendEmail();
       driver.switchTo().window(tabs.get(1));
       driver.switchTo().defaultContent();
       tenMinuteMailPage.openEmail();
       String resultTotalCostFromEmail = tenMinuteMailPage.getTotalCost().getText();
       Assert.assertTrue(resultWithTotalCost.contains(resultTotalCostFromEmail),"Expected total cost on page does not match total cost from email");
   }
}