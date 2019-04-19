package task.com.epam.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import task.com.epam.driver.DriverSingleton;
import task.com.epam.util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;


    @BeforeMethod()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
