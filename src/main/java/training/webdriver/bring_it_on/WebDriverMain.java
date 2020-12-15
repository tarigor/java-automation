package training.webdriver.bring_it_on;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WebDriverMain {

    String webDriverPath = System.getenv("WEBDRIVE_HOME");

    WebDriver chromeDriver, firefoxDriver, edgeDriver;

    @Test(description = "test")
    public void scenarioTest() {

        System.setProperty("webdriver.edge.driver",webDriverPath+"\\msedgedriver.exe");

        chromeDriver = StartScenarioOnBrowser(new ChromeDriver());
//        firefoxDriver = StartScenarioOnBrowser(new FirefoxDriver());
//        edgeDriver = StartScenarioOnBrowser(new EdgeDriver());

        testProcedure(chromeDriver);
//        testProcedure(firefoxDriver);
//        testProcedure(edgeDriver);
    }

    private void testProcedure(WebDriver driver) {
        PageTestResult testPage = new PageTestResult(driver);
        Assert.assertTrue(testPage.checkCodeText(),driver.toString()+": FAIL:The text code does not incorporate");
        Assert.assertTrue(testPage.checkSyntaxHighlight(),driver.toString()+": FAIL:The highlight of syntax is not correct");
        Assert.assertTrue(testPage.checkTitle(),driver.toString()+ ": FAIL:The text of title does not incorporate");
    }

    @AfterMethod (alwaysRun = true)
    public void afterTestCompleted(){

//        driverQuit(chromeDriver);
//        driverQuit(firefoxDriver);
//        driverQuit(edgeDriver);

    }

    private void driverQuit(WebDriver driver) {
        driver.quit();
        driver = null;
    }

    private static WebDriver StartScenarioOnBrowser(WebDriver driver){
        new PageNavigator(driver)
                .openPage()
                .fillSiteForm()
                .createRequest();
        return driver;
    }

}
