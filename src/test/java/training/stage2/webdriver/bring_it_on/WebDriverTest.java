package training.stage2.webdriver.bring_it_on;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WebDriverTest {

    WebDriver firefoxDriver;

    private static WebDriver StartScenarioOnBrowser(WebDriver driver) {
        new PageNavigator(driver)
                .openPage()
                .fillSiteForm()
                .createRequest();
        return driver;
    }

    @Test(description = "test2")
    public void scenarioTest() {

        firefoxDriver = StartScenarioOnBrowser(new FirefoxDriver());
        testProcedure(firefoxDriver);
    }

    private void testProcedure(WebDriver driver) {
        PageTestResult testPage = new PageTestResult(driver);
        Assert.assertTrue(testPage.checkCodeText(), driver.toString() + ": FAIL:The text code does not incorporate");
        Assert.assertTrue(testPage.checkSyntaxHighlight(), driver.toString() + ": FAIL:The highlight of syntax is not correct");
        Assert.assertTrue(testPage.checkTitle(), driver.toString() + ": FAIL:The text of title does not incorporate");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTestCompleted() {

        driverQuit(firefoxDriver);

    }

    private void driverQuit(WebDriver driver) {
        driver.quit();
    }

}
