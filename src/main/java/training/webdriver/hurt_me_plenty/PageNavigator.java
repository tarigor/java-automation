package training.webdriver.hurt_me_plenty;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageNavigator extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String SEARCH_REQUEST = "Google Cloud Platform Pricing Calculator";
    private static final String CALCULATOR_PAGE_OPTION = "Instances";

    private static final String FORM_NUMBER_OF_INSTANCE = "4";
    private static final String FORM_OS_TYPE = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private static final String FORM_VM_CLASS = "Regular";
    private static final String FORM_INSTANCE_SERIES = "n1";
    private static final String FORM_INSTANCE_TYPE = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    private static final String FORM_NUMBER_OF_GPUs = "1";
    private static final String FORM_GPU_TYPE = "NVIDIA Tesla V100";
    private static final String FORM_SSD_CAPACITY = "2x375 GB";
    private static final String FORM_LOCATION = "Frankfurt (europe-west3)";
    private static final String FORM_USAGE = "1 Year";

    @FindBy(xpath = "//*[@class='devsite-search-field devsite-search-query']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@class='gsc-results gsc-webResult']")
    private WebElement searchResultField;

    @FindBy(xpath = "//*[@class='compute-engine-block']")
    private WebElement elementOnCalculatorPage;

    @FindBy(xpath = "//*[@id='input_62']")
    private WebElement inputFieldNumberOfInstances;

    @FindBy(xpath = "//*[select_value_label_55]")
    private WebElement spanOS;

    @FindBy(xpath = "select_value_label_56]")
    private WebElement spanMachineClass;

    @FindBy(xpath = "select_value_label_58]")
    private WebElement spanMachineSeries;

    @FindBy(xpath = "select_value_label_59")
    private WebElement spanInstanceType;

    @FindBy(xpath = "//*[@class='ng-valid ng-dirty ng-valid-parse ng-touched ng-empty'] / *[ @class='md-container md-ink-ripple']")
    private WebElement checkBoxAddGPUs;

    @FindBy(xpath = "//*[@placeholder='Number of GPUs']")
    private WebElement spanAddGPUsNumberOfGPUs;

    @FindBy(xpath = "//*[@placeholder='GPU type']")
    private WebElement spanAddGPUsGPUtype;

    @FindBy(xpath = "select_value_label_101")
    private WebElement spanSSDCapacity;

    @FindBy(xpath = "select_value_label_102")
    private WebElement spanLocation;

    @FindBy(xpath = "select_value_label_103")
    private WebElement spanFieldUsage;

    public PageNavigator(WebDriver driver) {
        super(driver);
    }

    public PageNavigator openPage() {
        driver.manage().window().maximize();
        driver.get(HOMEPAGE_URL);
//        new WebDriverWait(driver, 10).until(CustomConditions.jQueryAJAXCompleted());
        return this;
    }

    public PageNavigator searchForElementAndClick(){
        System.out.println("xpath: "+String.valueOf(searchButton));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
        searchButton.sendKeys(SEARCH_REQUEST);
        searchButton.sendKeys(Keys.RETURN);

        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(searchResultField));
        searchResultField.findElement(By.linkText(SEARCH_REQUEST)).click();

        return this;
    }

    public PageNavigator fillSiteForm() {
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cloud-site']//iframe")));
        driver.findElement(By.xpath("//div[@class='tab-holder compute' and @title='Compute Engine']"));

//        new  WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(elementOnCalculatorPage));
        System.out.println("url: "+driver.getCurrentUrl());
        inputFieldHandling(inputFieldNumberOfInstances,FORM_NUMBER_OF_INSTANCE);
        spanOptionHandling(spanOS,FORM_OS_TYPE);


        return this;
    }

    private void spanOptionHandling(WebElement fieldXpath, String value) {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(fieldXpath));
        fieldXpath.click();
        driver.findElement(By.linkText(value)).click();
    }

    private void inputFieldHandling(WebElement fieldXpath, String value) {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(fieldXpath));
        fieldXpath.sendKeys(value);
    }

    public PageNavigator createRequest() {

        return this;
    }
}
