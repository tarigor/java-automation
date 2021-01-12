package training.framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import training.framework.util.CustomConditions;

import java.util.ArrayList;

public class EmailPageNavigator extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private String urlName;
    String emailName;
    String estimatedCost;
    static String costValueFromEmail;
    String[] bodyText;

    @FindBy (xpath ="//span[@class='email']")
    private WebElement xpathEmailNameField;

    @FindBy (xpath ="//pre[contains(@data-bind,'bodyView()')]")
    private WebElement emailBody;

    protected EmailPageNavigator(WebDriver driver, String urlName) {
        super(driver);
        this.urlName =urlName;
    }

    protected EmailPageNavigator(WebDriver driver, String estimatedCost, String emailName) {
        super(driver);
        this.emailName =emailName;
        this.estimatedCost = estimatedCost;
        costValueFromEmail = getCostValueFromEmail();
    }

    private String getCostValueFromEmail() {
            new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(emailBody));

            bodyText = emailBody.getText().split(":");
            bodyText = bodyText[2].split(" ");
            costValueFromEmail = bodyText[0];

            return costValueFromEmail;
    }

    public HomePageNavigator openEmailSiteAndTakeEmailName(){
        ((JavascriptExecutor)driver).executeScript("window.open();");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        driver.get(urlName);
        new WebDriverWait(driver, 10).until(CustomConditions.pageLoadCompleted());

        logger.info("Email generator site opened");

        emailName = xpathEmailNameField.getText();

        logger.info("Email has been generated");

        driver.switchTo().window(tabs.get(0));
        return new HomePageNavigator(driver,emailName,tabs);
    }

    public PageTestResult verifyCostInEmail(){
        return new PageTestResult(driver,estimatedCost,costValueFromEmail);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
