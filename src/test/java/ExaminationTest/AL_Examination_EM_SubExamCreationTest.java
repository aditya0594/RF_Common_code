package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Examination.AL_Examination_EM_SubExamCreation;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_EM_SubExamCreationTest extends BaseClass
{
    ExtentReports reports;
    ExtentTest test;
    AL_Examination_EM_SubExamCreation subExamCreation;
    HomePageAdmin HP;
    
    @BeforeClass
    public void configuration() {
        reports = Reports.createReport();
    }
    
    @BeforeMethod
    public void launchBrowser(Method m) throws Exception {
        driver = Browser.openBrowser("url_RF_LoginAdmin");
        System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
    }
    
    @Test
    public void aL_Examination_EM_SubExamCreationTest() throws InterruptedException, IOException {
        
        System.out.println("Examination==>Examination Master => Sub Exam Creation");
        
        subExamCreation = new AL_Examination_EM_SubExamCreation(driver);
        HP = new HomePageAdmin(driver);
        test = reports.createTest("aL_Examination_EM_SubExamCreationTest");
        RF_AdminLoginPage.loginPage();
        
        threadWait1();
        HP.EXAMINATION();
        
        threadWait1();
        HP.Exam_ExaminationMaster();
        
        threadWait1();
        subExamCreation.Click_SubExamCreation();
        
        threadWait1();
        subExamCreation.Click_EditButton();
        
        threadWait1();
        subExamCreation.Set_MaxMarks();
        
        threadWait1();
        subExamCreation.Click_SaveButton();
        
        threadWait2();
        Alert alert = driver.switchTo().alert();
        String Expected_Msg = "Sub Exam Updated Successfully.";
        String Actual_Msg = alert.getText();
        System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
        alert.accept();
    }
}
