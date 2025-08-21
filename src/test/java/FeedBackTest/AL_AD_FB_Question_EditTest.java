package FeedBackTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;
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

public class AL_AD_FB_Question_EditTest extends BaseClass {


    ExtentReports reports;
    ExtentTest test;
    HomePageAdmin HP;
    HomePageAdmin homePageAdmin;
    PDFUtility pdfutility;

    AL_AD_FB_Type_Master_Add_edit feedback;
    AL_AD_FB_Question question;
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
    @Test(priority = 1, enabled = true)
    public void feedbackQuestions() throws Exception {

        feedback = new AL_AD_FB_Type_Master_Add_edit(driver);
        question = new AL_AD_FB_Question(driver);
        test = reports.createTest("AL_FeedBack_Question");
        HP = new HomePageAdmin(driver);
        // Set data row to use for this test
        //ewStudentPage.setDataRow(dataRow);
        Thread.sleep(4000);
        RF_AdminLoginPage.loginPage();
        HP.Academic();
        feedback.feedbackSelect();
        question.feedBackQuestion();
        String feedbackNameFromExcel = ExcelUtility.getLastValueFromColumn("src/test/resources/Excel/FeedBackExcel.xlsx", "FeedbackName");
        System.out.println("Student name extracted from Excel: " + feedbackNameFromExcel);
        question.setFeedbackQuestionTypeSelect(feedbackNameFromExcel);
        question.feedBackQuestionFieldAdd("This is the question for the test automation ");
        question.setAnsOptionType("Objective");
        question.sequenceField("1");
        question.headQuestion("Assessment of Support Services");
        question.answerOpt("Yes","1","No","2");
        question.submitbtn();
//        Thread.sleep(1000);
//        Alert alert =  driver.switchTo().alert();
//        String Expected_Msg = "Feedback Question Saved Successfully";
//        String Actual_Msg = alert.getText();
//        Assert.assertEquals(Actual_Msg , Expected_Msg );
//        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
//        alert.accept();

    }


}
