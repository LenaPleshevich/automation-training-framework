package com.epam.test;

import com.epam.model.Email;
import com.epam.page.TenMinuteMailPage;
import com.epam.service.CalculatorCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorPageTest extends BaseTest{

    @Test
    public void checkTotalCostInEmailTest(){
        calculator = CalculatorCreator.withCredentialsFromProperties();
        createEstimate();
        calculator.setCost(calculatorPage.getCost().getText());
        calculatorPage.emailEstimate();
        Assert.assertTrue(calculator.getCost().indexOf(getTotalCost().getTextWithTotalCost()) > -1,
                "Expected total cost on page does not match total cost from email");
    }

    private Email getTotalCost(){
        String urlGooglePage = driver.getCurrentUrl();
        tenMinuteMailPage = new TenMinuteMailPage(driver);
        tenMinuteMailPage.openPage();
        email = new Email(tenMinuteMailPage.getGenerateMail());
        String urlTenMinuteMailPage = driver.getCurrentUrl();
        tenMinuteMailPage = new TenMinuteMailPage(driver);
        driver.navigate().to(urlGooglePage);
        calculatorPage.switchToFrame();
        calculatorPage.emailEstimate();
        calculatorPage.inputEmail(email.getEmail()).sendEmail();
        driver.navigate().to(urlTenMinuteMailPage);
        driver.switchTo().defaultContent();
        tenMinuteMailPage.openEmail();
        email.setTextWithTotalCost(tenMinuteMailPage.getTotalCost().getText());
        return email;
    }
}