package FeedBackTest;

import Administration.AL_Administration_FM_Rpt_MR_CompleteFilesReport;
import RFCCAcademic.SL_Academic_SR_StudentInformation;
import StudentAdmissionTest.SL_Academic_SR_SI_QualificationDetails;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.PDFUtility;
import utility.Reports;

import java.lang.reflect.Method;

public class AL_AD_FB_Type_Master_EditTest extends BaseClass {


    ExtentReports reports;
    ExtentTest test;
    HomePageAdmin HP;
    HomePageAdmin homePageAdmin;
    PDFUtility pdfutility;

    AL_AD_FB_Type_Master_Add_edit feedback;
    SL_Academic_SR_StudentInformation studentInfoPage;
    SL_Academic_SR_SI_QualificationDetails qualificationdetails;
    AL_Administration_FM_Rpt_MR_CompleteFilesReport aL_Administration_FM_Rpt_MR_CompleteFilesReport;

    @BeforeClass
    public void configuration() {
        reports = Reports.createReport();
    }

    @BeforeMethod
    public void launchBrowser(Method m) throws Exception {
        driver = Browser.openBrowser("url_RF_LoginAdmin");

        System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
    }

    @AfterMethod
    public void closeBrowser() {
//        if (driver != null) {
//            driver.quit();
//        }
    }
    String feedBackTypetext = "Feedback Level automation" + Random4DigitString();

    //  Excel/FeedBackExcel.xlsx

    @Test(priority = 1, enabled = true)
    public void FeedBack_edit() throws Exception {

        feedback = new AL_AD_FB_Type_Master_Add_edit(driver);
        test = reports.createTest("AL_FeedBack_Type_Master_Add_edit_Test");
        HP = new HomePageAdmin(driver);
        // Set data row to use for this test
        //ewStudentPage.setDataRow(dataRow);
        Thread.sleep(4000);
        RF_AdminLoginPage.loginPage();
        HP.Academic();
        feedback.feedbackSelect();
        feedback.FeedbackMasterSelect();
        //feedback.searchBox("Feedback Level automation4492");
        String feedbackNameFromExcel = ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/FeedBackExcel.xlsx", "FeedbackName");
        System.out.println("Student name extracted from Excel: " + feedbackNameFromExcel);
        feedback.searchBox(feedbackNameFromExcel);
        feedback.editBtn();
        feedback.feedBackTypeSelectedit(feedbackNameFromExcel+"_edited");
        feedback.feedBackModeSelect("Course Teacher");
        feedback.CourseType();
        feedback.addNote("This is a test note. Added by Automation edited");
        feedback.submitbtn();
        Thread.sleep(1000);
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Record Updated Successfully!";
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();

    }
}
