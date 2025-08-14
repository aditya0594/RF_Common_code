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

import Examination.AL_Examination_EM_Grade;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_EM_GradeTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_EM_Grade grade;
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
	public void aL_Examination_EM_GradeTest() throws InterruptedException, IOException {
		
	System.out.println("Examination==>Examination Master => Grade");
		
		grade = new AL_Examination_EM_Grade(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Examination_EM_GradeTest");
		RF_AdminLoginPage.loginPage();
		
		
		threadWait1();
		HP.EXAMINATION();
		
		threadWait1();
		HP.Exam_ExaminationMaster();
		
		threadWait1();
		grade.Click_Grade();
		
		threadWait1();
		grade.Select_College();
		
		threadWait1();
		grade.Select_GradeType();
		
		threadWait1();
		grade.Select_ProgrammeType();
		
		threadWait1();
		grade.Select_SubjectType();
		
		threadWait1();
		grade.Click_ShowBtn();
		
		threadWait1();
		grade.Enter_GradePoint();
		
		threadWait1();
		grade.Enter_MaxMarks();
		
		threadWait1();
		grade.Enter_MinMark();
		
		threadWait1();
		grade.Enter_GradeDescription();
		
		threadWait1();
		grade.Select_Result();
		
		threadWait1();
		grade.Click_Submitbtn();
		
		threadWait2();
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record  Successfully Saved!"; 
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
