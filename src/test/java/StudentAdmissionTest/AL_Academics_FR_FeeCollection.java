package StudentAdmissionTest;

import RFCCAcademic.AL_Academic_AP_NewStudent;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseClass;

import java.time.Duration;

import static RFCCAcademic.AL_Academic_AP_NewStudent.loader;

public class AL_Academics_FR_FeeCollection extends BaseClass {

    public AL_Academics_FR_FeeCollection(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    AL_Academic_AP_NewStudent newStudentPage = new AL_Academic_AP_NewStudent(driver);


    By feeCollectionClick = By.linkText("Fee Related");
    By searchCriteriaClick = By.id("select2-ctl00_ContentPlaceHolder1_ddlSearchPanel-container");
    By dropdownInput = By.xpath("//input[@class='select2-search__field']");
    By searchString= By.id("ctl00_ContentPlaceHolder1_txtSearchPanel");
    By clickOnSearchStudentTable = By.xpath("//a[@id='ctl00_ContentPlaceHolder1_lvStudentPanel_ctrl0_lnkIdPanel']");

    public void feeCollections() {
        System.out.println("Feecollection option selected");
        clickBy(feeCollectionClick);
        loader();
    }


    public void searchCriteriaSelect() throws InterruptedException {
        System.out.println("Search criteria option selected");
        waitUntilElementIsClickableBy(searchCriteriaClick);
        dropdownByEnter(searchCriteriaClick, dropdownInput, "NAME");
        Thread.sleep(1000);


    }

    public void SearchStringStudentName(String StudentName) throws InterruptedException {
        System.out.println("Enter the student name  : "+ StudentName);
       sendKeysBy(searchString,StudentName);

    }
    By searchBtn = By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnSearchPanel']");
    public void searchBtn() {
        System.out.println("Click on the search button");
        waitUntilElementIsClickableBy(searchBtn);
        clickBy(searchBtn);
    }
    public AL_Academics_FR_FeeCollection clickonSearchedStudent() {
        loader();
        System.out.println("Click on the searched Student Name");
        waitUntilElementIsClickableBy(clickOnSearchStudentTable);
        clickBy(clickOnSearchStudentTable);
        return this;
    }

    By feecollectionModeClick = By.id("select2-ctl00_ContentPlaceHolder1_ddlMode-container");

    String FeesCollectionMode="Bank Challan/Cheque/Online Payment (NEFT/RTGS)";

    public void feeCollectionModeSelection() throws InterruptedException {
        System.out.println("Fees collection mode selected :  " + FeesCollectionMode );
        waitUntilElementIsClickableBy(feecollectionModeClick);
        dropdownByEnter(feecollectionModeClick, dropdownInput, FeesCollectionMode);
        Thread.sleep(1000);
        loader();
    }

    String PayType="ONLINE";
    By paytypeDropdown = By.xpath("//select[@id='ctl00_ContentPlaceHolder1_ddlPaytype']");

    public void payTypeSelection() throws InterruptedException {
        System.out.println("Pay type selected:  " + FeesCollectionMode );
        waitUntilElementIsClickableBy(paytypeDropdown);
        WebElement ele = driver.findElement(paytypeDropdown);
        Select dropdown = new Select(ele);
        dropdown.selectByVisibleText(PayType);


        Thread.sleep(1000);
       // newStudentPage.loader();
    }

    By amounttextbox = By.id("ctl00_ContentPlaceHolder1_txtTotalAmount");
    By scrolltoblank = By.xpath("//div[@id='ctl00_ContentPlaceHolder1_divFeeItems']//div[@class='row']");

    public void amountTobePaid() throws InterruptedException {
        System.out.println("Enter Amount to be Paid ");
        waitUntilElementIsClickableBy(amounttextbox);
        sendKeysBy(amounttextbox,"1");
        Thread.sleep(1000);
     //   newStudentPage.loader();
        scrollIntoElementBy(scrolltoblank);
        clickBy(scrolltoblank);
        Thread.sleep(1000);
    }

    By submitbtn = By.id("ctl00_ContentPlaceHolder1_btnSubmit");
    public void submitButton() throws InterruptedException {
        System.out.println("Click on the submit button ");
        waitForVisibilityBy(submitbtn);
        clickBy(submitbtn);
        acceptAlert();
        Thread.sleep(2000);
    }

//=  =============================Post Admission==========


  By postAdmission  = By.linkText("Post Admission");
    public void postAdmission() {
        System.out.println("Post admission option selected");
        clickBy(postAdmission);
    }


    By sectionsEnrollment  = By.linkText("Section/Enrollment No. Allotment");
    public void sectionEnrollmentSelect() {
        System.out.println("Section enrollment option selected");
        clickBy(sectionsEnrollment);
    }

    By schoolDropdown = By.xpath("//span[@id='select2-ctl00_ContentPlaceHolder1_ddlInsName-container']");

    String SchoolText= "Crescent School of Architecture - Chennai";
    public void schoolInstituteSelect() throws InterruptedException {
        System.out.println("Selected the school Institute :  " + SchoolText );
        waitUntilElementIsClickableBy(schoolDropdown);
        dropdownByEnter(schoolDropdown, dropdownInput, SchoolText);
        Thread.sleep(1000);
    }


    By admissionBatchDrop = By.xpath("//span[@id='select2-ctl00_ContentPlaceHolder1_ddlAdmBatch-container']");

    String AdmissionBatchText= "2024-25";
    public void admissionBatchSelect() throws InterruptedException {
        System.out.println("admission batch select " + AdmissionBatchText);

        Thread.sleep(5000);

        dropdownByEnter(admissionBatchDrop, dropdownInput, AdmissionBatchText);
        Thread.sleep(3000);
        loader();

    }

    By academicYeardrop = By.xpath("//span[@id='select2-ctl00_ContentPlaceHolder1_ddlAcdYear-container']");

    String AcademicText= "2023-2024";
    public void academicYear() throws InterruptedException {
        System.out.println("admission batch select " + AcademicText );
        waitForElementVisible(academicYeardrop);
        waitUntilElementIsClickableBy(academicYeardrop);
        dropdownByEnter(academicYeardrop, dropdownInput, AcademicText);
        Thread.sleep(1000);
        loader();
    }

    By degreeDrop = By.cssSelector("#select2-ctl00_ContentPlaceHolder1_ddlDegree-container");

    String degreeText= "Bachelor of Architecture";
    public void degreedrop() throws InterruptedException {
        System.out.println("admission batch select " + degreeText );
        dropdownByEnter(degreeDrop, dropdownInput, degreeText);
        Thread.sleep(1000);
        loader();
    }

    By programBranchDrop = By.cssSelector("#select2-ctl00_ContentPlaceHolder1_ddlBranch-container");

    String ProgramBranchNext= "Architecture";
    public void programBranch() throws InterruptedException {
        System.out.println("Select the program Branch " + ProgramBranchNext );
        waitUntilElementIsClickableBy(programBranchDrop);
        dropdownByEnter(programBranchDrop, dropdownInput, ProgramBranchNext);
        Thread.sleep(1000);
    }
    By filterBtn = By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnFilter']");
    public void filterButton() throws InterruptedException {
        System.out.println("Click on the filter button ");
        Thread.sleep(3000);
        waitUntilElementIsClickableBy(filterBtn);
        clickBy(filterBtn);
    }

    By filterNameforTable = By.xpath("//input[@id='FilterData']");
    By filterNameForTableSEarchBtn = By.xpath("//div[@class='input-group-addon']");
    public void filterNameForTable(String StudentName) throws InterruptedException {
        System.out.println("Enter the name for the filter :  "+ StudentName);
        waitForVisibilityBy(filterNameforTable);
        sendKeysBy(filterNameforTable,StudentName);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
       // clickBy(filterNameForTableSEarchBtn);
        //driver.switchTo().activeElement().sendKeys(Keys.TAB);


    }

    By RRNOField  = By.xpath("//input[@id='ctl00_ContentPlaceHolder1_lvStudents_ctrl0_txtRollNo']");
    public void enterUnqiueRRNO(String RRNO) throws InterruptedException {
        System.out.println("Entered the RRNO number :  " +RRNO );
//        driver.findElement(By.xpath("//th/span[@id='ctl00_ContentPlaceHolder1_lvStudents_lblDYRRNo']")).click();
//        driver.findElement(By.xpath("//th/span[@id='ctl00_ContentPlaceHolder1_lvStudents_lblDYRRNo']")).sendKeys(Keys.TAB);
        Actions actions = new Actions(driver);
        actions.sendKeys(RRNO).perform();


      //  sendKeysBy(RRNOField,RRNO);
        Thread.sleep(1000);
        waitUntilElementIsClickableBy(SubmitbtnforSectionEnroll);
    }

    By SubmitbtnforSectionEnroll  = By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnSubmit']");
    public void submitSectionEnrollmentEnroll() throws InterruptedException {
        System.out.println("Click on the filter button ");
        waitForVisibilityBy(SubmitbtnforSectionEnroll);
        clickBy(SubmitbtnforSectionEnroll);
        acceptAlert();
        Thread.sleep(1000);
    }

    By adminProfile = By.xpath("//p[@id='ctl00_noimghead']");
    By logoutbtn = By.xpath("//i[@class='fas fa-power-off']");
    public void adminLogout() throws InterruptedException {
        System.out.println("Logout the admin" );
        waitUntilElementIsClickableBy(adminProfile);
        clickBy(adminProfile);
        Thread.sleep(1000);
        waitUntilElementIsClickableBy(logoutbtn);
        clickBy(logoutbtn);
    }







}
