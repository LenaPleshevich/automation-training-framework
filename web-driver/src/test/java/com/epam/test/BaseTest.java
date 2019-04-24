package com.epam.test;

import com.epam.model.Calculator;
import com.epam.model.Email;
import com.epam.page.CalculatorPage;
import com.epam.page.HomePage;
import com.epam.page.TenMinuteMailNetPage;
import com.epam.page.TenMinuteMailPage;

public class BaseTest extends CommonConditions {
    protected HomePage homePage;
    protected TenMinuteMailNetPage tenMinuteMailNetPage;
    protected TenMinuteMailPage tenMinuteMailPage;
    protected CalculatorPage calculatorPage;
    protected Calculator calculator;
    protected Email email;

    public void createEstimate(){
        homePage = new HomePage(driver).openPage();
        calculatorPage = homePage
                .goToPageProducts()
                .goToPagePrising()
                .goToPageCalculators();
        calculatorPage.switchToFrame();
        calculatorPage.selectPlatform(calculator.getPlatform())
                .selectInstancesNumber(calculator.getInstancesNumber())
                .selectOS(calculator.getOS())
                .selectVMClass(calculator.getVMClass())
                .selectInstanceType(calculator.getTypeInstance())
                .addGPU(calculator.getGPUNumber(), calculator.getTypeGPU())
                .selectLocalSSD(calculator.getLocalSSD())
                .selectDataCenterLocation(calculator.getDataCenterLocation())
                .selectCommitedUsage(calculator.getCommitedUsage());
        calculatorPage.addToExecute();
    }
}
