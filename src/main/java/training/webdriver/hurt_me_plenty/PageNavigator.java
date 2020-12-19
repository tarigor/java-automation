package training.webdriver.hurt_me_plenty;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPathConstants;

public class PageNavigator extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String SEARCH_REQUEST = "Google Cloud Platform Pricing Calculator";

    private static final String FORM_NUMBER_OF_INSTANCE = "4";
    private static final String FORM_OS_TYPE = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private static final String FORM_CLASS_TYPE = "Regular";
    private static final String FORM_INSTANCE_SERIES = "N1";
    private static final String FORM_INSTANCE_TYPE = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    private static final String FORM_GPU_NUMBER = "1";
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

    @FindBy(xpath = "//*[@id='select_value_label_55']")
    private WebElement spanOS;
    @FindBy(xpath = "*//*[@id='select_container_76']//.//*[contains(text(),'"+FORM_OS_TYPE+"')]")
    private WebElement spanOSSelection;

    @FindBy(xpath = "//*[@id='select_value_label_56']")
    private WebElement spanMachineClass;
    @FindBy(xpath = "*//*[@id='select_container_80']//.//*[contains(text(),'"+FORM_CLASS_TYPE+"')]")
    private WebElement spanMachineClassSelection;

    @FindBy(xpath = "//*[@id='select_value_label_58']")
    private WebElement spanMachineSeries;
    @FindBy(xpath = "*//*[@id='select_container_88']//.//*[contains(text(),'"+FORM_INSTANCE_SERIES+"')]")
    private WebElement spanMachineSeriesSelection;

    @FindBy(xpath = "//*[@id='select_value_label_59']")
    private WebElement spanInstanceType;
    @FindBy(xpath = "*//*[@id='select_container_90']//.//*[contains(text(),'"+FORM_INSTANCE_TYPE+"')]")
    private WebElement spanInstanceTypeSelection;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.addGPUs']//*[@class='md-container md-ink-ripple']")
    private WebElement checkBoxAddGPUs;

    @FindBy(xpath = "//*[@id='select_value_label_392']")
    private WebElement spanAddGPUsNumberOfGPUs;
    @FindBy(xpath = "*//*[@id='select_container_395']//.//*[contains(text(),'"+FORM_GPU_NUMBER+"')]")
    private WebElement spanAddGPUsNumberOfGPUsSelection;

    @FindBy(xpath = "//*[@id='select_value_label_393']")
    private WebElement spanAddGPUsGPUtype;
    @FindBy(xpath = "*//*[@id='select_container_397']//.//*[contains(text(),'"+FORM_GPU_TYPE+"')]")
    private WebElement spanAddGPUsGPUtypeSelection;

    @FindBy(xpath = "//*[@id='select_value_label_354']")
    private WebElement spanSSDCapacity;
    @FindBy(xpath = "*//*[@id='select_container_356']//.//*[contains(text(),'"+FORM_SSD_CAPACITY+"')]")
    private WebElement spanSSDCapacitySelection;

    @FindBy(xpath = "//*[@id='select_value_label_60']")
    private WebElement spanLocation;
    @FindBy(xpath = "*//*[@id='select_container_92']//.//*[contains(text(),'"+FORM_LOCATION+"')]")
    private WebElement spanLocationSelection;

    @FindBy(xpath = "//*[@id='select_value_label_61']")
    private WebElement spanFieldUsage;
    @FindBy(xpath = "*//*[@id='select_container_99']//.//*[contains(text(),'"+FORM_USAGE+"')]")
    private WebElement spanFieldUsageSelection;

    @FindBy(xpath = "//*[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement buttonAddToEstimate;

    public static String getFormClassType() {
        return FORM_CLASS_TYPE;
    }

    public static String getFormInstanceType() {
        return FORM_INSTANCE_TYPE;
    }

    public static String getFormSsdCapacity() {
        return FORM_SSD_CAPACITY;
    }

    public static String getFormLocation() {
        return FORM_LOCATION;
    }

    public static String getFormUsage() {
        return FORM_USAGE;
    }

    Actions actions = new Actions(driver);

    public PageNavigator(WebDriver driver) {
        super(driver);
    }

    public PageNavigator openPage() {
        driver.manage().window().maximize();
        driver.get(HOMEPAGE_URL);
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
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='myFrame']")));

        inputFieldHandling(inputFieldNumberOfInstances,FORM_NUMBER_OF_INSTANCE);
        spanOptionHandling(spanOS,spanOSSelection);
        spanOptionHandling(spanMachineClass,spanMachineClassSelection);
        spanOptionHandling(spanMachineSeries,spanMachineSeriesSelection);
        spanOptionHandling(spanInstanceType,spanInstanceTypeSelection);
        checkBoxHandling(checkBoxAddGPUs);
        spanOptionHandling(spanAddGPUsNumberOfGPUs,spanAddGPUsNumberOfGPUsSelection);
        spanOptionHandling(spanAddGPUsGPUtype,spanAddGPUsGPUtypeSelection);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        spanOptionHandling(spanSSDCapacity,spanSSDCapacitySelection);
        spanOptionHandling(spanLocation,spanLocationSelection);
        spanOptionHandling(spanFieldUsage,spanFieldUsageSelection);

        return this;
    }

    public PageNavigator createRequest() {
        buttonAddToEstimate.click();
        return this;
    }

    private void checkBoxHandling(WebElement checkBoxField) {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(checkBoxField));
        checkBoxField.click();
    }

    private void spanOptionHandling(WebElement xpathRequiredOption,WebElement xpathSelection) {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(xpathRequiredOption));
        xpathRequiredOption.click();
        xpathSelection.click();
    }

    private void inputFieldHandling(WebElement fieldXpath, String value) {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(fieldXpath));
        fieldXpath.sendKeys(value);
    }
}
