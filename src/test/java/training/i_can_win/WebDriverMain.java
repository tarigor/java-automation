package training.i_can_win;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import training.webdriver.i_can_win.PageNavigator;

public class WebDriverMain {

    String webDriverPath = System.getenv("WEBDRIVE_HOME");

    WebDriver chromeDriver, firefoxDriver, edgeDriver;

    @Test(description = "test")
    public void scenarioTest() {

        System.setProperty("webdriver.edge.driver",webDriverPath+"\\msedgedriver.exe");

        chromeDriver = StartScenarioOnBrowser(new ChromeDriver());
        firefoxDriver = StartScenarioOnBrowser(new FirefoxDriver());
        edgeDriver = StartScenarioOnBrowser(new EdgeDriver());

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

    private static WebDriver StartScenarioOnBrowser(WebDriver driver){
        new PageNavigator(driver)
                .openPage()
                .fillSiteForm()
                .createPaste();
        return driver;
    }

}
