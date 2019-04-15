package task.com.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CalculatorPage extends AbstractPage {
    private static final int SIZE_WAIT = 20;
    private final String PAGE_URL = "https://github.com/login";
    @FindBy(xpath = "//div[@class='name ng-binding']")
    private List<WebElement> platformList;
    @FindBy(id = "input_49")
    private WebElement instancesNumber;
    @FindBy(id = "select_61")
    private WebElement OSDropDown;
    @FindBy(xpath = "//*[@id='select_container_62']//*[@class='md-ink-ripple']")
    private List<WebElement> OSlist;
    @FindBy(id = "select_65")
    private WebElement VMClassDropDown;
    @FindBy(xpath = "//*[@id='select_container_66']//*[@class='md-ink-ripple']")
    private List<WebElement> VMClassList;
    @FindBy(id = "select_96")
    private WebElement instanceTypeDropDown;
    @FindBy(xpath = "//*[@id='select_container_97']//*[@class='md-ink-ripple']")
    private List<WebElement> instanceTypeList;
    @FindBy(xpath = "//*[@aria-label='Add GPUs']")
    private WebElement GPUcheckBox;
    @FindBy(id = "select_332")
    private WebElement GPUsNumberDropDown;
    @FindBy(xpath = "//*[@id='select_container_333']//*[@class='ng-scope md-ink-ripple']")
    private List<WebElement> GPUsNumberList;
    @FindBy(id = "select_334")
    private WebElement typeGPUDropDown;
    @FindBy(xpath = "//*[@id='select_container_335']//*[@class='ng-scope md-ink-ripple']")
    private List<WebElement> typeGPUList;
    @FindBy(id = "select_98")
    private WebElement localSSDDropDown;
    @FindBy(xpath = "//*[@id='select_container_99']//*[@class='ng-scope md-ink-ripple']")
    private List<WebElement> localSSDList;
    @FindBy(id = "select_100")
    private WebElement dataCenterLocationDropDown;
    @FindBy(xpath = "//*[@id='select_container_101']//*[@class='ng-scope md-ink-ripple']")
    private List<WebElement> dataCenterLocationList;
    @FindBy(id = "select_105")
    private WebElement commitedUsageDropDown;
    @FindBy(xpath = "//*[@id='select_container_106']//*[@class='md-ink-ripple']")
    private List<WebElement> commitedUsageList;
    @FindBy(id = "idIframe")
    private WebElement frame;
    @FindBy(xpath = "//*[text()='Add to Estimate'][@aria-label='Add to Estimate']")
    private WebElement addToExecuteButton;
    @FindBy(xpath = "//*[@class='md-list-item-text ng-binding']")
    private List<WebElement> estimatesParameters;
    @FindBy(xpath = "//h2//b[@class='ng-binding']")
    private WebElement estimatedCost;
    @FindBy(xpath = "//*[@id='email_quote']")
    private WebElement emailEstimateButton;
    @FindBy(id = "input_348")
    private WebElement emailForm;
    @FindBy(xpath = "//*[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    protected AbstractPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public CalculatorPage selectOS(String OS) {
        OSDropDown.click();
        selectParameter(OSlist, OS);
        return this;
    }

    public CalculatorPage selectVMClass(String VMClass) {
        initWait(VMClassDropDown);
        VMClassDropDown.click();
        selectParameter(VMClassList, VMClass);
        return this;
    }

    public CalculatorPage selectInstancesNumber(String number) {
        initWait(instancesNumber);
        instancesNumber.sendKeys(number);
        return this;
    }

    public CalculatorPage selectPlatform(String platform) {
        new WebDriverWait(driver,SIZE_WAIT);
        selectParameter(platformList,platform);
        return this;
    }

    public CalculatorPage selectInstanceType(String instanceType) {
        initWait(instanceTypeDropDown);
        instanceTypeDropDown.click();
        selectParameter(instanceTypeList, instanceType);
        return this;
    }

    public CalculatorPage selectGPUsNumber(String number) {
        initWait(GPUsNumberDropDown);
        GPUsNumberDropDown.click();
        selectParameter(GPUsNumberList, number);
        return this;
    }

    public CalculatorPage selectTypeGPU(String typeGPU) {
        typeGPUDropDown.click();
        selectParameter(typeGPUList, typeGPU);
        return this;
    }

    public CalculatorPage addGPU(String GPUsNumber, String typeGPU) {
        GPUcheckBox.click();
        selectGPUsNumber(GPUsNumber);
        selectTypeGPU(typeGPU);
        return this;
    }

    public CalculatorPage selectLocalSSD(String localSSD) {
        localSSDDropDown.click();
        selectParameter(localSSDList, localSSD);
        return this;
    }

    public CalculatorPage sendEmail(){
        initWait(sendEmailButton);
        sendEmailButton.click();
        return this;
    }

    public CalculatorPage selectDataCenterLocation(String dataCenterLocation) {
        dataCenterLocationDropDown.click();
        selectParameter(dataCenterLocationList, dataCenterLocation);
        return this;
    }

    public CalculatorPage selectCommitedUsage(String commitedUsage) {
        commitedUsageDropDown.click();
        selectParameter(commitedUsageList, commitedUsage);
        return this;
    }

    public CalculatorPage inputEmail(String email){
        initWait(emailForm);
        emailForm.sendKeys(email);
        return this;
    }

    private void selectParameter(List<WebElement> parameters, String parameter) {
        initWait(parameters.get(0));
        for(WebElement webElement: parameters) {
            if(webElement.getText().contains(parameter)) {
                webElement.click();
                break;
            }
        }
    }

    public WebDriver switchToFrame() {
        new WebDriverWait(driver,SIZE_WAIT).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        return driver;
    }

    public WebDriver addToExecute(){
        addToExecuteButton.click();
        return driver;
    }

    public WebDriver emailEstimate(){
        initWait(emailEstimateButton);
        emailEstimateButton.click();
        return driver;
    }

    public WebElement getVMClass(){
        return estimatesParameters.get(1);
    }

    public WebElement getInstanceType() {
        return estimatesParameters.get(2);
    }

    public WebElement getRegion() {
        return estimatesParameters.get(3);
    }

    public WebElement getLocalSSD() {
        return estimatesParameters.get(4);
    }

    public WebElement getCommitmentTerm() {
        return estimatesParameters.get(5);
    }

    public WebElement getCost() {
        return estimatedCost;
    }
}
