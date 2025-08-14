package ExaminationTest;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Examination.AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2;

import com.qa.pages.HomePageAdmin;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2Test extends BaseClass
{
    ExtentReports reports;
    ExtentTest test;
    AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2 backlogStudentWiseUnlock;
    HomePageAdmin HP;
    PDFUtility pdfutility;
    
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
    public void aL_Examination_COE_BacklogStudentWiseUnlockFlow03_2Test() throws InterruptedException, IOException, AWTException {
        
        System.out.println("Examination==>COE==> Student Wise Unlock");
        
        backlogStudentWiseUnlock = new AL_Examination_COE_BacklogStudentWiseUnlockFlow03_2(driver);
        pdfutility = new PDFUtility(driver);    
        test = reports.createTest("aL_Examination_COE_BacklogStudentWiseUnlockFlow03_2Test");
        
        RF_AdminLoginPage.loginPage();
        
        threadWait1();
        HP = new HomePageAdmin(driver);
        Thread.sleep(2000);
        HP.EXAMINATION();
        Thread.sleep(2000);
        
        threadWait1();
        HP.Exam_ConductionOfExamination();
        
        threadWait1();
        backlogStudentWiseUnlock.Click_StudentWiseUnlock();
        
        threadWait1();
        backlogStudentWiseUnlock.Select_College();
        
        threadWait1();
        backlogStudentWiseUnlock.Select_Session();
        
        threadWait1();
        backlogStudentWiseUnlock.Select_Semester();
        
        threadWait1();
        backlogStudentWiseUnlock.Select_SubjectType();
        
        threadWait1();
        backlogStudentWiseUnlock.Select_ExamType();
        
        threadWait1();
        backlogStudentWiseUnlock.Select_SubExam();
        
        threadWait1();
        backlogStudentWiseUnlock.Select_Course();
        
        threadWait1();
        backlogStudentWiseUnlock.Select_StudentType();
        
        threadWait1();
        backlogStudentWiseUnlock.Select_Faculty();
        
        threadWait1();
        backlogStudentWiseUnlock.Click_Show();
        
        threadWait1();
        backlogStudentWiseUnlock.Select_Student();
        
        threadWait1();
        backlogStudentWiseUnlock.Click_Unlock();
        
        threadWait1();
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Marks Unlocked Successfully for Selected Students."; 
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		threadWait1();
		alert.accept();
    }
}
