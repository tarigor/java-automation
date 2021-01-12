package training.webdriver.hardcore;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class EmailPageNavigator extends AbstractPage {

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

            System.out.println("Cost value from Email: " + costValueFromEmail);

            return costValueFromEmail;
    }

    public HomePageNavigator openEmailSiteAndTakeEmailName(){
        ((JavascriptExecutor)driver).executeScript("window.open();");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        driver.get(urlName);

        new WebDriverWait(driver, 10).until(CustomConditions.pageLoadCompleted());
        emailName = xpathEmailNameField.getText();
        System.out.println("Generated email: "+emailName);

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
