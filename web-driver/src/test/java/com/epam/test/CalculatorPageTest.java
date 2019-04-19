package task.com.epam.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task.com.epam.driver.DriverSingleton;
import task.com.epam.model.Calculator;
import task.com.epam.model.Email;
import task.com.epam.page.CalculatorPage;
import task.com.epam.page.HomePage;
import task.com.epam.page.TenMinuteMailPage;
import task.com.epam.service.CalculatorCreator;

public class CalculatorPageTest extends CommonConditions{
    private static WebDriver driver;
    private static HomePage homePage;
    private static TenMinuteMailPage tenMinuteMailPage;
    private static CalculatorPage calculatorPage;
    private Calculator calculator;
    private Email email;
    /*public static void goToPageCalculators() {
        calculatorPage = homePage.openPage()
                .goToPageProducts()
                .goToPagePrising()
                .goToPageCalculators();
    }*/

    @BeforeMethod()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
        System.out.println("kflgklfmjgklfmgklm");
    }

   /* @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
        System.out.println("kflgklfmjgklfmgklm");
    }*/

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

  //  @Test
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