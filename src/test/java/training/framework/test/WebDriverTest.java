package training.framework.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import training.framework.model.TestingSet;
import training.framework.page.HomePageNavigator;
import training.framework.page.PageTestResult;
import training.framework.service.TestingSetCreator;

public class WebDriverTest extends CommonConditions{

    @Test(description = "test")
    public void scenarioTest() {
        testProcedure(StartScenarioOnBrowser(driver));
    }

    private static WebDriver StartScenarioOnBrowser(WebDriver driver){

        TestingSet testingSet = TestingSetCreator.withTestingSetFromProperty();

        new HomePageNavigator(driver)
                .openPage()
                .searchForElementAndClick()
                .fillSiteForm(testingSet)
                .createRequest()
                .openEmailSiteAndTakeEmailName()
                .sendEmail()
                .verifyCostInEmail();
        return driver;
    }

    private void testProcedure(WebDriver driver) {
        Assert.assertTrue(PageTestResult.result,driver.toString()+": FAIL: email address is not equal");
    }

}