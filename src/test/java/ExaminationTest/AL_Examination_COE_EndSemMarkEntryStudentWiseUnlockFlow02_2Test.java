package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Examination.AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2;
import com.qa.pages.HomePageAdmin;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2 stu_wise_unlock;
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
	public void aL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2Test () throws InterruptedException, IOException {
		
	System.out.println("Examination==>Conduction of Examination==> Student Wise Unlock");
		
		stu_wise_unlock = new AL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2(driver);
		test = reports.createTest("aL_Examination_COE_EndSemMarkEntryStudentWiseUnlockFlow02_2Test");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.EXAMINATION();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		HP.Exam_ConductionOfExamination();
		
		Thread.sleep(2000);
		stu_wise_unlock.Click_StudentWiseUnlock(); 
		
		Thread.sleep(2000);
		stu_wise_unlock.Select_College_scheme();
		
		Thread.sleep(2000);
		stu_wise_unlock.Select_Session();
		
		Thread.sleep(2000);
		stu_wise_unlock.Select_Semister();
		
		Thread.sleep(2000);
		stu_wise_unlock.Select_CourseType();
		
		Thread.sleep(2000);
		stu_wise_unlock.Select_ExamType();
		
		Thread.sleep(2000);
		stu_wise_unlock.Select_SubExamType();
		
		Thread.sleep(2000);
		stu_wise_unlock.Select_Course();
		
		Thread.sleep(2000);
		stu_wise_unlock.Select_StudentType();
		
		Thread.sleep(2000);
		stu_wise_unlock.Select_Faculty();
		
		Thread.sleep(2000);
		stu_wise_unlock.Click_Show_btn();
		
		Thread.sleep(2000);
		stu_wise_unlock.Click_Student_chkBox();
		
		Thread.sleep(2000);
		stu_wise_unlock.Click_Unlock_btn();
		
		Thread.sleep(2000);
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Marks Unlock Successfully for Selected Students."; 
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
