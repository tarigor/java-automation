package training.webdriver.hurt_me_plenty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageTestResult extends AbstractPage {

    private Boolean result;

    @FindBy(xpath = "//*[@class='textarea']")
    private WebElement codeText;

    @FindBy(xpath = "//a[@href='/archive/bash']")
    private WebElement syntaxHighlight;

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement titleText;

    public PageTestResult(WebDriver driver) {
        super(driver);
    }

    public Boolean checkCodeText() {

        return result;
    }

    public Boolean checkSyntaxHighlight() {

        return result;
    }

    public Boolean checkTitle() {

        return result;
    }

    private void checkResult(String textOnPage, String textToCompare, WebElement webElement) {
        result = textOnPage.equals(textToCompare);
        if(result) System.out.println(driver.toString()+": test passed, the text '"+textToCompare+"' is present");
        return;
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
