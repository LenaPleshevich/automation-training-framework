package task.com.epam.test.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task.com.epam.google.CalculatorPage;
import task.com.epam.google.HomePage;
import task.com.epam.tenMinuteMail.TenMinuteMailPage;

public class CalculatorPageTest {
    private static final String OS = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private static final String INSTANCES_NUMBER = "4";
    private static final String PLATFORM = "COMPUTE ENGINE";
    private static final String VM_CLASS = "Regular";
    private static final String TYPE_INSTANCE = "n1-standard-8";
    private static final String LOCAL_SSD = "2x375 GB";
    private static final String COMMITED_USAGE = "1 Year";
    private static final String DATA_CENTER_LOCATION = "Frankfurt";
    private static final String GPU_NUMBER = "1";
    private static final String TYPE_GPU = "NVIDIA Tesla V100";
    private static final String EXPECTED_COST = "1,187.77";
    private static WebDriver driver;
    private static HomePage homePage;
    private static TenMinuteMailPage tenMinuteMailPage;
    private static CalculatorPage calculatorPage;

    @BeforeMethod
    public static void setup() {
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com/ ");
        driver.manage().window().maximize();
    }

    public static void goToPageCalculators() {
        calculatorPage = homePage.goToPageProducts().goToPagePrising().goToPageCalculators();
    }

    public void createEstimate(){
        homePage = new HomePage(driver);
        tenMinuteMailPage = new TenMinuteMailPage(driver);
        goToPageCalculators();
        calculatorPage.switchToFrame();
        calculatorPage.selectPlatform(PLATFORM)
                .selectInstancesNumber(INSTANCES_NUMBER)
                .selectOS(OS)
                .selectVMClass(VM_CLASS)
                .selectInstanceType(TYPE_INSTANCE)
                .addGPU(GPU_NUMBER, TYPE_GPU)
                .selectLocalSSD(LOCAL_SSD)
                .selectDataCenterLocation(DATA_CENTER_LOCATION)
                .selectCommitedUsage(COMMITED_USAGE);
        calculatorPage.addToExecute();
    }

    @Test
    public void parameterCalculatorTest() {
        createEstimate();
        checkEnteredParameters();
    }

    @Test
    public void checkTotalCostTest(){
        createEstimate();
        String actualCost = calculatorPage.getCost().getText();
        calculatorPage.emailEstimate();
        Assert.assertTrue(actualCost.contains(EXPECTED_COST),"Expected total cost on page does not match total cost from email");
    }

    @Test
    public void checkTotalCostInEmailTest(){
        createEstimate();
        String expectedCost = calculatorPage.getCost().getText();
        calculatorPage.emailEstimate();
        String actualCost = getTotalCost();
        Assert.assertTrue(expectedCost.indexOf(actualCost) > -1,"Expected total cost on page does not match total cost from email");
    }

    private String getTotalCost(){
        String urlGooglePage = driver.getCurrentUrl();
        driver.get("https://10minutemail.com");
        String email = tenMinuteMailPage.getGenerateMail();
        String urlTenMinuteMailPage = driver.getCurrentUrl();
        tenMinuteMailPage = new TenMinuteMailPage(driver);
        driver.navigate().to(urlGooglePage);
        calculatorPage.switchToFrame();
        calculatorPage.emailEstimate();
        calculatorPage.inputEmail(email).sendEmail();
        driver.navigate().to(urlTenMinuteMailPage);
        driver.switchTo().defaultContent();
        tenMinuteMailPage.openEmail();
        String totalCost = tenMinuteMailPage.getTotalCost().getText();
        return totalCost;
    }

    private void checkEnteredParameters() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(calculatorPage.getVMClass().getText().contains(VM_CLASS.toLowerCase())
                , "The resulting parameter value VM_CLASS does not match expected");
        softAssert.assertTrue(calculatorPage.getInstanceType().getText().contains(TYPE_INSTANCE)
                ,"The resulting parameter value TYPE_INSTANCE does not match expected");
        softAssert.assertTrue(calculatorPage.getLocalSSD().getText().contains(LOCAL_SSD)
                , "The resulting parameter value LOCAL_SSD does not match expected");
        softAssert.assertTrue(calculatorPage.getRegion().getText().contains(DATA_CENTER_LOCATION)
                ,"The resulting parameter value DATA_CENTER_LOCATION does not match expected");
        softAssert.assertTrue(calculatorPage.getCommitmentTerm().getText().contains(COMMITED_USAGE)
                , "The resulting parameter value COMMITED_USAGE does not match expected");
        softAssert.assertAll();
    }
}