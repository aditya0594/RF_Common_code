package StudentAdmissionTest.pages;

import StudentAdmissionTest.AL_Academics_FR_FeeCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utility.BaseClass;

import static RFCCAcademic.AL_Academic_AP_NewStudent.loader;
import static StudentAdmissionTest.pages.AL_Academic_AP_NewStudent_StudentFlow_Flow_01.*;

public class AL_Academic_FR_FeeCollection_StudentFlow_Flow_03 extends BaseClass {
    public AL_Academic_FR_FeeCollection_StudentFlow_Flow_03(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }



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
        Thread.sleep(1000);
        sendKeysBy(searchString,StudentName);

    }
    By searchBtn = By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnSearchPanel']");
    public void searchBtn() {
        System.out.println("Click on the search button");
        waitUntilElementIsClickableBy(searchBtn);
        clickBy(searchBtn);
    }
    public AL_Academic_FR_FeeCollection_StudentFlow_Flow_03 clickonSearchedStudent() {
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

}
