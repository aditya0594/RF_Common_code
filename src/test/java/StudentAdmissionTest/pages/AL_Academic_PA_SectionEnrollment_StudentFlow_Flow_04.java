package StudentAdmissionTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

import static StudentAdmissionTest.pages.AL_Academic_AP_NewStudent_StudentFlow_Flow_01.*;

public class AL_Academic_PA_SectionEnrollment_StudentFlow_Flow_04 extends BaseClass {

    public AL_Academic_PA_SectionEnrollment_StudentFlow_Flow_04(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }


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
    By dropdownInput = By.xpath("//input[@class='select2-search__field']");
    By schoolDropdown = By.xpath("//span[@id='select2-ctl00_ContentPlaceHolder1_ddlInsName-container']");

    String SchoolText= "Crescent School of Architecture - Chennai";
    public void schoolInstituteSelect() throws InterruptedException {
        System.out.println("Selected the school Institute :  " + SchoolText );
        Thread.sleep(3000);
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

    }

    By academicYeardrop = By.xpath("//span[@id='select2-ctl00_ContentPlaceHolder1_ddlAcdYear-container']");

    String AcademicText= "2023-2024";
    public void academicYear() throws InterruptedException {
        System.out.println("admission batch select " + AcademicText );
        dropdownByEnter(academicYeardrop, dropdownInput, AcademicText);
        Thread.sleep(1000);
    }

    By degreeDrop = By.cssSelector("#select2-ctl00_ContentPlaceHolder1_ddlDegree-container");

    String degreeText= "Bachelor of Architecture";
    public void degreedrop() throws InterruptedException {
        System.out.println("admission batch select " + degreeText );
        Thread.sleep(6000);
        waitUntilElementIsClickableBy(degreeDrop);
        dropdownByEnter(degreeDrop, dropdownInput, degreeText);
        Thread.sleep(6000);
    }

    By programBranchDrop = By.xpath("//span[@class='select2-selection select2-selection--single'] //*[@id='select2-ctl00_ContentPlaceHolder1_ddlBranch-container']");

    String ProgramBranchNext= "Architecture";
    public void programBranch() throws InterruptedException {
        System.out.println("Select the program Branch : " + ProgramBranchNext );
        Thread.sleep(6000);
        Actions actions = new Actions(driver);
        WebElement ele = driver.findElement(programBranchDrop);
        actions.sendKeys(Keys.SPACE).perform();
        actions.click(ele).perform();
        dropdownByEnter(programBranchDrop, dropdownInput, ProgramBranchNext);
        Thread.sleep(6000);
    }
    By filterBtn = By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnFilter']");
    public void filterButton() throws InterruptedException {
        System.out.println("Click on the filter button ");
        Thread.sleep(3000);
        //  waitUntilElementIsClickableBy(filterBtn);
        clickBy(filterBtn);
    }

    By filterNameforTable = By.xpath("//input[@id='FilterData']");
    By filterNameForTableSEarchBtn = By.xpath("//div[@class='input-group-addon']");
    public void filterNameForTable(String StudentName) throws InterruptedException {
        System.out.println("Enter the name for the filter :  "+ StudentName);
        waitForVisibilityBy(filterNameforTable);
        sendKeysBy(filterNameforTable,StudentName);
        Actions actions = new Actions(driver);
        //actions.sendKeys(Keys.TAB).perform();
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
