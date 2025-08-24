package StudentAdmissionTest.pages;

import RFCCAcademic.AL_Academic_AP_NewStudent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.BaseClass;

import java.time.Duration;

import static RFCCAcademic.AL_Academic_AP_NewStudent.loader;
import static StudentAdmissionTest.pages.AL_Academic_AP_NewStudent_StudentFlow_Flow_01.sendKeysBy;
import static StudentAdmissionTest.pages.AL_Academic_AP_NewStudent_StudentFlow_Flow_01.waitUntilElementIsClickableBy;

public class AL_Academic_PA_DemandCreation_StudentFlow_Flow_02 extends BaseClass {
    public AL_Academic_PA_DemandCreation_StudentFlow_Flow_02(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    By singleStudentDemandClick = By.xpath("//a[@href='#tab_2']");
    By searchCriteriaClick = By.xpath("//span[@id='select2-ctl00_ContentPlaceHolder1_ddlSearch-container']");
    By searchname = By.id("ctl00_ContentPlaceHolder1_txtSearch");
    By searchbutton = By.id("ctl00_ContentPlaceHolder1_btnSearch");
    By clickOnSearchStudent = By.xpath("//a[@id='ctl00_ContentPlaceHolder1_lvStudent_ctrl0_lnkId']");
    By demandVerifyText = By.xpath("//*[contains(text(),'CREATED')]");
    By createDemandbutton = By.id("ctl00_ContentPlaceHolder1_btnCreateDemand");
    By semesterselectDemandDropdown = By.xpath("//span[@id='select2-ctl00_ContentPlaceHolder1_ddlForSemesterN-container']");
    By receptTypeSelectdemandDropDown = By.xpath("//span[@id='select2-ctl00_ContentPlaceHolder1_ddlRecType-container']");
    By dropdownInput = By.xpath("//input[@class='select2-search__field']");
    public AL_Academic_PA_DemandCreation_StudentFlow_Flow_02 singleStudentDemand() {
        System.out.println("Click on the single student demand option");
        waitUntilElementIsClickableBy(singleStudentDemandClick);
        clickBy(singleStudentDemandClick);
        return this;
    }

    public void searchCreatria() throws InterruptedException {
        System.out.println("Search By name ");
        waitUntilElementIsClickableBy(searchCriteriaClick);
        dropdownByEnter(searchCriteriaClick, dropdownInput, "NAME");
        Thread.sleep(1000);
    }

    public void searchStringName(String name) {
        System.out.println("Enter Student name: " + name);
        loader();
        waitUntilElementIsClickableBy(searchname);
        sendKeysBy(searchname, name);
        driver.findElement(searchname).sendKeys(Keys.TAB);
    }

    public AL_Academic_PA_DemandCreation_StudentFlow_Flow_02 searchBtn() {
        System.out.println("Click on the search button");
        waitUntilElementIsClickableBy(searchname);
        clickBy(searchbutton);
        //loader();
        return this;
    }

    public AL_Academic_PA_DemandCreation_StudentFlow_Flow_02 clickonSearchStudent() {
        System.out.println("Click on the searched Student Name");
        waitUntilElementIsClickableBy(clickOnSearchStudent);
        clickBy(clickOnSearchStudent);
        return this;
    }

    public void verifyDemandStatus() throws InterruptedException {
        System.out.println("Verify the demand status");
        Thread.sleep(1000);
        String demandStatus = driver.findElement(demandVerifyText).getText();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(demandVerifyText));
        Assert.assertEquals(demandStatus, "CREATED");
    }

    @FindBy(linkText = "Demand Creation")
    private WebElement demandCreation;

    public AL_Academic_PA_DemandCreation_StudentFlow_Flow_02 demandCreationMenu() {
        System.out.println("Demand creation option selected");
        demandCreation.click();
        return this;
    }


    @FindBy(linkText = "Pre Admission")
    private WebElement preAdmission;
    public AL_Academic_PA_DemandCreation_StudentFlow_Flow_02 preAdmission() {
        System.out.println("Pre Admission option selected");
        preAdmission.click();
        return this;
    }


    By Sessiontitle = By.id("ctl00_ContentPlaceHolder1_lblDYddlSession_Tab");

    public void sessiontitle() {
        //clickBy(Sessiontitle);
        WebElement element = driver.findElement(By.xpath("(//span[@class='select2-selection select2-selection--single'] //*[normalize-space()='Please Select'])[10]"));
        Actions actions = new Actions(driver);
        actions.click(element).build().perform();
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();", element);
        //clickBy(sessionfield);
    }
    public void CreateDemandbutton() throws InterruptedException {
        System.out.println("Click on the create demand button");
        waitUntilElementIsClickableBy(createDemandbutton);
        scrollIntoElementBy(createDemandbutton);
        clickBy(createDemandbutton);
        /*Alert alert = driver.switchTo().alert();
        String Expected_Msg = "Demand successfully created for selected students";
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);]
        alert.accept();*/
        acceptAlert();
    }

    public void sessionSelectiondemand(String sessionTypeFieldtext) throws InterruptedException {

        System.out.println("Selecting Admission category: " + sessionTypeFieldtext);
        By element = By.xpath("(//span[@class='select2-selection select2-selection--single'] //*[normalize-space()='Please Select'])[10]");
        clickBy(element);
        dropdownByEnter(element, dropdownInput, sessionTypeFieldtext);
        clickBy(semesterselectDemandDropdown);

    }

    String semestertxt = "I";
    public void semesterselectDemand() throws InterruptedException {

        Thread.sleep(1000);

        System.out.println("Selecting Admission category: " + semestertxt);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(semesterselectDemandDropdown));
        clickBy(semesterselectDemandDropdown);
        dropdownByEnter(semesterselectDemandDropdown, dropdownInput, semestertxt);
        // clickBy(receptTypeSelectdemandDropDown);
        WebElement element1 = driver.findElement(By.xpath("(//i[@class='fa fa-angle-down'])[15]"));
        waitUntilElementIsClickable(element1);
        Thread.sleep(1000);

    }

    String receiptSelectText = "Admission Fee";

    public void receptTypeSelectdemand() throws InterruptedException {
        System.out.println("Selecting Recept Type: receiptSelectText ");
        WebElement element = driver.findElement(By.xpath("(//i[@class='fa fa-angle-down'])[15]"));
        Actions action = new Actions(driver);
        Thread.sleep(1000);
        action.moveToElement(element).click().perform();
        action.moveToElement(element).click().perform();
        Thread.sleep(1000);
        System.out.println("Selecting Admission category: " + receiptSelectText);

        Thread.sleep(1000);
        dropdownByEnter(receptTypeSelectdemandDropDown, dropdownInput, receiptSelectText);
    }


}
