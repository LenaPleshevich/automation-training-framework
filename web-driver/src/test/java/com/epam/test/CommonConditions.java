package com.epam.test;

import com.epam.driver.DriverSingleton;
import com.epam.model.Instance;
import com.epam.model.Email;
import com.epam.page.CalculatorPage;
import com.epam.page.HomePage;
import com.epam.page.TenMinuteMailNetPage;
import com.epam.page.TenMinuteMailPage;
import com.epam.service.InstanceCreator;
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
    protected Instance instance;
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
        instance = InstanceCreator.withCredentialsFromProperties();
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
        calculatorPage.selectPlatform(instance.getPlatform())
                .selectInstancesNumber(instance.getInstancesNumber())
                .selectOS(instance.getOs())
                .selectVMClass(instance.getVmClass())
                .selectInstanceType(instance.getTypeInstance())
                .addGPU(instance.getNumberGPU(), instance.getTypeGPU())
                .selectLocalSSD(instance.getLocalSSD())
                .selectDataCenterLocation(instance.getDataCenterLocation())
                .selectCommitedUsage(instance.getCommitedUsage());
    }

}
