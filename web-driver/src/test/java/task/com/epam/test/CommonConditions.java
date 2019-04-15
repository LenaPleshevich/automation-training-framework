package task.com.epam.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import task.com.epam.driver.DriverSingleton;

//@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;


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
}
