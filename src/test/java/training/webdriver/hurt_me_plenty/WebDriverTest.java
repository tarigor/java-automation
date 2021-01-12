package training.webdriver.hurt_me_plenty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import training.webdriver.hurt_me_plenty.PageNavigator;
import training.webdriver.hurt_me_plenty.PageTestResult;

public class WebDriverTest {

    String webDriverPath = System.getenv("WEBDRIVE_HOME");

    WebDriver chromeDriver, firefoxDriver, edgeDriver;

    @Test(description = "test")
    public void scenarioTest() {

        System.setProperty("webdriver.edge.driver",webDriverPath+"\\msedgedriver.exe");

        chromeDriver = StartScenarioOnBrowser(new ChromeDriver());
        firefoxDriver = StartScenarioOnBrowser(new FirefoxDriver());
        edgeDriver = StartScenarioOnBrowser(new EdgeDriver());

        testProcedure(chromeDriver);
        testProcedure(firefoxDriver);
        testProcedure(edgeDriver);


    }

    private static WebDriver StartScenarioOnBrowser(WebDriver driver){
        new PageNavigator(driver)
                .openPage()
                .searchForElementAndClick()
                .fillSiteForm()
                .createRequest();
        return driver;
    }

    private void testProcedure(WebDriver driver) {
        PageTestResult testPage = new PageTestResult(driver);
        Assert.assertTrue(testPage.checkVMClass(),driver.toString()+": FAIL: for VM Class check");
        Assert.assertTrue(testPage.checkInstanceType(),driver.toString()+": FAIL: for Instance Type check");
        Assert.assertTrue(testPage.checkRegion(),driver.toString()+": FAIL: for Region check");
        Assert.assertTrue(testPage.checkSSD(),driver.toString()+": FAIL: for SSD capacity check");
        Assert.assertTrue(testPage.checkUsage(),driver.toString()+": FAIL: for Usage term check");
    }

    @AfterMethod (alwaysRun = true)
    public void afterTestCompleted(){

        driverQuit(chromeDriver);
        driverQuit(firefoxDriver);
        driverQuit(edgeDriver);

    }

    private void driverQuit(WebDriver driver) {
        driver.quit();
        driver = null;
    }

}
