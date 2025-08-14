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

import Examination.AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2 stu_wise_unlock_reval;
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
	public void aL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2Test () throws InterruptedException, IOException {
		
	System.out.println("Examination==>Conduction of Examination==> Student Wise Unlock");
		
		stu_wise_unlock_reval = new AL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2(driver);
		test = reports.createTest("aL_Examination_COE_StudentWiseUnlock_RevaluationFlow4_2Test");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		threadWait1();
		HP.EXAMINATION();
		threadWait1();
		
		threadWait1();
		HP.Exam_ConductionOfExamination();
		
		threadWait1();
		stu_wise_unlock_reval.Click_StudentWiseUnlock(); 
		
		threadWait1();
		stu_wise_unlock_reval.Select_College_scheme();
		
		threadWait1();
		stu_wise_unlock_reval.Select_Session();
		
		threadWait1();
		stu_wise_unlock_reval.Select_Semister();
		
		threadWait1();
		stu_wise_unlock_reval.Select_CourseType();
		
		threadWait1();
		stu_wise_unlock_reval.Select_ExamType();
		
		threadWait1();
		stu_wise_unlock_reval.Select_SubExamType();
		
		threadWait1();
		stu_wise_unlock_reval.Select_Course();
		
		threadWait1();
		stu_wise_unlock_reval.Select_StudentType();
		
		threadWait1();
		stu_wise_unlock_reval.Select_Faculty();
		
		threadWait1();
		stu_wise_unlock_reval.Click_Show_btn();
		
		threadWait1();
		stu_wise_unlock_reval.Click_Student_chkBox();
		
		threadWait1();
		stu_wise_unlock_reval.Click_Unlock_btn();
		
		threadWait1();
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Marks Unlock Successfully for Selected Students."; 
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}
