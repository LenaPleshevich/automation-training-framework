package com.epam.test;

import com.epam.driver.DriverSingleton;
import com.epam.model.ComputeEngine;
import com.epam.model.Email;
import com.epam.page.CalculatorPage;
import com.epam.page.HomePage;
import com.epam.page.TenMinuteMailNetPage;
import com.epam.page.TenMinuteMailPage;
import com.epam.service.ComputeEngineCreator;
import com.epam.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    protected HomePage homePage;
    protected TenMinuteMailNetPage tenMinuteMailNetPage;
    protected TenMinuteMailPage tenMinuteMailPage;
    protected CalculatorPage calculatorPage;
    protected ComputeEngine computeEngine;
    protected Email email;
    protected String resultWithTotalCost;

    @BeforeMethod()
    public void setUp() {
        driver = DriverSingleton.getDriver();
        createEstimate();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }

    public void createEstimate(){
        computeEngine = ComputeEngineCreator.withCredentialsFromProperties();
        homePage = new HomePage(driver).openPage();
        calculatorPage = homePage
                .goToPageProducts()
                .goToPagePrising()
                .goToPageCalculators();
        calculatorPage.switchToInnerHtmlDocument();
        selectParametersInCalculator();
        calculatorPage.addToExecute();
        resultWithTotalCost = calculatorPage.getCost().getText();
        calculatorPage.emailEstimate();
    }

    private void selectParametersInCalculator() {
        calculatorPage.selectPlatform(computeEngine.getPlatform())
                .selectInstancesNumber(computeEngine.getInstancesNumber())
                .selectOS(computeEngine.getOs())
                .selectVMClass(computeEngine.getVmClass())
                .selectInstanceType(computeEngine.getTypeInstance())
                .addGPU(computeEngine.getNumberGPU(), computeEngine.getTypeGPU())
                .selectLocalSSD(computeEngine.getLocalSSD())
                .selectDataCenterLocation(computeEngine.getDataCenterLocation())
                .selectCommitedUsage(computeEngine.getCommitedUsage());
    }

}
