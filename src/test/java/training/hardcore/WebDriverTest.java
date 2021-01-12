package training.hardcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import training.webdriver.hardcore.HomePageNavigator;
import training.webdriver.hardcore.PageTestResult;

public class WebDriverTest {

    String webDriverPath = System.getenv("WEBDRIVE_HOME");

    WebDriver chromeDriver, firefoxDriver, edgeDriver;

    @Test(description = "test")
    public void scenarioTest() {

        System.setProperty("webdriver.edge.driver",webDriverPath+"\\msedgedriver.exe");

//        chromeDriver = StartScenarioOnBrowser(new ChromeDriver());
        firefoxDriver = StartScenarioOnBrowser(new FirefoxDriver());
//        edgeDriver = StartScenarioOnBrowser(new EdgeDriver());

//        testProcedure(chromeDriver);
        testProcedure(firefoxDriver);
//        testProcedure(edgeDriver);

    }

    private static WebDriver StartScenarioOnBrowser(WebDriver driver){
        new HomePageNavigator(driver)
                .openPage()
                .searchForElementAndClick()
                .fillSiteForm()
                .createRequest()
                .openEmailSiteAndTakeEmailName()
                .sendEmail()
                .verifyCostInEmail();
        return driver;
    }

    private void testProcedure(WebDriver driver) {
        System.out.println("result(assert method): "+ PageTestResult.result);
        Assert.assertTrue(PageTestResult.result,driver.toString()+": FAIL: email address is not equal");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTestCompleted(){

//        driverQuit(chromeDriver);
//        driverQuit(firefoxDriver);
//        driverQuit(edgeDriver);

    }

    private void driverQuit(WebDriver driver) {
        driver.quit();
        driver = null;
    }
}
