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

import Examination.AL_Examination_ME_AbsentStudentEntryFlow05_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_ME_AbsentStudentEntryFlow05_1Test extends BaseClass {
    ExtentReports reports;
    ExtentTest test;
    AL_Examination_ME_AbsentStudentEntryFlow05_1 absentStudentEntry;
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
    public void aL_Examination_ME_AbsentStudentEntryFlow05_1Test() throws InterruptedException, IOException {
        System.out.println("Examination==>Examination Master => Absent Student Entry");
        
        absentStudentEntry = new AL_Examination_ME_AbsentStudentEntryFlow05_1(driver);
        HP = new HomePageAdmin(driver);
        test = reports.createTest("aL_Examination_ME_AbsentStudentEntryFlow05_1Test");
        
        // Login
        RF_AdminLoginPage.loginPage();
        
        // Navigate to Absent Student Entry
        threadWait1();
        HP.EXAMINATION();
        
        threadWait1();
        HP.Exam_MarkEntry();
        
        // Perform Absent Student Entry
        threadWait1();
        absentStudentEntry.Click_AbsentStudentEntry();
        
        threadWait1();
        absentStudentEntry.Select_College();
        
        threadWait1();
        absentStudentEntry.Select_Session();
        
        threadWait1();
        absentStudentEntry.Select_Course();
        
        threadWait1();
        absentStudentEntry.Select_ExamName();
        
        threadWait1();
        absentStudentEntry.Select_ExamSubExam();
        
        threadWait1();
        absentStudentEntry.Select_ExamType();
        
        threadWait1();
        absentStudentEntry.Click_ShowButton();
        
        threadWait1();
        absentStudentEntry.Search_Student();
        
        threadWait1();
        absentStudentEntry.Click_Checkbox();
        
        threadWait1();
        absentStudentEntry.Click_SubmitButton();
        
        // Verify success message
        threadWait1();
        Thread.sleep(5000);
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Absent Student Added Successfully ..."; 
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(2000);
		alert.accept();
		
    }
}
