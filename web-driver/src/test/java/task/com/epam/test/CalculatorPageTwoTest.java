package task.com.epam.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import task.com.epam.driver.DriverSingleton;
import task.com.epam.model.Calculator;
import task.com.epam.model.Email;
import task.com.epam.page.CalculatorPage;
import task.com.epam.page.HomePage;
import task.com.epam.page.TenMinuteMailNetPage;
import task.com.epam.service.CalculatorCreator;

public class CalculatorPageTwoTest extends CommonConditions{
    private static WebDriver driver;
    private static HomePage homePage;
    private static TenMinuteMailNetPage tenMinuteMailNetPage;
    private static CalculatorPage calculatorPage;
    private Calculator calculator;
    private Email email;

    @BeforeMethod()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }

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

    @Test
    public void checkTotalCostInEmailTest(){
        calculator = CalculatorCreator.withCredentialsFromProperties();
        createEstimate();
        System.out.println(calculatorPage.getCost().getText());
        calculator.setCost(calculatorPage.getCost().getText());
        calculatorPage.emailEstimate();
        Assert.assertTrue(calculator.getCost().indexOf(getTotalCost().getTextWithTotalCost()) > -1,
                "Expected total cost on page does not match total cost from email");
    }

    private Email getTotalCost(){
        String urlGooglePage = driver.getCurrentUrl();
        tenMinuteMailNetPage = new TenMinuteMailNetPage(driver);
        tenMinuteMailNetPage.openPage();
        email = new Email(tenMinuteMailNetPage.getGenerateMail());
        String urlTenMinuteMailPage = driver.getCurrentUrl();
        tenMinuteMailNetPage = new TenMinuteMailNetPage(driver);
        driver.navigate().to(urlGooglePage);
        calculatorPage.switchToFrame();
        calculatorPage.emailEstimate();
        calculatorPage.inputEmail(email.getEmail()).sendEmail();
        driver.navigate().to(urlTenMinuteMailPage);
        driver.switchTo().defaultContent();
        tenMinuteMailNetPage.openEmail();
        email.setTextWithTotalCost(tenMinuteMailNetPage.getTotalCost().getText());
        return email;
    }
}
