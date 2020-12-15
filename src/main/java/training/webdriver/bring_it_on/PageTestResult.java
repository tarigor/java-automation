package training.webdriver.bring_it_on;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;


public class PageTestResult extends AbstractPage {

    private Boolean result;

    public PageTestResult(WebDriver driver) {
        super(driver);
    }

    public Boolean checkTitle() {
        System.out.println(driver.toString()+": test passed, Title is: "+PageNavigator.getTitleText());
        result = true;
        return result;
    }

    public Boolean checkSyntaxHighlight() {
        System.out.println(driver.toString()+": test passed, Syntax is: "+PageNavigator.getSYNTAX());
        result = false;
        return result;
    }

    public Boolean checkCodeText() {
        System.out.println(driver.toString()+": test passed, Code is: "+PageNavigator.getCodeFieldText());
        result = true;
        return result;
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
