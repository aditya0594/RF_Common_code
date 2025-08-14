package ExaminationTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Examination.AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2;

import com.qa.pages.HomePageAdmin;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2 absent_entry;
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
	public void aL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2Test () throws InterruptedException, IOException {
		
	System.out.println("Examination==>Conduction of Examination==> Remove Absent IGrade Entry");
		
		absent_entry = new AL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2(driver);
		test = reports.createTest("aL_Examination_COE_RemoveAbsentIGradeEntryFlow01_2Test ");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		threadWait1();
		HP.EXAMINATION();
		threadWait1();
		

		threadWait1();
		HP.Exam_ConductionOfExamination();
		
		threadWait1();
		absent_entry.Click_RemoveAbsentIGradeEntry();
		
		threadWait1();
		absent_entry.Select_College_scheme();
		
		threadWait1();
		absent_entry.Select_Session();
		
		threadWait1();
		absent_entry.Select_Semister();
		
		threadWait1();
		absent_entry.Select_Course();
		
		threadWait1();
		absent_entry.Select_Entry();
		
		Thread.sleep(5000);
		absent_entry.Click_Show_btn();
		
		threadWait1();
		absent_entry.Click_IGrade_chkBox();
		
		Thread.sleep(5000);
		absent_entry.Click_Save_btn();
		
		Thread.sleep(5000);
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Grade Removed Successfully!"; 
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
	}
}
